package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalAST.AstProgram;
import MentalAST.BuildTreeListener;
import MentalIR.*;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Data.IRDataValue;
import MentalParser.*;
import MentalTranslator.BasicBlockSpliter;
import MentalTranslator.MIPSFunctions;
import MentalTranslator.MIPSProgram;
import MentalTranslator.MIPSStaticData;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.Random;

public class Main {
    public static Random globalRandom = new Random();
    public static void main(String[] args) throws IOException {
        FileInputStream builtInFunction = null;
        FileInputStream builtInMips = null;
        try {
            builtInFunction = new FileInputStream("src/built_in.mx");
            builtInMips = new FileInputStream("src/mips_built_in.s");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TokenStream tokens = null;
        try {
            if (args.length >= 1) {
                FileInputStream sourceFile = new FileInputStream(args[0]);
                InputStream seqStream = new SequenceInputStream(builtInFunction, sourceFile);
                tokens = new CommonTokenStream(new MentalLexer(new ANTLRInputStream(seqStream)));
            } else {
                InputStream seqStream = new SequenceInputStream(builtInFunction, System.in);
                tokens = new CommonTokenStream(new MentalLexer(new ANTLRInputStream(seqStream)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MentalParser parser = new MentalParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        MentalParser.ProgramContext programContext = parser.program();
        BuildTreeListener listener = new BuildTreeListener();
        walker.walk(listener, programContext);
        AstProgram astProgram = (AstProgram) listener.tree.get(programContext);
        if (listener.existError) {
            System.exit(1);
        }

//        System.out.println(astProgram.toPrintString());
//        System.exit(0);
        AstVisitor visitor = new AstVisitor();
        visitor.visitProgram(astProgram);

        MIPSProgram mipsProgram = new MIPSProgram();
        MIPSStaticData mipsStaticData = mipsProgram.staticData;

        for (IRDataStringLiteral irStringLiteral : visitor.stringLiterals) {
            mipsStaticData.translate(irStringLiteral);
        }

        for (IRDataValue irVariable : visitor.globalVariables) {
            mipsStaticData.translate(irVariable);
        }

        for (IRInstruction instruction : visitor.globalVariableInitialize) {
            mipsProgram.globalInitialize.translate(instruction);
        }

        for (int i = 0, count = visitor.functionInstructionLists.size(); i < count; ++i) {
            mipsProgram.functions.add(new MIPSFunctions());
            BasicBlockSpliter basicBlockSpliter = new BasicBlockSpliter(visitor.functionInstructionLists.get(i));
            mipsProgram.functions.getLast().translate(visitor.functionStackSize.get(i), basicBlockSpliter);
        }
        System.out.println(mipsProgram);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(builtInMips));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            System.out.println(line);
        }
    }
}

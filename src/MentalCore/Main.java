package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalAST.AstProgram;
import MentalAST.BuildTreeListener;
import MentalIR.AstVisitor;
import MentalIR.IRLabelGlobalData;
import MentalIR.IRStringLiteral;
import MentalIR.IRVariable;
import MentalParser.*;
import MentalTranslator.MIPSStaticData;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileInputStream builtInFunction = null;
        try {
            builtInFunction = new FileInputStream("src/built_in.mx");
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
        AstVisitor visitor = new AstVisitor();
        visitor.visitProgram(astProgram);

        System.out.println(listener.globalVariableCounter);

        MIPSStaticData mipsStaticData = new MIPSStaticData();

        for (IRStringLiteral irStringLiteral : visitor.stringLiterals) {
            mipsStaticData.append(irStringLiteral);
        }

        for (IRVariable irVariable : visitor.globalVariables) {
            mipsStaticData.append(irVariable);
        }

        for (String statement : mipsStaticData.mipsStatements) {
            System.out.println(statement);
        }
    }
}

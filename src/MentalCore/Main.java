package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalAST.AstProgram;
import MentalAST.BuildTreeListener;
import MentalIR.AstVisitor;
import MentalIR.IRStringLiteral;
import MentalParser.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.LinkedList;

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
        System.out.println("String Literals:");
        for (IRStringLiteral stringLiteral : visitor.stringLiterals) {
            System.out.println(String.format("\t%%%d:%s", stringLiteral.label.labelID, stringLiteral.context));
        }
    }
}

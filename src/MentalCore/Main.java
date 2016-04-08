package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalAST.BuildTreeListener;
import MentalParser.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TokenStream tokens = null;
        try {
            if (args.length >= 1) {
                tokens = new CommonTokenStream(new MentalLexer(new ANTLRFileStream(args[0])));
            } else {
                tokens = new CommonTokenStream(new MentalLexer(new ANTLRInputStream(System.in)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MentalParser parser = new MentalParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        MentalParser.ProgramContext programContext = parser.program();
        BuildTreeListener listener = new BuildTreeListener();
        walker.walk(listener, programContext);
        if (listener.existError) {
            System.exit(1);
        }
        if (args.length >= 1) {
            System.out.println(listener.tree.get(programContext).toPrettyPrint());
        }
    }
}

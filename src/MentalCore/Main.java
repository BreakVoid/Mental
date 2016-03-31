package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalAST.BuildTreeListener;
import MentalParser.*;
import MentalSymbols.SymbolBase;
import MentalSymbols.SymbolFunction;
import MentalSymbols.SymbolTable;
import MentalSymbols.SymbolType;
import MentalType.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.misc.FlexibleHashMap;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static MentalParser.MentalParser.*;

public class Main {
    public static void main(String[] args) {
        TokenStream tokens = null;
        try {
            tokens = new CommonTokenStream(new MentalLexer(new ANTLRFileStream(args[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MentalParser parser = new MentalParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        MentalParser.ProgramContext programContext = parser.program();
        BuildTreeListener listener = new BuildTreeListener();
        walker.walk(listener, programContext);
        for (Map.Entry<String, SymbolBase> entry : listener.curSymbolTable.getTable().entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println(listener.tree.get(programContext).toPrintString());
    }
}

package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalParser.*;
import MentalSymbols.SymbolType;
import MentalType.MentalClass;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.tree.CommonTree;
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
        PrintListener listener = new PrintListener();
        walker.walk(listener, parser.classDeclaration());
        System.out.println(((MentalClass)(((SymbolType)listener.symbolTable.table.get("AClass")).type)).classComponents);
    }
}

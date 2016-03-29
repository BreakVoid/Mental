package MentalCore;

/**
 * Created by Songyu on 16/3/28.
 */

import MentalParser.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static MentalParser.MentalParser.*;

public class Main {
    public static void main(String[] args) {
        TokenStream tokens = null;
        try {
            tokens = new CommonTokenStream(new MentalLexer(new ANTLRFileStream("basic_test.mt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MentalParser parser = new MentalParser(tokens);
        ProgramContext tree = parser.program();
        for (DeclarationContext decl : tree.declaration()) {
            System.out.println(decl.toStringTree(parser));
        }
        List<MentalParser.DefinitionContext> definition;
        definition = tree.definition();
        for (int i = 0, definitionSize = definition.size(); i < definitionSize; i++) {
            MentalParser.DefinitionContext decl = definition.get(i);
            if (decl.variableDefinition() == null) {
                System.out.println("Not a var def");
            }
        }
    }
}

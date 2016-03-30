package MentalAST;

import MentalParser.MentalParser;
import MentalSymbols.SymbolVariable;
import MentalSymbols.SymbolVariableList;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTVariableDeclaration extends ASTBaseNode {
    public List<ASTSingleVariableDeclaration> variables;
    public ASTVariableDeclaration() {
        this.variables = null;
    }
    @Override
    public String toString() {
        String ret = "(";
        for (ASTSingleVariableDeclaration variable : variables) {
            ret += variable.toString() + ' ';
        }
        ret += ")";
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTVariableDeclaration) {
                if (this.variables.equals(((ASTVariableDeclaration) other).variables)) {
                    return true;
                }
            }
        }
        return false;
    }

}

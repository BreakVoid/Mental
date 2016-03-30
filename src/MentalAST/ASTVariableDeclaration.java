package MentalAST;

import MentalSymbols.SymbolVariable;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTVariableDeclaration extends ASTBaseNode {
    public List<SymbolVariable> variables;
    public ASTVariableDeclaration() {
        this.variables = null;
    }
    @Override
    public String toString() {
        String ret = "<variables>{";
        for (Iterator<SymbolVariable> it = variables.iterator(); it.hasNext(); ) {
            ret += it.next().toString() + ',';
        }
        ret += "}";
        return ret;
    }
    @Override
    public boolean equals(Object other) {
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

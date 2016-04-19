package MentalAST.AstExpression;

import MentalAST.AstVariable;
import MentalSymbols.SymbolBase;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstIdentifier extends AstExpression {
    public String name;
    public AstVariable variable;
    public AstIdentifier() {
        this.name = "";
        this.returnType = SymbolTable.mentalUnknownType;
        this.variable = null;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<identifier>" + this.variable.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstIdentifier) {
                if (this.name.equals(((AstIdentifier) other).name)) {
                    return true;
                }
            }
        }
        return false;
    }
}

package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstIdentifier extends AstExpression {
    public String name;
    public AstIdentifier() {
        this.name = "";
        this.returnType = SymbolTable.mentalUnknownType;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<identifier>" + this.name + "@" + this.returnType.toString();
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + this.name;
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

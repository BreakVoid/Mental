package MentalAST.AstExpression;

import MentalAST.AstBaseNode;
import MentalSymbols.SymbolTable;
import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class AstExpression extends AstBaseNode {
    public boolean leftValue;
    public MentalType returnType;
    public AstExpression() {
        this.leftValue = false;
        this.returnType = SymbolTable.mentalUnknownType;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<expression>:" + returnType.toString();
    }
    @Override
    public String toString() {
        return "<childExpression>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstExpression) {
                if (this.returnType.equals(((AstExpression) other).returnType)) {
                    return true;
                }
            }
        }
        return false;
    }
}

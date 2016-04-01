package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstNullConstant extends AstExpression {
    public AstNullConstant() {
        this.returnType = SymbolTable.mentalNull;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<null>";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof AstNullConstant) {
                return true;
            }
        }
        return false;
    }
}

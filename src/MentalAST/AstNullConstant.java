package MentalAST;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstNullConstant extends AstExpression {
    public AstNullConstant() {
        this.returnType = SymbolTable.mentalNull;
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

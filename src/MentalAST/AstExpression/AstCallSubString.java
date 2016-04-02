package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallSubString extends AstBinaryExpression {
    public AstCallSubString() {
        this.returnType = SymbolTable.mentalString;
    }
}

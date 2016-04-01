package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstBitNotExpression extends AstUnaryExpression {
    public AstBitNotExpression() {
        this.childExpression = null;
        this.returnType = SymbolTable.mentalInt;
    }
}

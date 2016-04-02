package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallToString extends AstUnaryExpression {
    public AstCallToString() {
        this.returnType = SymbolTable.mentalString;
    }
}

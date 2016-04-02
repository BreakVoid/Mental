package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallOrd extends AstUnaryExpression {
    public AstCallOrd() {
        this.returnType = SymbolTable.mentalInt;
    }
}

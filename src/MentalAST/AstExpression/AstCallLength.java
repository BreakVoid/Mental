package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallLength extends AstExpression {
    public AstCallLength() {
        this.returnType = SymbolTable.mentalInt;
    }
}

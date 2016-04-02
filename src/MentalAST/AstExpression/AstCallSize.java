package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallSize extends AstExpression {
    public AstCallSize() {
        this.returnType = SymbolTable.mentalInt;
    }
}

package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallGetInt extends AstExpression {
    public AstCallGetInt() {
        this.returnType = SymbolTable.mentalInt;
    }
}

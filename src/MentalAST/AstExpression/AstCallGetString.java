package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallGetString extends AstExpression {
    public AstCallGetString() {
        this.returnType = SymbolTable.mentalString;
    }
}
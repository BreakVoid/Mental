package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallParseInt extends AstExpression {
    public AstCallParseInt() {
        this.returnType = SymbolTable.mentalInt;
    }
}

package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstLogicalNotExpression extends AstUnaryExpression {
    public AstLogicalNotExpression() {
        this.childExpression = null;
        this.returnType = SymbolTable.mentalBool;
    }
}

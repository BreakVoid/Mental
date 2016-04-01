package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstAdditiveExpression extends AstBinaryExpression {
    public int op;
    public static final int ADD = 1;
    public static final int SUB = 2;
    public AstAdditiveExpression() {
        this.op = 0;
        this.leftExpression = this.rightExpression = null;
        this.returnType = SymbolTable.mentalUnknownType;
    }
}

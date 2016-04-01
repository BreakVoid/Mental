package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstMulDivExpression extends AstBinaryExpression {
    public static final int MUL = 1;
    public static final int DIV = 2;
    public static final int MOD = 3;
    public int op;
    public AstMulDivExpression() {
        this.returnType = SymbolTable.mentalInt;
    }
}

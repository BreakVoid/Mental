package MentalAST.AstExpression;

import static MentalSymbols.SymbolTable.mentalInt;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstBitShiftExpression extends AstBinaryExpression {
    public static final int LEFT_SHIFT = 1;
    public static final int RIGHT_SHIFT = 2;
    public int op;
    public AstBitShiftExpression() {
        this.op = 0;
        this.returnType = mentalInt;
    }
}

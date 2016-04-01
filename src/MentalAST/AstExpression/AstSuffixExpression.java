package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstSuffixExpression extends AstExpression {
    public static final int PLUS_PLUS = 1;
    public static final int MINUS_MINUS = 2;
    public AstExpression childExpression;
    public int op;
    public AstSuffixExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalInt;
        this.childExpression = new AstExpression();
    }
}

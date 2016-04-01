package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstPrefixExpression extends AstUnaryExpression {
    public static final int PLUS_PLUS = 1;
    public static final int MINUS_MINUS = 2;
    public int op;
    public AstExpression expression;
    public AstPrefixExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalInt;
        this.expression = new AstExpression();
    }
}

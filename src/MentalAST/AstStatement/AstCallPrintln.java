package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrintln extends AstStatement {
    public AstExpression parameter;
    public AstCallPrintln() {
        this.parameter = null;
    }
}

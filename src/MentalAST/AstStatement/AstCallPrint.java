package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrint extends AstStatement {
    public AstExpression parameter;
    public AstCallPrint() {
        this.parameter = null;
    }
}

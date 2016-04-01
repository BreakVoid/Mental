package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstIfStatement extends AstStatement {
    public AstExpression expression;
    public AstStatement thenStatement;
    public AstStatement elseStatement;
    public AstIfStatement() {
        this.expression = new AstExpression();
        this.thenStatement = new AstStatement();
        this.elseStatement = null;
    }
}

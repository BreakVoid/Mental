package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstExpressionStatement extends AstStatement {
    public AstExpression expression;
    public AstExpressionStatement() {
        this.expression = null;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<expression statment>\n" + this.expression.toPrintString(indent + 1);
    }
}

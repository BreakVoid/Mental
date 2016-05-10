package MentalAST.AstExpression;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/3.
 */
public class AstSuperExpression extends AstExpression {
    public LinkedList<AstExpression> expressions;
    public AstSuperExpression() {
        this.expressions = new LinkedList<>();
    }
}

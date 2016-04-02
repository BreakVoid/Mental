package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstArraySubscriptingExpression extends AstExpression {
    public AstExpression primaryExpression;
    public AstExpression positionExpression;
    public AstArraySubscriptingExpression() {
        this.leftValue = true;
    }
}

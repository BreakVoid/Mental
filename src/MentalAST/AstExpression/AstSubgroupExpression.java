package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstSubgroupExpression extends AstExpression {
    public AstExpression childExpression;
    public AstSubgroupExpression() {
        this.childExpression = null;
    }
}

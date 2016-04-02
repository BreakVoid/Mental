package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstMemberAccessExpression extends AstExpression {
    public AstExpression primaryExpression;
    public AstExpression memberExpression;
    public String memberName;
    public AstMemberAccessExpression() {
        this.primaryExpression = null;
        this.memberExpression = null;
        this.memberExpression = null;
    }
}

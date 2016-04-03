package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstUnaryExpression extends AstExpression {
    public AstExpression childExpression;
    public AstUnaryExpression() {
        this.childExpression = null;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<unknown unary expression>";
    }
}

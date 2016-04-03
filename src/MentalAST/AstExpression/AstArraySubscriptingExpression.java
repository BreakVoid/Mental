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
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<array subscripting expression>:" + this.returnType + "\n";
        ret += addIndent(indent + 1) + "<primary expression>\n" + this.primaryExpression.toPrintString(indent + 2) + "\n";
        ret += addIndent(indent + 1) + "<position expression>\n" + this.positionExpression.toPrintString(indent + 2);
        return ret;
    }
}
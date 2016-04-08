package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstAssignExpression extends AstBinaryExpression {
    public AstAssignExpression() {
        this.leftValue = true;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<assignment expression>:" + this.returnType.toString() + "\n";
        ret += addIndent(indent + 1) + "<left side>\n" + this.leftExpression.toPrintString(indent + 2) + "\n";
        ret += addIndent(indent + 1) + "<right side>\n" + this.rightExpression.toPrintString(indent + 2);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent);
        ret += this.leftExpression.toPrettyPrint() + " = ";
        ret += this.rightExpression.toPrettyPrint();
        return ret;
    }
}

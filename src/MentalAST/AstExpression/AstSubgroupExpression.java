package MentalAST.AstExpression;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstSubgroupExpression extends AstExpression {
    public AstExpression childExpression;
    public AstSubgroupExpression() {
        this.childExpression = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<subgroup expression>:" + this.returnType.toString() + "\n";
        ret += this.childExpression.toPrintString(indent + 1);
        return ret;
    }
}

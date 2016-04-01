package MentalAST.AstExpression;

import MentalAST.AstBaseNode;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstBinaryExpression extends AstExpression {
    public AstExpression leftExpression, rightExpression;
    public AstBinaryExpression() {
        this.leftExpression = new AstExpression();
        this.rightExpression = new AstExpression();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = AstBaseNode.addIndent(indent) + "<expression>:" + this.returnType.toString() + '\n';
        ret += leftExpression.toPrintString(indent + 1) + '\n';
        ret += rightExpression.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstBinaryExpression) {
                if (this.leftExpression.equals(((AstBinaryExpression) other).leftExpression)) {
                    if (this.rightExpression.equals(((AstBinaryExpression) other).rightExpression)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

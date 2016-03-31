package MentalAST;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class AstExpression extends AstBaseNode {
    public MentalType returnType;
    public AstExpression() {
        this.returnType = new MentalType();
    }
    @Override
    public String toPrintString() {
        return this.toPrintString(0);
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<expression>:" + returnType.toString();
    }
    @Override
    public String toString() {
        return "<expression>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstExpression) {
                if (this.returnType.equals(((AstExpression) other).returnType)) {
                    return true;
                }
            }
        }
        return false;
    }
}

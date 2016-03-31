package MentalAST;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class AstExpression extends AstBaseNode {
    public MentalType returnType;
    public AstExpression() {
        returnType = null;
    }
    @Override
    public String toString() {
        return "<expression>";
    }
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

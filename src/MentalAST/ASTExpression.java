package MentalAST;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class ASTExpression extends ASTBaseNode {
    public MentalType returnType;
    public ASTExpression() {
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
            if (other instanceof ASTExpression) {
                if (this.returnType.equals(((ASTExpression) other).returnType)) {
                    return true;
                }
            }
        }
        return false;
    }
}

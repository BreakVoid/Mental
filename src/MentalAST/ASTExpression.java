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
        return other != null && other instanceof ASTExpression && this.returnType.equals(((ASTExpression) other).returnType);
    }
}

package MentalAST;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTSingleVariableDeclaration extends ASTDeclaration {
    public ASTVariable variable;
    public ASTExpression initializeExpression;
    public ASTSingleVariableDeclaration() {
        this.variable = null;
        this.initializeExpression = null;
    }
    @Override
    public String toString() {
        String ret = "";
        if (this.variable != null) {
            ret += this.variable.toString();
        } else {
            return ret;
        }
        if (this.initializeExpression != null) {
            ret +=  "=" + this.initializeExpression.toString();
        }
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTSingleVariableDeclaration) {
                if (this.variable.equals(((ASTSingleVariableDeclaration) other).variable)) {
                    if (this.initializeExpression.equals(((ASTSingleVariableDeclaration) other).initializeExpression)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

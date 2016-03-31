package MentalAST;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstVarStatement extends AstStatement {
    public AstVariableDeclaration variableDeclaration;
    public AstVarStatement() {
        this.variableDeclaration = new AstVariableDeclaration();
    }
    @Override
    public String toString() {
        return "<variable declaration statement>";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof AstVarStatement) {
                if (this.variableDeclaration.equals(((AstVarStatement) other).variableDeclaration)) {
                    return true;
                }
            }
        }
        return false;
    }
}

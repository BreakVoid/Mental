package MentalAST.AstStatement;

import MentalAST.AstDeclaration.AstVariableDeclaration;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstVarStatement extends AstStatement {
    public AstVariableDeclaration variableDeclaration;
    public AstVarStatement() {
        this.variableDeclaration = new AstVariableDeclaration();
    }
    @Override
    public String toPrintString(int indent) {
        return this.variableDeclaration.toPrintString(indent);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return this.variableDeclaration.toPrettyPrint(indent);
    }
    @Override
    public String toString() {
        return "<variable declaration loopBody>";
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

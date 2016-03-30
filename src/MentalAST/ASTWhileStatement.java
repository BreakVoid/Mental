package MentalAST;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTWhileStatement extends ASTStatement {
    public ASTExpression cond;
    public ASTStatement statement;
    public ASTWhileStatement() {
        this.cond = null;
        this.statement = null;
    }
    @Override
    public String toString() {
        return "<while statement>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTWhileStatement) {
                if (this.cond.equals(((ASTWhileStatement) other).cond)) {
                    if (this.statement.equals(((ASTWhileStatement) other).statement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

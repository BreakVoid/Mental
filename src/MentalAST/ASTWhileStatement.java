package MentalAST;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstWhileStatement extends AstStatement {
    public AstExpression cond;
    public AstStatement statement;
    public AstWhileStatement() {
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
            if (other instanceof AstWhileStatement) {
                if (this.cond.equals(((AstWhileStatement) other).cond)) {
                    if (this.statement.equals(((AstWhileStatement) other).statement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

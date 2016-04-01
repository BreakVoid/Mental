package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstWhileStatement extends AstStatement {
    public AstExpression cond;
    public AstStatement loopBody;
    public AstWhileStatement() {
        this.cond = null;
        this.loopBody = null;
    }
    @Override
    public String toString() {
        return "<while loopBody>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstWhileStatement) {
                if (this.cond.equals(((AstWhileStatement) other).cond)) {
                    if (this.loopBody.equals(((AstWhileStatement) other).loopBody)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

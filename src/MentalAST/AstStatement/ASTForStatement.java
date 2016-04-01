package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstForStatement extends AstStatement {
    public AstExpression start, cond, loop;
    public AstStatement loopBody;
    public AstForStatement() {
        this.start = this.cond = this.loop = null;
        this.loopBody = null;
    }
    @Override
    public String toString() {
        return "<for loopBody>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstForStatement) {
                if (this.start.equals(((AstForStatement) other).start)) {
                    if (this.cond.equals(((AstForStatement) other).cond)) {
                        if (this.loop.equals(((AstForStatement) other).loop)) {
                            if (this.loopBody.equals(((AstForStatement) other).loopBody)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

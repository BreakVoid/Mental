package MentalAST;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTForStatement {
    public AstExpression start, cond, loop;
    public AstStatement loopBody;
    public ASTForStatement() {
        this.start = this.cond = this.loop = null;
        this.loopBody = null;
    }
    @Override
    public String toString() {
        return "<for statement>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTForStatement) {
                if (this.start.equals(((ASTForStatement) other).start)) {
                    if (this.cond.equals(((ASTForStatement) other).cond)) {
                        if (this.loop.equals(((ASTForStatement) other).loop)) {
                            if (this.loopBody.equals(((ASTForStatement) other).loopBody)) {
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

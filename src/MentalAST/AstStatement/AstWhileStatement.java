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
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<while expression>\n";
        ret += addIndent(indent + 1) + "<condition expression>\n" + this.cond.toPrintString(indent + 2) + "\n";
        ret += addIndent(indent + 1) + "<loop body>\n" + this.loopBody.toPrintString(indent + 2);
        return ret;
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

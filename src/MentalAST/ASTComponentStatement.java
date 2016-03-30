package MentalAST;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTComponentStatement extends ASTStatement {
    public List<ASTBaseNode> statements;
    public ASTComponentStatement() {
        this.statements = null;
    }
    @Override
    public String toString() {
        if (this.statements == null) {
            return "<empty component statement>";
        } else {
            return "<component>[" + this.statements.size() + " statements]";
        }
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTComponentStatement) {
                if (this.statements.equals(((ASTComponentStatement) other).statements)) {
                    return true;
                }
            }
        }
        return false;
    }
}

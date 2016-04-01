package MentalAST.AstStatement;

import MentalAST.AstBaseNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstComponentStatement extends AstStatement {
    public List<AstBaseNode> statements;
    public AstComponentStatement() {
        this.statements = new LinkedList<>();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        if (this.statements.size() == 0) {
            ret += AstBaseNode.addIndent(indent) + "<empty component statement>";
        } else {
            for (AstBaseNode statement : this.statements) {
                ret += statement.toPrintString(indent);
            }
        }
        return ret;
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
            if (other instanceof AstComponentStatement) {
                if (this.statements.equals(((AstComponentStatement) other).statements)) {
                    return true;
                }
            }
        }
        return false;
    }
}

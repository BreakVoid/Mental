package MentalAST.AstStatement;

import MentalAST.AstBaseNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstCompoundStatement extends AstStatement {
    public List<AstBaseNode> statements;
    public AstCompoundStatement() {
        this.statements = new LinkedList<>();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        if (this.statements.size() == 0) {
            ret += AstBaseNode.addIndent(indent) + "<empty component loopBody>";
        } else {
            for (AstBaseNode statement : this.statements) {
                ret += statement.toPrintString(indent) + '\n';
            }
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }
    @Override
    public String toString() {
        if (this.statements == null) {
            return "<empty component loopBody>";
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
            if (other instanceof AstCompoundStatement) {
                if (this.statements.equals(((AstCompoundStatement) other).statements)) {
                    return true;
                }
            }
        }
        return false;
    }
}

package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;
import MentalIR.AstVisitor;
import MentalIR.IRInstruction;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstIfStatement extends AstStatement {
    public AstExpression condition;
    public AstStatement thenStatement;
    public AstStatement elseStatement;
    public AstIfStatement() {
        this.condition = null;
        this.thenStatement = null;
        this.elseStatement = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<if statement>\n";
        ret += addIndent(indent + 1) + "<condition>\n" + this.condition.toPrintString(indent + 2) + '\n';
        ret += addIndent(indent + 1) + "<then statement>\n" + this.thenStatement.toPrintString(indent + 2);
        if (this.elseStatement != null) {
            ret += '\n' + addIndent(indent + 1) + "<else statement>\n" + this.elseStatement.toPrintString(indent + 2);
        }
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent) + "if (";
        ret += this.condition.toPrettyPrint() + ") ";
        if (this.thenStatement instanceof AstCompoundStatement) {
            ret += this.thenStatement.toPrettyPrint(indent + 1);
        } else {
            ret += "\n" + this.thenStatement.toPrettyPrint(indent + 1);
        }
        if (this.elseStatement != null) {
            if (!(this.thenStatement instanceof AstCompoundStatement)) {
                ret += "\n";
            }
            ret += "else ";
            if (this.elseStatement instanceof AstCompoundStatement) {
                ret += this.elseStatement.toPrettyPrint(indent + 1);
            } else {
                ret += "\n" + this.elseStatement.toPrettyPrint(indent + 1);
            }
        }
        return ret;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitIfStatement(this);
    }
}

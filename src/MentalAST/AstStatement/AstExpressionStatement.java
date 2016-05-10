package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;
import MentalIR.AstVisitor;
import MentalIR.IRInstruction;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstExpressionStatement extends AstStatement {
    public AstExpression expression;
    public AstExpressionStatement() {
        this.expression = null;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<expression statment>\n" + this.expression.toPrintString(indent + 1);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + this.expression.toPrettyPrint() + ";";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitExpressionStatement(this);
    }
}

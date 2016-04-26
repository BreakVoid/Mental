package MentalAST;

import MentalAST.AstExpression.AstExpression;
import MentalIR.AstVisitor;
import MentalIR.IRInstruction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstExpressionList extends AstBaseNode {
    public List<AstExpression> expressions;
    public AstExpressionList() {
        this.expressions = new ArrayList<>();
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitExpressionList(this);
    }
}

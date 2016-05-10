package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstBitNotExpression extends AstUnaryExpression {
    public AstBitNotExpression() {
        this.childExpression = null;
        this.returnType = SymbolTable.mentalInt;
    }

    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<bit not expression>:int\n";
        ret += this.childExpression.toPrintString(indent + 1);
        return ret;
    }

    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent) + "~";
        ret += this.childExpression.toPrettyPrint();
        return ret;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitBitNotExpression(this);
    }
}

package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallOrd extends AstUnaryExpression {
    public AstCallOrd() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<string.ord(int)>:int\n" + this.childExpression.toPrintString(indent + 1);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return "ord(" + this.childExpression.toPrettyPrint() + ")";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitCallOrd(this);
    }
}

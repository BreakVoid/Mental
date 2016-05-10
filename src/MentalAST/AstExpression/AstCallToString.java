package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallToString extends AstUnaryExpression {
    public AstCallToString() {
        this.returnType = SymbolTable.mentalString;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<toString(int)>:string\n";
        ret += this.childExpression.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + "toString(" + this.childExpression.toPrettyPrint() + ")";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitCallToString(this);
    }
}

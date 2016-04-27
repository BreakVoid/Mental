package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrintln extends AstExpression {
    public AstExpression parameter;
    public AstCallPrintln() {
        this.returnType = SymbolTable.mentalVoid;
        this.parameter = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<internal function call>:println(str)" + "\n";
        ret += this.parameter.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + "println(" + this.parameter.toPrettyPrint() + ")";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitCallPrintln(this);
    }
}

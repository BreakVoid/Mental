package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallGetString extends AstExpression {
    public AstCallGetString() {
        this.returnType = SymbolTable.mentalString;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<getString()>:string";
    }
    @Override
    public String toPrettyPrint(int indent) {
        return "getString()";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitCallGetString(this);
    }
}
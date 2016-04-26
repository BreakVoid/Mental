package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallSize extends AstExpression {
    public AstCallSize() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<array.size()>:int";
    }
    @Override
    public String toPrettyPrint(int indent) {
        return "size()";
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return new LinkedList<>();
    }
}

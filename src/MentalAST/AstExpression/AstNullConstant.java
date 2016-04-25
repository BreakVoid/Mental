package MentalAST.AstExpression;

import MentalIR.IRAstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstNullConstant extends AstExpression {
    public AstNullConstant() {
        this.returnType = SymbolTable.mentalNull;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<null>";
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + "null";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof AstNullConstant) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LinkedList<IRInstruction> visit(IRAstVisitor visitor) {
        return visitor.visitNullConstant(this);
    }
}

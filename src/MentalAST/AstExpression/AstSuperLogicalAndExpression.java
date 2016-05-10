package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/3.
 */
public class AstSuperLogicalAndExpression extends AstSuperExpression {
    public AstSuperLogicalAndExpression() {
        super();
        this.returnType = SymbolTable.mentalBool;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitSuperLogicalAndExpression(this);
    }
}

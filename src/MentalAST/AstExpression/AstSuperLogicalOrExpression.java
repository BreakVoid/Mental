package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/3.
 */
public class AstSuperLogicalOrExpression extends AstSuperExpression {
    public AstSuperLogicalOrExpression() {
        super();
        this.returnType = SymbolTable.mentalBool;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitSuperLogicalOrExpression(this);
    }
}

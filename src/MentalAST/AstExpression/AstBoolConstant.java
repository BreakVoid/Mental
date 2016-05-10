package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstBoolConstant extends AstExpression {
    public boolean boolConstant;
    public AstBoolConstant() {
        this.returnType = SymbolTable.mentalBool;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<bool>:" + Boolean.toString(this.boolConstant);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + Boolean.toString(this.boolConstant);
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitBoolConstant(this);
    }
}

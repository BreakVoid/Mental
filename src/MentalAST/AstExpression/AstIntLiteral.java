package MentalAST.AstExpression;

import MentalIR.IRAstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstIntLiteral extends AstExpression {
    public int literalContext;
    public AstIntLiteral() {
        this.literalContext = 0;
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<int-literal>:" + Integer.toString(literalContext);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + Integer.toString(literalContext);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstIntLiteral) {
                if (this.literalContext == ((AstIntLiteral) other).literalContext) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public LinkedList<IRInstruction> visit(IRAstVisitor visitor) {
        return visitor.visitIntLiteral(this);
    }
}

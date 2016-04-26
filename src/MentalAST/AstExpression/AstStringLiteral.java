package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstStringLiteral extends AstExpression {
    public String literalContext;
    public AstStringLiteral() {
        this.literalContext = "";
        this.returnType = SymbolTable.mentalString;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<string-literal>:" + this.literalContext;
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + this.literalContext;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstStringLiteral) {
                if (this.literalContext.equals(((AstStringLiteral) other).literalContext)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitStringLiteral(this);
    }
}

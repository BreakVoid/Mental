package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

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
    public String toPrintString() {
        return this.toPrintString(0);
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<string-literal>:" + this.literalContext;
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
}

package MentalAST;

import MentalSymbols.SymbolTable;

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
    public String toPrintString() {
        return this.toPrintString(0);
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<int-literal>:" + Integer.toString(literalContext);
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
}

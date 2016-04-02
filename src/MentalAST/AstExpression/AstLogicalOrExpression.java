package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstLogicalOrExpression extends AstBinaryExpression {
    public AstLogicalOrExpression() {
        this.returnType = SymbolTable.mentalBool;
        this.leftExpression = this.rightExpression = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<logical or expression>\n";
        ret += this.leftExpression.toPrintString(indent + 1) + '\n';
        ret += this.rightExpression.toPrintString(indent + 1);
        return ret;
    }
}

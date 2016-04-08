package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallSubString extends AstBinaryExpression {
    public AstCallSubString() {
        this.returnType = SymbolTable.mentalString;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<string.substring(int,int)>:string\n";
        ret += addIndent(indent + 1) + "<left bound>\n" + this.leftExpression.toPrintString(indent + 2) + "\n";
        ret += addIndent(indent + 1) + "<right bound>\n" + this.rightExpression.toPrintString(indent + 2);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = "substring(";
        ret += this.leftExpression.toPrettyPrint() + ", ";
        ret += this.rightExpression.toPrettyPrint() + ")";
        return ret;
    }
}

package MentalAST.AstExpression;

import MentalAST.AstBaseNode;
import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstEqualityExpression extends AstBinaryExpression {
    public static final int EQUAL = MentalParser.EQUAL;
    public static final int INEQUAL = MentalParser.INEQUAL;
    public int op;
    public AstEqualityExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalBool;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<equality expression";
        if (this.op == EQUAL) {
            ret += "(==)";
        } else {
            ret += "(!=)";
        }
        ret += ">\n";
        ret += this.leftExpression.toPrintString(indent + 1) + '\n';
        ret += this.rightExpression.toPrintString(indent + 1);
        return ret;
    }
}

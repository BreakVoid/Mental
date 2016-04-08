package MentalAST.AstExpression;

import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstSuffixExpression extends AstExpression {
    public static final int PLUS_PLUS = MentalParser.INC;
    public static final int MINUS_MINUS = MentalParser.DEC;
    public AstExpression childExpression;
    public int op;
    public AstSuffixExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalInt;
        this.childExpression = new AstExpression();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<suffix expression (";
        if (op == PLUS_PLUS) {
            ret += "++)>:int\n" + this.childExpression.toPrintString(indent + 1);
        } else {
            ret += "--)>:int\n" + this.childExpression.toPrintString(indent + 1);
        }
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent);
        if (op == PLUS_PLUS) {
            ret += this.childExpression.toPrettyPrint() + "++";
        } else {
            ret += this.childExpression.toPrettyPrint() + "--";
        }
        return ret;
    }
}

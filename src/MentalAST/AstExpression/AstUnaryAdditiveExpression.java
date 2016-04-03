package MentalAST.AstExpression;

import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstUnaryAdditiveExpression extends AstUnaryExpression {
    public int op;
    public static final int ADD = MentalParser.PLUS;
    public static final int SUB = MentalParser.MINUS;
    public AstUnaryAdditiveExpression() {
        this.op = 0;
        this.childExpression = null;
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<unary additive expression (";
        if (this.op == ADD) {
            ret += "+):int\n";
        } else {
            ret += "-):int\n";
        }
        ret += this.childExpression.toPrintString(indent + 1);
        return ret;
    }
}

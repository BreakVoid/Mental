package MentalAST.AstExpression;

import MentalAST.AstBaseNode;
import MentalParser.MentalParser;

import static MentalSymbols.SymbolTable.mentalInt;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstBitShiftExpression extends AstBinaryExpression {
    public static final int LEFT_SHIFT = MentalParser.LEFT_SHIFT;
    public static final int RIGHT_SHIFT = MentalParser.RIGHT_SHIFT;
    public int op;
    public AstBitShiftExpression() {
        this.op = 0;
        this.returnType = mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = AstBaseNode.addIndent(indent) + "<bit shift expression";
        if (this.op == LEFT_SHIFT) {
            ret += "(<<)";
        } else {
            ret += "(>>)";
        }
        ret += ">:" + this.returnType.toString() + '\n';
        ret += this.leftExpression.toPrintString(indent + 1) + '\n';
        ret += this.rightExpression.toPrintString(indent + 1);
        return ret;
    }
}

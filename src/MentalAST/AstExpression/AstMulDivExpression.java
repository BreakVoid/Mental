package MentalAST.AstExpression;

import MentalAST.AstBaseNode;
import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstMulDivExpression extends AstBinaryExpression {
    public static final int MUL = MentalParser.MUL;
    public static final int DIV = MentalParser.DIV;
    public static final int MOD = MentalParser.MOD;
    public int op;
    public AstMulDivExpression() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = AstBaseNode.addIndent(indent) + "<multiply expression";
        if (op == MUL) {
            ret += "(*)";
        } else if (op == DIV) {
            ret += "(/)";
        } else {
            ret += "(%)";
        }
        ret += ">:" + this.returnType.toString() + '\n';
        ret += leftExpression.toPrintString(indent + 1) + '\n';
        ret += rightExpression.toPrintString(indent + 1);
        return ret;
    }
}

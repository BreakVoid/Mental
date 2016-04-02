package MentalAST.AstExpression;

import MentalAST.AstBaseNode;
import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstAdditiveExpression extends AstBinaryExpression {
    public int op;
    public static final int ADD = MentalParser.PLUS;
    public static final int SUB = MentalParser.MINUS;
    public AstAdditiveExpression() {
        this.op = 0;
        this.leftExpression = this.rightExpression = null;
        this.returnType = SymbolTable.mentalUnknownType;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = AstBaseNode.addIndent(indent) + "<additive expression";
        if (op == ADD) {
            ret += "(+)";
        } else {
            ret += "(-)";
        }
        ret += ">:" + this.returnType.toString() + '\n';
        ret += leftExpression.toPrintString(indent + 1) + '\n';
        ret += rightExpression.toPrintString(indent + 1);
        return ret;
    }
}

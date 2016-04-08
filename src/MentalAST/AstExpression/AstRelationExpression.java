package MentalAST.AstExpression;

import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstRelationExpression extends AstBinaryExpression {
    public static final int LESS = MentalParser.LESS;
    public static final int LESS_EQ = MentalParser.LESS_EQUAL;
    public static final int GREATER = MentalParser.GREATER;
    public static final int GREATER_EQ = MentalParser.GREATER_EQUAL;
    public int op;
    public AstRelationExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalBool;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<relation expression";
        if (this.op == LESS) {
            ret += "(<)>:bool\n";
        } else if (this.op == LESS_EQ) {
            ret += "(<=)>:bool\n";
        } else if (this.op == GREATER) {
            ret += "(>)>:bool\n";
        } else {
            ret += "(>=)>:bool\n";
        }
        ret += this.leftExpression.toPrintString(indent + 1) + '\n';
        ret += this.rightExpression.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent);
        ret += this.leftExpression.toPrettyPrint();
        if (this.op == LESS) {
            ret += " < ";
        } else if (this.op == LESS_EQ) {
            ret += " <= ";
        } else if (this.op == GREATER) {
            ret += " > ";
        } else {
            ret += " >= ";
        }
        ret += this.rightExpression.toPrettyPrint();
        return ret;
    }
}

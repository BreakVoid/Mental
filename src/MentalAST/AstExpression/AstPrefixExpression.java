package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstPrefixExpression extends AstUnaryExpression {
    public static final int PLUS_PLUS = 1;
    public static final int MINUS_MINUS = 2;
    public int op;
    public AstPrefixExpression() {
        this.leftValue = true;
        this.op = 0;
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<prefix expression>:";
        if (op == PLUS_PLUS) {
            ret += "++\n" + this.childExpression.toPrintString(indent + 1);
        }
        return ret;
    }
}

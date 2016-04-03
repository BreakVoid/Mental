package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrintln extends AstStatement {
    public AstExpression parameter;
    public AstCallPrintln() {
        this.parameter = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<internal function call>:println(str)" + "\n";
        ret += this.parameter.toPrintString(indent + 1);
        return ret;
    }
}

package MentalAST.AstStatement;

import MentalAST.AstExpression.AstExpression;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrint extends AstStatement {
    public AstExpression parameter;
    public AstCallPrint() {
        this.parameter = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<internal function call>:print(str)" + "\n";
        ret += this.parameter.toPrintString(indent + 1);
        return ret;
    }
}

package MentalAST.AstExpression;

import MentalAST.AstExpressionList;
import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstFunctionCall extends AstExpression {
    public SymbolFunction functionHead;
    public String functionName;
    public AstExpressionList parameters;
    public AstFunctionCall() {
        this.functionHead = null;
        this.functionName = null;
        this.parameters = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<function call>:" + this.returnType.toString() + "\n"
                + addIndent(indent + 1) + this.functionHead.functionName;
        if (this.parameters == null || this.parameters.expressions.size() == 0) {
            ret += "()";
            return ret;
        } else {
            ret += "(\n" + addIndent(indent + 1) + this.functionHead.parameterName.get(0) + "=\n"
                    + this.parameters.expressions.get(0).toPrintString(indent + 2);
            for (int i = 1, count = this.parameters.expressions.size(); i < count; ++i) {
                ret += "\n" + addIndent(indent + 1) + this.functionHead.parameterName.get(i) + "=\n"
                        + this.parameters.expressions.get(i).toPrintString(indent + 2);
            }
            ret += "\n" + addIndent(indent + 1) + ")";
            return ret;
        }
    }
}

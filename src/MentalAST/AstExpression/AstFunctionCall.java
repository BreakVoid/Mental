package MentalAST.AstExpression;

import MentalAST.AstExpressionList;
import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstFunctionCall extends AstExpression {
    public SymbolFunction functionHead;
    public AstExpressionList parameters;
    public AstFunctionCall() {
        this.functionHead = null;
        this.parameters = null;
    }
}

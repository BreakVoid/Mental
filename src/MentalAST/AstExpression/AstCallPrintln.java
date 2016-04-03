package MentalAST.AstExpression;

import MentalAST.AstExpression.AstExpression;
import MentalAST.AstStatement.AstStatement;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrintln extends AstExpression {
    public AstExpression parameter;
    public AstCallPrintln() {
        this.returnType = SymbolTable.mentalVoid;
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

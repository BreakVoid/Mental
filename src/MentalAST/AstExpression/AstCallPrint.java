package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallPrint extends AstExpression {
    public AstExpression parameter;
    public AstCallPrint() {
        this.returnType = SymbolTable.mentalVoid;
        this.parameter = null;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<internal function call>:print(str)" + "\n";
        ret += this.parameter.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + "print(" + this.parameter.toPrettyPrint() + ")";
    }
}

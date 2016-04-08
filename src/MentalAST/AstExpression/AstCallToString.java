package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallToString extends AstUnaryExpression {
    public AstCallToString() {
        this.returnType = SymbolTable.mentalString;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<toString(int)>:string\n";
        ret += this.childExpression.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + "toString(" + this.childExpression.toPrettyPrint() + ")";
    }
}

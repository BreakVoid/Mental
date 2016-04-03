package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallOrd extends AstUnaryExpression {
    public AstCallOrd() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<string.ord(int)>:int\n" + this.childExpression.toPrintString(indent + 1);
    }
}

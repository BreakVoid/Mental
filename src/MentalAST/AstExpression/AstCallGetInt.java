package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallGetInt extends AstExpression {
    public AstCallGetInt() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<getInt()>:int";
    }
    @Override
    public String toPrettyPrint(int indent) {
        return "getInt()";
    }
}

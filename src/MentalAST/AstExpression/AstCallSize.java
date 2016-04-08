package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstCallSize extends AstExpression {
    public AstCallSize() {
        this.returnType = SymbolTable.mentalInt;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<array.size()>:int";
    }
    @Override
    public String toPrettyPrint(int indent) {
        return "size()";
    }
}

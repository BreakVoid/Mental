package MentalAST.AstExpression;

import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstBoolConstant extends AstExpression {
    public boolean boolConstant;
    public AstBoolConstant() {
        this.returnType = SymbolTable.mentalBool;
    }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<bool>:" + Boolean.toString(this.boolConstant);
    }
    @Override
    public String toPrettyPrint(int indent) {
        return addIndent(indent) + Boolean.toString(this.boolConstant);
    }
}

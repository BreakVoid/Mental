package MentalAST.AstDeclaration;

import MentalAST.AstStatement.AstComponentStatement;
import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstFunctionDefinition extends AstDeclaration {
    public SymbolFunction functionHead;
    public AstComponentStatement functionBody;
    public AstFunctionDefinition() {
        this.functionHead = new SymbolFunction();
        this.functionBody = new AstComponentStatement();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<begin>function\n";
        ret += addIndent(indent + 1) + "<format>" + this.functionHead.toString().substring(10) + '\n';
        ret += this.functionBody.toPrintString(indent + 1) + '\n';
        ret += addIndent(indent) + "<end>function";
        return ret;
    }
    @Override
    public String toString() {
        if (this.functionHead == null || this.functionBody == null) {
            return "";
        }
        return this.functionHead.toString() + ":" + this.functionBody.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstFunctionDefinition) {
                if (this.functionHead.equals(((AstFunctionDefinition) other).functionHead)) {
                    return true;
                }
            }
        }
        return false;
    }
}

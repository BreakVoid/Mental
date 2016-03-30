package MentalAST;

import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTFunctionDefinition extends ASTDeclaration {
    public SymbolFunction functionHead;
    public ASTComponentStatement functionBody;
    public ASTFunctionDefinition() {
        this.functionHead = null;
        this.functionBody = null;
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
            if (other instanceof ASTFunctionDefinition) {
                if (this.functionHead.equals(((ASTFunctionDefinition) other).functionHead)) {
                    return true;
                }
            }
        }
        return false;
    }
}

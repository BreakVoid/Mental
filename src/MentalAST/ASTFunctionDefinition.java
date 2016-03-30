package MentalAST;

import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTFunctionDefinition extends ASTDeclaration {
    public SymbolFunction function;
    public ASTComponentStatement functionBody;
    public ASTFunctionDefinition() {
        this.function = null;
        this.functionBody = null;
    }
    @Override
    public String toString() {
        return this.function.toString() + ":" + this.functionBody.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTFunctionDefinition) {
                if (this.function.equals(((ASTFunctionDefinition) other).function)) {
                    return true;
                }
            }
        }
        return false;
    }
}

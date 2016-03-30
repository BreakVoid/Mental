package MentalAST;

import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTFunctionDefinition extends ASTDeclaration {
    public SymbolFunction function;
    public ASTFunctionDefinition() {
        this.function = null;
    }
    @Override
    public String toString() {
        return "AST" + this.function.toString();
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof ASTFunctionDefinition && this.function.equals(((ASTFunctionDefinition) other).function);
    }
}

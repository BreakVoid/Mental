package MentalAST;

import MentalSymbols.SymbolType;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTClassDeclaration extends ASTDeclaration {
    public SymbolType classDetail;
    public ASTClassDeclaration() {
        this.classDetail = null;
    }
    @Override
    public String toString() {
        return "AST<class>" + this.classDetail.type.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof ASTClassDeclaration) {
                if (this.classDetail.equals(((ASTClassDeclaration) other).classDetail)) {
                    return true;
                }
            }
        }
        return false;
    }
}

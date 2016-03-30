package MentalAST;

/**
 * Created by Songyu on 16/3/28.
 */
public class ASTDeclaration extends ASTBaseNode {
    @Override
    public String toString() {
        return "AST declaration node";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof ASTDeclaration;
    }
}

package MentalAST;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTProgram extends ASTBaseNode {
    public LinkedList<ASTBaseNode> declarations;
    public ASTProgram() {
        this.declarations = new LinkedList<>();
    }
    @Override
    public String toString() {
        return "AST<program>";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof ASTProgram) {
                if (this.declarations.equals(((ASTProgram) other).declarations)) {
                    return true;
                }
            }
        }
        return false;
    }
}

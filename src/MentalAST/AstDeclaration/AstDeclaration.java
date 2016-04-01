package MentalAST.AstDeclaration;

import MentalAST.AstBaseNode;

/**
 * Created by Songyu on 16/3/28.
 */
public class AstDeclaration extends AstBaseNode {
    @Override
    public String toPrintString(int indent) {
        return this.addIndent(indent) + "<declaration>";
    }
    @Override
    public String toString() {
        return "<declaration>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof AstDeclaration;
    }
}

package MentalAST;

import java.util.List;

/**
 * Created by Songyu on 16/3/28.
 */
public class ASTBaseNode {
    public ASTBaseNode() { }
    @Override
    public String toString() {
        return "<BASE NODE>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof ASTBaseNode;
    }
}

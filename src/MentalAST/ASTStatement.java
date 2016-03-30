package MentalAST;

/**
 * Created by Songyu on 16/3/28.
 */
public class ASTStatement extends ASTBaseNode {
    public ASTStatement() { }
    @Override
    public String toString() {
        return "<statement>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof ASTStatement;
    }
}

package MentalAST.AstStatement;

import MentalAST.AstBaseNode;

/**
 * Created by Songyu on 16/3/28.
 */
public class AstStatement extends AstBaseNode {
    public AstStatement() { }
    @Override
    public String toString() {
        return "<statement>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof AstStatement;
    }
}

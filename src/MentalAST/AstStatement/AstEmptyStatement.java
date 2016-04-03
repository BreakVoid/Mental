package MentalAST.AstStatement;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstEmptyStatement extends AstStatement {
    public AstEmptyStatement() { }
    @Override
    public String toPrintString(int indent) {
        return addIndent(indent) + "<empty statement>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof AstEmptyStatement;
    }
}

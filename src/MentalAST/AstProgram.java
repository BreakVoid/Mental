package MentalAST;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstProgram extends AstBaseNode {
    public LinkedList<AstBaseNode> declarations;
    public AstProgram() {
        this.declarations = new LinkedList<>();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<begin>program\n";
        if (this.declarations != null) {
            for (AstBaseNode e : this.declarations) {
                ret += e.toPrintString(indent + 1) + '\n';
            }
        }
        ret += addIndent(indent) + "<end>program";
        return ret;
    }
    @Override
    public String toString() {
        return "<program>";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstProgram) {
                if (this.declarations.equals(((AstProgram) other).declarations)) {
                    return true;
                }
            }
        }
        return false;
    }
}

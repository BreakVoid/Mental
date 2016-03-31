package MentalAST;

/**
 * Created by Songyu on 16/3/28.
 */
public class AstBaseNode {
    public AstBaseNode() { }
    public static String addIndent(int indent) {
        String ret = "";
        for (int i = 0; i < indent; ++i) {
            ret += "  ";
        }
        return ret;
    }
    public String toPrintString() {
        return this.toPrintString(0);
    }
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<BASE NODE>";
        return ret;
    }
    @Override
    public String toString() {
        return "<BASE NODE>";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof AstBaseNode;
    }
}

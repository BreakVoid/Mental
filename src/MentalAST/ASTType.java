package MentalAST;

/**
 * Created by Songyu on 16/3/28.
 */
public class ASTType extends ASTBaseNode {
    public String originalType;
    public int dimSize;
    public ASTType() {
        this("");
    }
    public ASTType(String typename) {
        originalType = typename;
        dimSize = 0;
    }
    public ASTType(ASTType other) {
        this.originalType = other.originalType;
        this.dimSize = other.dimSize + 1;
    }
    public  ASTType(ASTOriginalType ot) {
        this.originalType = ot.originalType;
        this.dimSize = 0;
    }
}

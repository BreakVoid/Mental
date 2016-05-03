package MentalIR.Data;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRDataIntLiteral extends IRDataValue {
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public static final int NULL = 0;
    public int literal;
    public IRDataIntLiteral() {
        this.literal = 0;
    }
    public IRDataIntLiteral(int literal) {
        this.literal = literal;
    }
}

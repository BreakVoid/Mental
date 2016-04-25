package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRWordLiteral extends IRData {
    public static final int TRUE_VALUE = 1;
    public static final int FALSE_VALUE = 0;
    public static final int NULL_VALUE = 0;
    public static final int memSize = 4;
    public int context;
    public IRWordLiteral() {
        this.context = 0;
    }
    public IRWordLiteral(int context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return Integer.toString(this.context);
    }
}

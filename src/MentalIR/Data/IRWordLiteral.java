package MentalIR.Data;

import MentalIR.Data.IRTemporary;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRWordLiteral extends IRTemporary {
    public static final int TRUE_VALUE = 1;
    public static final int FALSE_VALUE = 0;
    public static final int NULL_VALUE = 0;
    public static final int memSize = 4;
    public int context;
    public IRWordLiteral() {
        super();
        this.context = 0;
        this.registerName = -1;
        this.inRegister = false;
    }
    public IRWordLiteral(int context) {
        super();
        this.context = context;
        this.registerName = -1;
        this.inRegister = false;
    }

    @Override
    public String toString() {
        return Integer.toString(this.context);
    }
}

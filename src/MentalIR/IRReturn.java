package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRReturn extends IRInstruction {
    public IRData returnValue;
    public IRReturn() {
        this.returnValue = null;
    }
    public IRReturn(IRData returnValue) {
        this.returnValue = returnValue;
    }
}

package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRSystemCall extends IRInstruction {
    public IRData amount;
    public IRSystemCall() {
        this.amount = null;
    }
    public IRSystemCall(IRData amount) {
        this.amount = amount;
    }
}

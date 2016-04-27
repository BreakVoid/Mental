package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRNullOperation extends IRInstruction {
    public IRNullOperation() {
        this.nextInstruction = null;
        this.label = null;
    }
}

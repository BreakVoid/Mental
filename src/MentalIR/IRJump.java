package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRJump extends IRInstruction {
    public IRLabel gotoLabel;
    public IRJump() {
        this.gotoLabel = null;
    }
    public IRJump(IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
    }
}

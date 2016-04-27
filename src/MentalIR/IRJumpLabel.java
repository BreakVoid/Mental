package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRJumpLabel extends IRInstruction {
    public IRLabel gotoLabel;
    public IRJumpLabel() {
        this.gotoLabel = null;
    }
    public IRJumpLabel(IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
    }
}

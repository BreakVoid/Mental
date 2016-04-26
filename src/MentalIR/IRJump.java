package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRJump extends IRInstruction {
    public int gotoLabel;
    public IRJump() {
        this.gotoLabel = -1;
    }
    public IRJump(int gotoLabel) {
        this.gotoLabel = gotoLabel;
    }
}

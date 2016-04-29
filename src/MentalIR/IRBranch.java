package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRBranch extends IRInstruction {
    public IRLabel gotoLabel;
    public IRBranch() {
        this.gotoLabel = null;
    }
    public IRBranch(IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
    }
}

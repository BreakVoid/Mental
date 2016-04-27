package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRBranchEqualZero extends IRBranch {
    public IRLabel gotoLabel;
    public IRData condition;
    public IRBranchEqualZero() {
        this.gotoLabel = null;
        this.condition = null;
        this.nextInstruction = null;
    }

    public IRBranchEqualZero(IRData condition, IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
        this.condition = condition;
        this.nextInstruction = null;
    }
}

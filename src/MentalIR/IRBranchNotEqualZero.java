package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBranchNotEqualZero extends IRBranch {
    public IRLabel gotoLabel;
    public IRData condition;
    public IRBranchNotEqualZero() {
        this.gotoLabel = null;
        this.condition = null;
        this.nextInstruction = null;
    }
    public IRBranchNotEqualZero(IRData condition, IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
        this.condition = condition;
        this.nextInstruction = null;
    }
}

package MentalIR;

import MentalIR.Label.IRLabel;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRJumpLabel extends IRBranch {
    public IRJumpLabel() {
        this.gotoLabel = null;
    }
    public IRJumpLabel(IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
    }
}

package MentalIR.Branch;

import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;

/**
 * Created by Songyu on 16/5/5.
 */
public class IRBranchCompare extends IRBranch {
    public IRDataValue lhs, rhs;
    public IRBranchCompare() {
        this.lhs = null;
        this.rhs = null;
    }
    public IRBranchCompare(IRDataValue lhs, IRDataValue rhs, IRLabel gotoLabel) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.gotoLabel = gotoLabel;
    }
}

package MentalIR.Branch;

import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/5/5.
 */
public class IRBranchCompareGreater extends IRBranchCompare {
    public IRBranchCompareGreater() {
        super();
    }

    public IRBranchCompareGreater(IRDataValue lhs, IRDataValue rhs, IRLabel gotoLabel) {
        super(lhs, rhs, gotoLabel);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "bgt");
    }
}

package MentalIR.Branch;

import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/5/5.
 */
public class IRBranchCompareNotEqual extends IRBranchCompare {
    public IRBranchCompareNotEqual() {
        super();
    }

    public IRBranchCompareNotEqual(IRDataValue lhs, IRDataValue rhs, IRLabel gotoLabel) {
        super(lhs, rhs, gotoLabel);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "bne");
    }
}
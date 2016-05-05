package MentalIR.Branch;

import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRBranchEqualZero extends IRBranchWithContidtion {

    public IRBranchEqualZero() {
        this.gotoLabel = null;
        this.condition = null;
        this.nextInstruction = null;
        this.beTranslate = true;
    }

    public IRBranchEqualZero(IRDataValue condition, IRLabel gotoLabel) {
        this.gotoLabel = gotoLabel;
        this.condition = condition;
        this.condition.refCount++;
        this.nextInstruction = null;
        this.beTranslate = true;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "beqz");
    }
}

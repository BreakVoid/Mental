package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBranchNotEqualZero extends IRBranchWithContidtion {
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

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "bnez");
    }
}

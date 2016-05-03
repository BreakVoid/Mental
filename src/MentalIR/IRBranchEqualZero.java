package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRBranchEqualZero extends IRBranchWithContidtion {

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

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "beqz");
    }
}

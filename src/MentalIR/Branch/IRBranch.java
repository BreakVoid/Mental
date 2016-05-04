package MentalIR.Branch;

import MentalIR.IRInstruction;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

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

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        mipsInstructions.add(mipsMachine.storeAndCleanMachine());
        mipsInstructions.add(
                String.format("\tb %s", this.gotoLabel.toString())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public String toMips() {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        mipsInstructions.add(
                String.format("\tb %s", this.gotoLabel.toString())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

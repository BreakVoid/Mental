package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;


/**
 * Created by Songyu on 16/4/27.
 */
public class IRNullOperation extends IRInstruction {
    public IRNullOperation() {
        this.nextInstruction = null;
        this.label = null;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        mipsInstructions.add("\tnop");

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        if (str.length() == 0) {
            str = " ";
        }
        return str.substring(0, str.length() - 1);
    }
}

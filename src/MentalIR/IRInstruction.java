package MentalIR;

import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRInstruction {
    public IRInstruction nextInstruction = null;
    public IRLabel label = null;
    public IRInstruction() {
        this.nextInstruction = null;
        this.label = null;
    }

    public String toMips(MIPSMachine mipsMachine) {
        // would never be called.
        throw new RuntimeException(this.toString());
    }

}

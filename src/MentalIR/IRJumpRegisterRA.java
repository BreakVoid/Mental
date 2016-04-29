package MentalIR;

import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/29.
 */
public class IRJumpRegisterRA extends IRJumpRegister {
    public IRJumpRegisterRA() {
        this.registerName = MIPSRegister.ra;
    }
}

package MentalIR;

import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/26.
 */

public class IRConstantZero extends IRData {
    public IRConstantZero() {
        this.inRegister = true;
        this.registerName = MIPSRegister.zero;
    }
}

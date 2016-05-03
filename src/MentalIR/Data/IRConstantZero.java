package MentalIR.Data;

import MentalIR.Data.IRData;
import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/26.
 */

public class IRConstantZero extends IRData {
    public IRConstantZero() {
        this.registerName = MIPSRegister.zero;
    }
}

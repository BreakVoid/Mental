package MentalIR.Data;

import MentalIR.Data.IRData;
import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/26.
 */

public class IRConstantZero extends IRDataIntLiteral {
    public IRConstantZero() {
        this.registerName = MIPSRegister.zero;
    }

    @Override
    public String toAddress() {
        return "$zero";
    }
    @Override
    public String toRegister() {
        return "$zero";
    }
}

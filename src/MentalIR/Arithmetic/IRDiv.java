package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRDiv extends IRBinaryArithmetic {
    public IRDiv() {
        super();
    }
    public IRDiv(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "div");
    }
}

package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRMul extends IRBinaryArithmetic {
    public IRMul() {
        super();
    }
    public IRMul(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "mul");
    }
}
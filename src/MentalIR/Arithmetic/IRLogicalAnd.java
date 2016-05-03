package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLogicalAnd extends IRBinaryArithmetic {
    public IRLogicalAnd() {
        super();
    }
    public IRLogicalAnd(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "and");
    }
}

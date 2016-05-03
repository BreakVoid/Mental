package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRMul extends IRBinaryArithmetic {
    public IRMul() {
        super();
    }
    public IRMul(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "mul");
    }
}
package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRDiv extends IRBinaryArithmetic {
    public IRDiv() {
        super();
    }
    public IRDiv(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "div");
    }
}

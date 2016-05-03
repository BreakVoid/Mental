package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRAdd extends IRBinaryArithmetic {
    public IRAdd() {
        super();
    }
    public IRAdd(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRAdd(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "add");
    }
}

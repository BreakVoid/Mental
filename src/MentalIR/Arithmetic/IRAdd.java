package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRAdd extends IRBinaryArithmetic {
    public IRAdd() {
        super();
    }
    public IRAdd(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRAdd(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
    public IRAdd(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "add");
    }
    @Override
    public String toMips() {
        return this.toMips("add");
    }
}

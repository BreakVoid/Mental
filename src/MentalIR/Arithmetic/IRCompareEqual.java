package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareEqual extends IRCompare {
    public IRCompareEqual() {
        super();
    }
    public IRCompareEqual(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRCompareEqual(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "seq");
    }
    @Override
    public String toMips() {
        return this.toMips("seq");
    }
}

package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareGreater extends IRCompare {
    public IRCompareGreater() {
        super();
    }
    public IRCompareGreater(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRCompareGreater(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "sgt");
    }
}

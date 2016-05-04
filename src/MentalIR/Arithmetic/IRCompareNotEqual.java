package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareNotEqual extends IRCompare {
    public IRCompareNotEqual() {
        super();
    }
    public IRCompareNotEqual(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRCompareNotEqual(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "sne");
    }
    @Override
    public String toMips() {
        return this.toMips("sne");
    }
}

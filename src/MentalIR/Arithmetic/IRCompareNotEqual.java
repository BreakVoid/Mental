package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareNotEqual extends IRCompare {
    public IRCompareNotEqual() {
        super();
    }
    public IRCompareNotEqual(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompareNotEqual(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "sne");
    }
}

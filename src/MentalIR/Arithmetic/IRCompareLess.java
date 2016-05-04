package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareLess extends IRCompare {
    public IRCompareLess() {
        super();
    }
    public IRCompareLess(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRCompareLess(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "slt");
    }
    @Override
    public String toMips() {
        return this.toMips("slt");
    }
}

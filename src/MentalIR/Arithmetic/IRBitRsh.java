package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitRsh extends IRBinaryArithmetic {
    public IRBitRsh() {
        super();
    }
    public IRBitRsh(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    public IRBitRsh(IRData lhsRes, IRData rhsRes, IRDataValue res) {
        super((IRDataValue) lhsRes, (IRDataValue) rhsRes, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "sra");
    }
    @Override
    public String toMips() {
        return this.toMips("sra");
    }
}

package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitAnd extends IRBinaryArithmetic {
    public IRBitAnd() {
        super();
    }
    public IRBitAnd(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    public IRBitAnd(IRData lhsRes, IRData rhsRes, IRDataValue res) {
        super((IRDataValue) lhsRes, (IRDataValue) rhsRes, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "and");
    }
}

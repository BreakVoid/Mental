package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitXor extends IRBinaryArithmetic {
    public IRBitXor() {
        super();
    }
    public IRBitXor(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    public IRBitXor(IRData lhsRes, IRData rhsRes, IRDataValue res) {
        super((IRDataValue) lhsRes, (IRDataValue) rhsRes, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "xor");
    }
}

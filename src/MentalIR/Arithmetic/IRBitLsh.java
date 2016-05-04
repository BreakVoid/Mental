package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitLsh extends IRBinaryArithmetic {
    public IRBitLsh() {
        super();
    }
    public IRBitLsh(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }

    public IRBitLsh(IRData lhsRes, IRData rhsRes, IRDataValue res) {
        super((IRDataValue) lhsRes, (IRDataValue) rhsRes, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "sll");
    }
    @Override
    public String toMips() {
        return this.toMips("sll");
    }
}

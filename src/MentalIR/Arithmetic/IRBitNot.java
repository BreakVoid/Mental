package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRBitNot extends IRUnaryArithmetic {
    public IRBitNot() {
        super();
    }
    public IRBitNot(IRDataValue child, IRDataValue res) {
        super(child, res);
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return this.toMips(mipsMachine, "not");
    }
    @Override
    public String toMips() {
        return this.toMips("not");
    }
}

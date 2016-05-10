package MentalIR.Arithmetic;

import MentalIR.Arithmetic.IRBinaryArithmetic;
import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompare extends IRBinaryArithmetic {
    public IRCompare() {
        super();
    }
    public IRCompare(IRDataValue lhs, IRDataValue rhs) {
        super(lhs, rhs);
    }
    public IRCompare(IRData lhs, IRData rhs, IRDataValue res) {
        super(lhs, rhs, res);
    }
}

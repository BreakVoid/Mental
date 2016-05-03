package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;

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
}

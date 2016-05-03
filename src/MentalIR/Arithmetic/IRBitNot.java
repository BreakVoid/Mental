package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRUnaryArithmetic;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRBitNot extends IRUnaryArithmetic {
    public IRBitNot() {
        super();
    }
    public IRBitNot(IRData child, IRData res) {
        super(child, res);
    }
}

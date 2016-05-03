package MentalIR.Arithmetic;

import MentalIR.Arithmetic.IRArithmetic;
import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRUnaryArithmetic extends IRArithmetic {
    public IRDataValue child;
    public IRUnaryArithmetic() {
        super();
        this.child = null;
    }
    public IRUnaryArithmetic(IRDataValue child, IRDataValue res) {
        this.child = child;
        this.res = res;
    }
}

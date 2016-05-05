package MentalIR.Arithmetic;

import MentalIR.Data.IRDataValue;
import MentalIR.IRInstruction;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRArithmetic extends IRInstruction {
    public IRDataValue res;
    public IRArithmetic() {
        this.beTranslate = true;
        this.res = null;
    }
}

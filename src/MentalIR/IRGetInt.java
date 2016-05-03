package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRGetInt extends IRSystemCall {
    public IRData res;
    public IRGetInt() {
        this.variant = 5;
        this.res = new IRDataIntLiteral();
    }
    public IRGetInt(IRData res) {
        this.res = res;
    }

}

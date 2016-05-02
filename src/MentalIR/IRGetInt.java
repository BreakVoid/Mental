package MentalIR;

import MentalTranslator.MIPSRegister;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRGetInt extends IRSystemCall {
    public IRData res;
    public IRGetInt() {
        this.variant = 5;
        this.res = new IRTemporary();
        this.res.registerName = MIPSRegister.v0;
        this.res.inRegister = true;
    }
    public IRGetInt(IRData res) {
        this.res = res;
    }

}

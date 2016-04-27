package MentalMIPS;

import MentalIR.IRData;

/**
 * Created by Songyu on 16/4/27.
 */
public class MIPSMachine {
    boolean[] registerEmpty;
    IRData[] registerData;
    public MIPSMachine() {
        this.registerEmpty = new boolean[32];
        this.registerData = new IRData[32];
        for (int i = 0; i < 32; ++i) {
            this.registerEmpty[i] = true;
            this.registerData[i] = null;
        }
    }
    public boolean isEmpty(int i) {
        return this.registerEmpty[i];
    }
    public IRData occupied(int i) {
        return this.registerData[i];
    }
}

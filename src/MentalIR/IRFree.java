package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/5/3.
 */
public class IRFree extends IRInstruction {
    public IRData freeData;
    public IRFree() {
        this.freeData = null;
    }
    public IRFree(IRData freeData) {
        this.freeData = freeData;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        return "";
    }

    @Override
    public String toMips() {
        return "";
    }
}

package MentalIR;

import MentalIR.Data.IRTemporary;
import MentalTranslator.MIPSMachine;

/**
 * Created by Songyu on 16/5/1.
 */
public class IRCleanMachine extends IRInstruction {
    public IRCleanMachine() {
        this.nextInstruction = null;
        this.label = null;
    }

    public String toMips(MIPSMachine mipsMachine) {
        for (int i = 0; i < 32; ++i) {
            if (!mipsMachine.registerEmpty[i]) {
                if (mipsMachine.registerData[i] instanceof IRTemporary) {
                    mipsMachine.registerData[i] = null;
                    mipsMachine.registerEmpty[i] = true;
                } else {
                    if (!mipsMachine.canBeRewrite(i)) {
                        mipsMachine.registerData[i].consume();
                    }
                }
            }
        }
        return "";
    }
}

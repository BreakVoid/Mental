package MentalIR.Branch;

import MentalIR.IRInstruction;

/**
 * Created by Songyu on 16/4/29.
 */
public class IRJumpRegister extends IRInstruction {
    public int registerName;
    public IRJumpRegister() {
        this.registerName = -1;
    }
    public IRJumpRegister(int registerName) {
        this.registerName = registerName;
    }
}

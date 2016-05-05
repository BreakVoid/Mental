package MentalTranslator;

import MentalIR.IRInstruction;

/**
 * Created by Songyu on 16/5/3.
 */
public class BasicBlock {
    public IRInstruction instruction;
    public BasicBlock nextBlock;
    public boolean allowAppend;
    public BasicBlock() {
        this.instruction = null;
        this.nextBlock = null;
        this.allowAppend = true;
    }
}

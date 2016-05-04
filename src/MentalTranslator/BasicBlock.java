package MentalTranslator;

import MentalIR.IRInstruction;

/**
 * Created by Songyu on 16/5/3.
 */
public class BasicBlock {
    public IRInstruction instruction;
    public BasicBlock nextBlock;
    public BasicBlock() {
        this.instruction = null;
        this.nextBlock = null;
    }
}

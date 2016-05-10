package MentalTranslator;

import MentalIR.IRInstruction;
import MentalIR.IRStore;

/**
 * Created by Songyu on 16/4/30.
 */
public class MIPSGlobalInitialize extends MIPSTranslator {
    public MIPSGlobalInitialize() {
        super();
    }
    public void translate(IRInstruction instruction) {
        BasicBlockSpliter basicBlockSpliter = new BasicBlockSpliter(instruction);
        for (BasicBlock basicBlock : basicBlockSpliter.basicBlocks) {
            BasicBlockTranslator basicBlockTranslator = new BasicBlockTranslator();
            basicBlockTranslator.translate(basicBlock.instruction);
            mipsStatement.addAll(basicBlockTranslator.mipsStatement);
        }
    }
}

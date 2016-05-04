package MentalTranslator;

import MentalIR.Branch.IRBranch;
import MentalIR.Branch.IRReturn;
import MentalIR.IRCall;
import MentalIR.IRInstruction;
import MentalIR.IRSystemCall;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/4.
 */
public class BasicBlockSpliter {
    public LinkedList<BasicBlock> basicBlocks;
    public BasicBlockSpliter() {
        this.basicBlocks = new LinkedList<>();
    }
    public BasicBlockSpliter(IRInstruction instruction) {
        this.basicBlocks = new LinkedList<>();
        this.basicBlocks.add(new BasicBlock());
        if (instruction != null) {
            this.basicBlocks.getLast().instruction = instruction;
        }
        while (instruction != null) {
            if (instruction.nextInstruction != null) {
                IRInstruction nextInstruction = instruction.nextInstruction;
                if (instruction instanceof IRBranch
                        || instruction instanceof IRCall
                        || instruction instanceof IRSystemCall
                        || instruction.nextInstruction.label != null) {

                    BasicBlock newBasicBlock = new BasicBlock();
                    newBasicBlock.instruction = nextInstruction;
                    instruction.nextInstruction = null;
                    basicBlocks.add(newBasicBlock);
                }
                instruction = nextInstruction;
            } else {
                break;
            }
        }
    }
}

package MentalTranslator;

import MentalIR.Branch.IRBranch;
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
                if (instruction instanceof IRBranch) {
                    this.basicBlocks.getLast().nextBlock = new BasicBlock();
                    this.basicBlocks.add(this.basicBlocks.getLast().nextBlock);
                    this.basicBlocks.getLast().instruction = instruction.nextInstruction;
                    instruction.nextInstruction = null;
                    instruction = this.basicBlocks.getLast().instruction;
                } else if (instruction instanceof IRCall) {
                    this.basicBlocks.getLast().nextBlock = new BasicBlock();
                    this.basicBlocks.add(this.basicBlocks.getLast().nextBlock);
                    this.basicBlocks.getLast().instruction = instruction.nextInstruction;
                    instruction.nextInstruction = null;
                    instruction = this.basicBlocks.getLast().instruction;
                } else if (instruction instanceof IRSystemCall) {
                    this.basicBlocks.getLast().nextBlock = new BasicBlock();
                    this.basicBlocks.add(this.basicBlocks.getLast().nextBlock);
                    this.basicBlocks.getLast().instruction = instruction.nextInstruction;
                    instruction.nextInstruction = null;
                    instruction = this.basicBlocks.getLast().instruction;
                } if (instruction.nextInstruction.label != null) {
                    this.basicBlocks.getLast().nextBlock = new BasicBlock();
                    this.basicBlocks.add(this.basicBlocks.getLast().nextBlock);
                    this.basicBlocks.getLast().instruction = instruction.nextInstruction;
                    instruction.nextInstruction = null;
                    instruction = this.basicBlocks.getLast().instruction;
                } else {
                    instruction = instruction.nextInstruction;
                }
            } else {
                break;
            }
        }
    }
}

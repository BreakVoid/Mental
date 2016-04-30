package MentalTranslator;

import MentalIR.*;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/29.
 */
public class MIPSTranslator {
    public MIPSMachine machine;
    public LinkedList<String> mipsStatement;
    public MIPSTranslator() {
        this.machine = new MIPSMachine();
        this.mipsStatement = new LinkedList<>();
    }

    public void translate(IRInstruction instruction) {
        for (; instruction != null; instruction = instruction.nextInstruction) {
            this.mipsStatement.add(instruction.toMips(this.machine));
        }
    }
}

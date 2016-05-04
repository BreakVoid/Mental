package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/1.
 */
public class IRMove extends IRInstruction {
    public IRDataValue src;
    public IRDataValue dest;
    public IRMove() {
        this.src = null;
        this.dest = null;
    }
    public IRMove(IRDataValue src) {
        this.src = src;
        this.dest = new IRDataValue();
    }

    public IRMove(IRDataValue src, IRDataValue dest) {
        this.src = src;
        this.dest = dest;
    }

    public IRMove(IRData src, IRData dest) {
        this.src = (IRDataValue) src;
        this.dest = (IRDataValue) dest;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.src instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.src).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.toAddress())
            );
        }

        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.dest.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public String toMips() {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.src instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.src).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.toAddress())
            );
        }

        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.dest.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

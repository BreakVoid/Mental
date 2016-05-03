package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataAddress;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRStore extends IRInstruction {
    public IRDataValue src;
    public IRData dest;
    public IRStore() {
        this.src = null;
        this.dest = null;
    }
    public IRStore(IRDataValue src, IRData dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "\tstore " + this.src.toString() + ", " + this.dest.toString();
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.src instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %s", ((IRDataIntLiteral) this.src).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.toAddress())
            );
        }

        if (this.dest instanceof IRDataAddress) {
            mipsInstructions.add(
                    String.format("\tlw $t1, %s", ((IRDataAddress) this.dest).address.toAddress())
            );
            mipsInstructions.add(
                    String.format("\tsw $t0, 0($t1)")
            );
        } else {
            mipsInstructions.add(
                    String.format("\tsw $t0, %s", this.dest.toAddress())
            );
        }

        String resultString = "";
        for (String line : mipsInstructions) {
            resultString += line + "\n";
        }
        return resultString.substring(0, resultString.length() - 1);
    }
}

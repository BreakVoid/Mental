package MentalIR;

import MentalIR.Data.IRDataAddress;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabelGlobalData;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLoad extends IRInstruction {
    public IRDataAddress src;
    public IRDataValue dest;
    public int loadSize;
    public IRLoad() {
        this.src = null;
        this.dest = null;
        this.loadSize = 4;
    }
    public IRLoad(IRDataAddress src) {
        this.loadSize = 4;
        this.src = src;
        this.dest = new IRDataValue();
    }
    public IRLoad(IRDataAddress src, int loadSize) {
        this.src = src;
        this.dest = new IRDataValue();
        this.loadSize = loadSize;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        if (this.src instanceof IRDataStringLiteral) {
            mipsInstructions.add(
                    String.format("\tla $t0, %s", this.src.toAddress())
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.address.toAddress())
            );
            if (this.loadSize == 4) {
                mipsInstructions.add(
                        String.format("\tlw $t0, 0($t0)")
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlb $t0, 0($t0)")
                );
            }
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

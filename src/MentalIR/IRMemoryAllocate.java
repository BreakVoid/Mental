package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRMemoryAllocate extends IRSystemCall {
    public IRDataValue amount;
    public IRDataValue res;
    public IRMemoryAllocate() {
        this.variant = 9;
        this.amount = null;
        this.res = null;
    }
    public IRMemoryAllocate(IRDataValue amount) {
        this.variant = 9;
        this.amount = amount;
        this.res = new IRDataValue();
        this.res.registerName = MIPSRegister.v0;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        mipsInstructions.add(
                "\tli $v0, 9"
        );
        if (this.amount instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $a0, %d", ((IRDataIntLiteral) this.amount).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $a0, %s", this.amount.toAddress())
            );
        }
        mipsInstructions.add(
                "\tsyscall"
        );

        mipsInstructions.add(
                String.format("\tsw $v0, %s", this.res.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

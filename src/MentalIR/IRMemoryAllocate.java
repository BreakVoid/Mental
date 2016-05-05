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
        this.beTranslate = true;
    }
    public IRMemoryAllocate(IRDataValue amount) {
        this.variant = 9;
        this.amount = amount;
        this.amount.refCount++;
        this.res = new IRDataValue();
        this.res.registerName = -1;
        this.beTranslate = true;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        if (this.nextInstruction != null) {
            throw new RuntimeException("basic block split error");
        }
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        this.amount.refCount--;
        if (this.amount.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.amount));
        } else {
            mipsMachine.refreshRegister(this.amount.registerName);
        }

        mipsInstructions.add(
                "\tli $v0, 9"
        );
        mipsInstructions.add(
                String.format("\tmove $a0, %s", this.amount.toRegister())
        );
        mipsInstructions.add(mipsMachine.storeAndCleanMachine());
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

    @Override
    public String toMips() {
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
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}

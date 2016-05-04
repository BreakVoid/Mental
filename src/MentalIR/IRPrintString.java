package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRPrintString extends IRSystemCall {
    public IRData stringLocation;
    public IRPrintString() {
        this.variant = 4;
        this.stringLocation = null;
    }
    public IRPrintString(IRData stringLocation) {
        this.variant = 4;
        this.stringLocation = stringLocation;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.stringLocation.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.stringLocation));
        } else {
            mipsMachine.refreshRegister(this.stringLocation.registerName);
        }

        mipsInstructions.add("\tli $v0, 4");
        mipsInstructions.add(
                String.format("\tmove $a0, %s", this.stringLocation.toRegister())
        );
        mipsInstructions.add(mipsMachine.storeAndCleanMachine());
        mipsInstructions.add("\tsyscall");

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }

    // for cisc code generation.
    @Override
    public String toMips() {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        mipsInstructions.add("\tli $v0, 4");
        if (this.stringLocation instanceof IRDataStringLiteral) {
            mipsInstructions.add(
                    String.format("\tla $a0, %s", this.stringLocation.globalDataLabel.toString())
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $a0, %s", this.stringLocation.toAddress())
            );
        }
        mipsInstructions.add("\tsyscall");

        String str = "";
        for (String statement : mipsInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}

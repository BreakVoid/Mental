package MentalIR;

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
        mipsInstructions.add("\tli $v0, 4");
        if (this.stringLocation instanceof IRStringLiteral) {
            mipsInstructions.add(
                    String.format("\tla $a0, %s", ((IRStringLiteral) this.stringLocation).label.toString())
            );
            this.stringLocation.produce();
        } else if (this.stringLocation instanceof IRVariable) {
            if (!this.stringLocation.inRegister) {
                mipsInstructions.add(
                        String.format("\tlw $a0, %s", this.stringLocation.toAddress())
                );
                this.stringLocation.produce();
            } else {
                mipsInstructions.add(
                        String.format("\tmove $a0, %s", this.stringLocation.toRegister())
                );
            }
        } else if (this.stringLocation instanceof IRTemporary) {
            if (this.stringLocation.registerName != MIPSRegister.a0) {
                mipsInstructions.add(
                        String.format("\tmove $a0, %s", this.stringLocation.toRegister())
                );
            }
        }
        this.stringLocation.consume();
        mipsInstructions.add("\tsyscall");
        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}
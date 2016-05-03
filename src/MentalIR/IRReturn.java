package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRReturn extends IRJumpLabel {
    public IRDataValue returnValue;
    public IRReturn() {
        this.returnValue = null;
    }
    public IRReturn(IRLabel gotoLabel, IRData returnValue) {
        super(gotoLabel);
        this.returnValue = returnValue;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        if (this.returnValue instanceof IRStringLiteral) {
            mipsInstructions.add(
                    String.format("\tla $v0, %s", ((IRStringLiteral) this.returnValue).label.toString())
            );
        } else if (this.returnValue instanceof IRVariable) {
            if (this.returnValue.inRegister) {
                mipsInstructions.add(
                        String.format("\tmove $v0, %s", this.returnValue.toRegister())
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlw $v0, %s", this.returnValue.toAddress())
                );
            }
        } else if (this.returnValue instanceof IRWordLiteral) {
            mipsInstructions.add(
                    String.format("\tli $v0, %d", ((IRWordLiteral) this.returnValue).context)
            );
        } else if (this.returnValue instanceof IRTemporary) {
            if (!this.returnValue.inRegister) {
                throw new RuntimeException();
            }
            this.returnValue.consume();
            mipsInstructions.add(
                    String.format("\tmove $v0, %s", this.returnValue.toRegister())
            );
        }
        if (this.nextInstruction != null) {
            if (this.nextInstruction.label != this.gotoLabel) {
                mipsInstructions.add(
                        String.format("\tb %s", this.gotoLabel.toString())
                );
            }
        }
        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

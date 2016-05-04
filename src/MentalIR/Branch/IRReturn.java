package MentalIR.Branch;

import MentalIR.Branch.IRJumpLabel;
import MentalIR.Data.IRDataIntLiteral;
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
    public IRReturn(IRLabel gotoLabel, IRDataValue returnValue) {
        super(gotoLabel);
        this.returnValue = returnValue;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        if (this.returnValue != null) {
            if (this.returnValue.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.returnValue));
            }
            mipsInstructions.add(
                    String.format("\tmove $v0, %s", this.returnValue.toRegister())
            );
        }
        mipsInstructions.add(mipsMachine.storeAndCleanMachine());
        mipsInstructions.add(
                String.format("\tb %s", this.gotoLabel.toString())
        );
        String str = "";
        for (String statement : mipsInstructions) {
            if (str.length() > 0) {
                str += statement + "\n";
            }
        }
        if (str.length() == 0) {
            str = " ";
        }
        return str.substring(0, str.length() - 1);
    }
}

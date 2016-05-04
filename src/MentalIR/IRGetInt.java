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
public class IRGetInt extends IRSystemCall {
    public IRData res;
    public IRGetInt() {
        this.variant = 5;
        this.res = new IRDataValue();
    }
    public IRGetInt(IRData res) {
        this.res = res;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        mipsInstructions.add("\tli $v0, 5");
        mipsInstructions.add("\tsyscall");
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

        mipsInstructions.add("\tli $v0, 5");
        mipsInstructions.add("\tsyscall");
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

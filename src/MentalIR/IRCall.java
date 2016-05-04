package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabelFunction;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRCall extends IRInstruction {
    public LinkedList<IRDataValue> parameters;
    public IRLabelFunction functionName;
    public IRData res;
    public IRCall() {
        this.parameters = new LinkedList<>();
        this.functionName = null;
        this.res = null;
    }
    public IRCall(IRLabelFunction functionName) {
        this.parameters = new LinkedList<>();
        this.functionName = functionName;
        this.res = new IRDataValue();
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label + ":");
        }

        for (int i = 0, count = this.parameters.size(); i < count; ++i) {
            IRDataValue thisParameter = this.parameters.get(i);

            if (thisParameter.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(thisParameter));
            }

            mipsInstructions.add(
                    String.format("\tsw %s, %d($sp)", thisParameter.toRegister(), -4 * (i + 1))
            );
        }
        mipsInstructions.add(mipsMachine.storeAndCleanMachine());
        mipsInstructions.add(
                String.format("jal %s", this.functionName.toString())
        );

        if (this.res != null) {
            mipsInstructions.add(
                    String.format("\tsw $v0, %s", this.res.toAddress())
            );
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + '\n';
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public String toMips() {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label + ":");
        }

        for (int i = 0, count = this.parameters.size(); i < count; ++i) {
            IRDataValue thisParameter = this.parameters.get(i);

            if (thisParameter instanceof IRDataIntLiteral) {
                mipsInstructions.add(
                        String.format("\tli $t0, %d", ((IRDataIntLiteral) thisParameter).literal)
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlw $t0, %s", thisParameter.toAddress())
                );
            }

            mipsInstructions.add(
                    String.format("\tsw $t0, %d($sp)", -4 * (i + 1))
            );
        }

        mipsInstructions.add(
                String.format("jal %s", this.functionName.toString())
        );

        if (this.res != null) {
            mipsInstructions.add(
                    String.format("\tsw $v0, %s", this.res.toAddress())
            );
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + '\n';
        }
        return str.substring(0, str.length() - 1);
    }
}

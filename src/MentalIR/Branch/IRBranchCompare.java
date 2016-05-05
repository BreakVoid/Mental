package MentalIR.Branch;

import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabel;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/5.
 */
public class IRBranchCompare extends IRBranch {
    public IRDataValue lhs, rhs;
    public IRBranchCompare() {
        this.lhs = null;
        this.rhs = null;
    }
    public IRBranchCompare(IRDataValue lhs, IRDataValue rhs, IRLabel gotoLabel) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.gotoLabel = gotoLabel;
    }

    public String toMips(MIPSMachine mipsMachine, String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        this.lhs.refCount--;
        this.rhs.refCount--;

        if (this.lhs.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.lhs));
        } else {
            mipsMachine.refreshRegister(this.lhs.registerName);
        }

        if (this.rhs instanceof IRDataIntLiteral) {
            String lhsRegister = this.lhs.toRegister();
            mipsInstructions.add(mipsMachine.storeAndCleanMachine());
            mipsInstructions.add(
                    String.format("\t%s %s, %d, %s", operand, lhsRegister, ((IRDataIntLiteral) this.rhs).literal, this.gotoLabel.toString())
            );
        } else {
            if (this.rhs.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.rhs));
            } else {
                mipsMachine.refreshRegister(this.rhs.registerName);
            }

            String lhsRegister = this.lhs.toRegister();
            String rhsRegister = this.rhs.toRegister();
            mipsInstructions.add(mipsMachine.storeAndCleanMachine());
            mipsInstructions.add(
                    String.format("\t%s %s, %s, %s", operand, lhsRegister, rhsRegister, this.gotoLabel.toString())
            );
        }

        String str = "";
        for (String statement : mipsInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}

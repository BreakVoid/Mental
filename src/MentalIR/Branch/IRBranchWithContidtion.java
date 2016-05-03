package MentalIR.Branch;

import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRBranchWithContidtion extends IRBranch {
    public IRDataValue condition;

    public String toMips(MIPSMachine mipsMachine, String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.condition instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.condition).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.condition.toAddress())
            );
        }
        mipsInstructions.add(
                String.format("\t%s $t0, %s", operand, this.gotoLabel.toString())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        if (str.length() == 0) {
            str = " ";
        }
        return str.substring(0, str.length() - 1);
    }
}

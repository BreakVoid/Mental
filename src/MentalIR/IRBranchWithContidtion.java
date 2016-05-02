package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRBranchWithContidtion extends IRBranch {
    public IRData condition;

    public String toMips(MIPSMachine mipsMachine, String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.condition instanceof IRWordLiteral) {
            if (((IRWordLiteral) this.condition).context == IRWordLiteral.TRUE_VALUE) {
                mipsInstructions.add(
                        String.format("\tb %s", this.gotoLabel.toString())
                );
            } else if (((IRWordLiteral) this.condition).context == IRWordLiteral.FALSE_VALUE) {
                mipsInstructions.add("");
            }
        } else {
            if (this.condition instanceof IRVariable) {
                if (!this.condition.inRegister) {
                    this.condition.registerName = mipsMachine.getEmptyRegister();
                    if (this.condition.registerName == -1) {
                        throw new RuntimeException("no enough register");
                    }
                    this.condition.inRegister = true;
                    this.condition.produce();

                    mipsInstructions.add(
                            String.format("\tlw %s, %s", this.condition.toRegister(), this.condition.toAddress())
                    );
                }
            }
            mipsInstructions.add(
                    String.format("\t%s %s, %s", operand, this.condition.toRegister(), this.gotoLabel.toString())
            );
            this.condition.consume();
        }

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

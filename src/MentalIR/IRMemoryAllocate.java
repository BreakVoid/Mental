package MentalIR;

import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRMemoryAllocate extends IRSystemCall {
    public IRData amount;
    public IRData res;
    public IRMemoryAllocate() {
        this.variant = 9;
        this.amount = null;
        this.res = null;
    }
    public IRMemoryAllocate(IRData amount) {
        this.variant = 9;
        this.amount = amount;
        this.res = new IRTemporary();
        this.res.registerName = MIPSRegister.v0;
        this.res.inRegister = true;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        mipsInstructions.add(
                "\tli $v0, 9"
        );
        if (this.amount instanceof IRWordLiteral) {
            mipsInstructions.add(
                    String.format("\tli $a0, %d", ((IRWordLiteral) this.amount).context)
            );
        } else if (this.amount instanceof IRVariable) {
            if (!this.amount.inRegister) {
                mipsInstructions.add(
                        String.format("\tlw $a0, %s", this.amount.toAddress())
                );
            } else {
                mipsInstructions.add(
                        String.format("\tmove $a0, %s", this.amount.toRegister())
                );
                this.amount.consume();
            }
        } else if (this.amount instanceof IRTemporary) {
            mipsInstructions.add(
                    String.format("\tmove $a0, %s", this.amount.toRegister())
            );
            this.amount.consume();
        }
        mipsInstructions.add(
                "\tsyscall"
        );
        this.res.produce();
        this.res.registerName = mipsMachine.getEmptyRegister();
        if (this.res.registerName == -1) {
            this.res.registerName = MIPSRegister.v0;
        } else {
            mipsMachine.use(this.res.registerName, this.res);
            mipsInstructions.add(
                    String.format("\tmove %s, $v0", this.res.toRegister())
            );
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

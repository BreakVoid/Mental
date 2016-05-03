package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRMemoryAllocate extends IRSystemCall {
    public IRDataValue amount;
    public IRDataValue res;
    public IRMemoryAllocate() {
        this.variant = 9;
        this.amount = null;
        this.res = null;
    }
    public IRMemoryAllocate(IRDataValue amount) {
        this.variant = 9;
        this.amount = amount;
        this.res = new IRDataValue();
        this.res.registerName = MIPSRegister.v0;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        LinkedList<Integer> storedRegister = new LinkedList<>();
        LinkedList<String> reloadRegister = new LinkedList<>();

        for (int i = 8; i < 26; ++i) {
            if (!mipsMachine.isEmpty(i)) {
                if (!mipsMachine.canBeRewrite(i)) {
                    mipsInstructions.add(
                            String.format("\tsw $%d, %d($sp)", i, 4 * (31 - i))
                    );
                    storedRegister.add(i);
                }
            }
        }

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

        for (int i = 8; i < 26; ++i) {
            if (!mipsMachine.isEmpty(i)) {
                if (mipsMachine.canBeRewrite(i)) {
                    if (mipsMachine.registerData[i] instanceof IRVariable) {
                        mipsInstructions.add(
                                String.format("\tlw $%d, %s", i, mipsMachine.registerData[i].toAddress())
                        );
                    } else if (mipsMachine.registerData[i] instanceof IRStringLiteral) {
                        mipsInstructions.add(
                                String.format("\tla $%d, %s", i, mipsMachine.registerData[i].toAddress())
                        );
                    }
                }
            }
        }

        for (int i : storedRegister) {
            mipsInstructions.add(
                    String.format("\tlw $%d, %d($sp)", i, 4 * (31 - i))
            );
        }

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

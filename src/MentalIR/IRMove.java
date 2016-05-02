package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/5/1.
 */
public class IRMove extends IRInstruction {
    public IRDataValue src;
    public IRDataValue dest;
    public IRMove() {
        this.src = null;
        this.dest = null;
    }
    public IRMove(IRData src) {
        this.src = src;
        this.dest = new IRTemporary();
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.src instanceof IRVariable) {
            if (!this.src.inRegister) {
                this.src.registerName = mipsMachine.getEmptyRegister();
                if (this.src.registerName == -1) {
                    throw new RuntimeException("no enough register");
                }
                this.src.inRegister = true;
                mipsMachine.use(this.src.registerName, this.src);
                this.src.produce();
                mipsInstructions.add(
                        String.format("\tlw %s, %s", this.src.toRegister(), this.src.toAddress())
                );
            }
        }
        this.dest.registerName = mipsMachine.getEmptyRegister();
        if (this.dest.registerName == -1) {
            throw new RuntimeException("no enough register");
        }
        this.dest.inRegister = true;
        mipsMachine.use(this.dest.registerName, this.dest);

        mipsInstructions.add(
                String.format("\tmove %s, %s", this.dest.toRegister(), this.src.toRegister())
        );

        this.dest.produce();
        this.src.consume();

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

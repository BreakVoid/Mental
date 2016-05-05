package MentalIR;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
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
    public IRMove(IRDataValue src) {
        this.src = src;
        this.src.refCount++;
        this.dest = new IRDataValue();
        this.beTranslate = true;
    }

    public IRMove(IRDataValue src, IRDataValue dest) {
        this.src = src;
        this.src.refCount++;
        this.dest = dest;
        this.beTranslate = true;
    }

    public IRMove(IRData src, IRData dest) {
        this.src = (IRDataValue) src;
        this.src.refCount++;
        this.dest = (IRDataValue) dest;
        this.beTranslate = true;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        this.src.refCount--;
        if (this.src.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.src));
        } else {
            mipsMachine.refreshRegister(this.src.registerName);
        }

        if (this.dest.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsMachine.rewriteFirstLoadRegister(this.dest);
        } else {
            mipsMachine.updateRegister(this.dest.registerName);
        }

        mipsInstructions.add(
                String.format("\tmove %s, %s", this.dest.toRegister(), this.src.toRegister())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }

    // for cisc code generation.
    @Override
    public String toMips() {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.src instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.src).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.toAddress())
            );
        }

        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.dest.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

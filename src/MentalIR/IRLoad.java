package MentalIR;

import MentalIR.Data.IRDataAddress;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Data.IRDataValue;
import MentalIR.Label.IRLabelGlobalData;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLoad extends IRInstruction {
    public IRDataAddress src;
    public IRDataValue dest;
    public int loadSize;
    public IRLoad() {
        this.src = null;
        this.dest = null;
        this.loadSize = 4;
    }
    public IRLoad(IRDataAddress src) {
        this.loadSize = 4;
        this.src = src;
        if (!(this.src instanceof IRDataStringLiteral)) {
            this.src.address.refCount++;
        }
        this.dest = new IRDataValue();
    }
    public IRLoad(IRDataAddress src, int loadSize) {
        this.src = src;
        if (!(this.src instanceof IRDataStringLiteral)) {
            this.src.address.refCount++;
        }
        this.dest = new IRDataValue();
        this.loadSize = loadSize;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }


        if (this.src instanceof IRDataStringLiteral) {
            if (((IRDataStringLiteral) this.src).registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.src));
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
            ((IRDataStringLiteral) this.src).registerName = -1;
        } else {
            this.src.address.refCount--;
            if (this.src.address.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.src.address));
            } else {
                mipsMachine.refreshRegister(this.src.address.registerName);
            }
            if (this.dest.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsMachine.rewriteFirstLoadRegister(this.dest);
            } else {
                mipsMachine.updateRegister(this.dest.registerName);
            }
            if (this.loadSize == 4) {
                mipsInstructions.add(
                        String.format("\tlw %s, 0(%s)", this.dest.toRegister(), this.src.address.toRegister())
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlb %s, 0(%s)", this.dest.toRegister(), this.src.address.toRegister())
                );
            }
        }

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
        if (this.src instanceof IRDataStringLiteral) {
            mipsInstructions.add(
                    String.format("\tla $t0, %s", this.src.toAddress())
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.src.address.toAddress())
            );
            if (this.loadSize == 4) {
                mipsInstructions.add(
                        String.format("\tlw $t0, 0($t0)")
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlb $t0, 0($t0)")
                );
            }
        }
        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.dest.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}

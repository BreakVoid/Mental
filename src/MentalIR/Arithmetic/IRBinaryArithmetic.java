package MentalIR.Arithmetic;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRBinaryArithmetic extends IRArithmetic {
    public IRDataValue lhs, rhs;
    public IRBinaryArithmetic() {
        this.lhs = this.rhs = null;
    }
    public IRBinaryArithmetic(IRDataValue lhs, IRDataValue rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.res = new IRDataValue();
    }
    public IRBinaryArithmetic(IRDataValue lhs, IRDataValue rhs, IRDataValue res) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.res = res;
    }

    public IRBinaryArithmetic(IRData lhs, IRData rhs, IRDataValue res) {
        this.lhs = (IRDataValue) lhs;
        this.rhs = (IRDataValue) rhs;
        this.res = res;
    }

    public String toMips(MIPSMachine mipsMachine, String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.lhs.registerName == -1) {
            mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
            mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.lhs));
        } else {
            mipsMachine.refreshRegister(this.lhs.registerName);
        }

        if (this.rhs instanceof IRDataIntLiteral) {
            if (this.res.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsMachine.rewriteFirstLoadRegister(this.res);
            } else {
                mipsMachine.updateRegister(this.res.registerName);
            }
            mipsInstructions.add(
                    String.format("\t%s %s, %s, %d", operand, this.res.toRegister(), this.lhs.toRegister(), ((IRDataIntLiteral) this.rhs).literal)
            );
        } else {
            if (this.rhs.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsInstructions.add(mipsMachine.replaceFirstLoadRegisterWithLoad(this.rhs));
            } else {
                mipsMachine.refreshRegister(this.rhs.registerName);
            }
            if (this.res.registerName == -1) {
                mipsInstructions.add(mipsMachine.storeFirstLoadRegister());
                mipsMachine.rewriteFirstLoadRegister(this.res);
            } else {
                mipsMachine.updateRegister(this.res.registerName);
            }
            mipsInstructions.add(
                    String.format("\t%s %s, %s, %s", operand, this.res.toRegister(), this.lhs.toRegister(), this.rhs.toRegister())
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

    // for cisc code generation.
    public String toMips(String operand) {

        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.lhs instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $%d, %d", MIPSRegister.t0, ((IRDataIntLiteral) this.lhs).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $%d, %s", MIPSRegister.t0, this.lhs.toAddress())
            );
        }

        if (this.rhs instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\t%s $t0, $t0, %d", operand, ((IRDataIntLiteral) this.rhs).literal)
            );
            mipsInstructions.add(
                    String.format("\tsw $t0, %s", this.res.toAddress())
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t1, %s", this.rhs.toAddress())
            );
            mipsInstructions.add(
                    String.format("\t%s $t0, $t0, $t1", operand)
            );
            mipsInstructions.add(
                    String.format("\tsw $t0, %s", this.res.toAddress())
            );
        }
        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

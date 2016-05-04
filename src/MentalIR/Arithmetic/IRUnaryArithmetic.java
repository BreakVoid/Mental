package MentalIR.Arithmetic;

import MentalIR.Arithmetic.IRArithmetic;
import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataValue;
import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRUnaryArithmetic extends IRArithmetic {
    public IRDataValue child;
    public IRUnaryArithmetic() {
        super();
        this.child = null;
    }
    public IRUnaryArithmetic(IRDataValue child, IRDataValue res) {
        this.child = child;
        this.res = res;
    }

    public String toMips(MIPSMachine mipsMachine, String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.child instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.child).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.child.toAddress())
            );
        }
        mipsInstructions.add(
                String.format("\t%s $t0, $t0", operand)
        );
        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.res.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }

    public String toMips(String operand) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (this.child instanceof IRDataIntLiteral) {
            mipsInstructions.add(
                    String.format("\tli $t0, %d", ((IRDataIntLiteral) this.child).literal)
            );
        } else {
            mipsInstructions.add(
                    String.format("\tlw $t0, %s", this.child.toAddress())
            );
        }
        mipsInstructions.add(
                String.format("\t%s $t0, $t0", operand)
        );
        mipsInstructions.add(
                String.format("\tsw $t0, %s", this.res.toAddress())
        );

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

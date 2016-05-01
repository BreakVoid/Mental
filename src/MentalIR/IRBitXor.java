package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitXor extends IRBinaryArithmetic {
    public IRBitXor() {
        super();
    }
    public IRBitXor(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
    @Override
    public String toMips(MIPSMachine mipsMachine) {

        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (!this.lhs.inRegister) {
            this.lhs.registerName = mipsMachine.getEmptyRegister();
            if (this.lhs.registerName == -1) {
                throw new RuntimeException("no enough register");
            }
            this.lhs.inRegister = true;
            mipsMachine.use(this.lhs.registerName, this.lhs);
            if (this.lhs instanceof IRVariable) {
                mipsInstructions.add(
                        String.format("\tlw %s, %s", this.lhs.toRegister(), this.lhs.toAddress())
                );
            } else if (this.lhs instanceof IRWordLiteral) {
                mipsInstructions.add(
                        String.format("\tli %s, %d", this.lhs.toRegister(), ((IRWordLiteral) this.lhs).context)
                );
            }
            this.lhs.produce();
        }

        if (this.rhs instanceof IRWordLiteral) {
            String lhsRegister = this.lhs.toRegister();
            this.lhs.consume();
            this.res.registerName = mipsMachine.getEmptyRegister();
            if (this.res.registerName == -1) {
                throw new RuntimeException("no enough register.");
            }
            this.res.inRegister = true;
            mipsMachine.use(this.res.registerName, this.res);

            mipsInstructions.add(
                    String.format("\txor %s, %s, %d", this.res.toRegister(), lhsRegister, ((IRWordLiteral) this.rhs).context)
            );

            this.res.produce();
        } else {
            if (this.rhs instanceof IRVariable) {
                if (!this.rhs.inRegister) {
                    this.rhs.registerName = mipsMachine.getEmptyRegister();
                    if (this.rhs.registerName == -1) {
                        throw new RuntimeException("no enough register.");
                    }
                    this.rhs.inRegister = true;
                    mipsMachine.use(this.rhs.registerName, this.rhs);
                    mipsInstructions.add(
                            String.format("\tlw %s, %s", this.rhs.toRegister(), this.rhs.toAddress())
                    );
                    this.rhs.produce();
                }
            }

            String lhsRegister = this.lhs.toRegister();
            String rhsRegister = this.rhs.toRegister();
            this.lhs.consume();
            this.rhs.consume();

            this.res.registerName = mipsMachine.getEmptyRegister();
            if (this.res.registerName == -1) {
                throw new RuntimeException("no enough register");
            }
            this.res.inRegister = true;
            mipsMachine.use(this.res.registerName, this.res);

            mipsInstructions.add(
                    String.format("\txor %s, %s, %s", this.res.toRegister(), lhsRegister, rhsRegister)
            );
            this.res.produce();
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

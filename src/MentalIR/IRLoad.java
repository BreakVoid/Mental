package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLoad extends IRInstruction {
    public IRLocate src;
    public IRTemporary dest;
    public int loadSize;
    public IRLoad() {
        this.src = null;
        this.dest = null;
        this.loadSize = 4;
    }
    public IRLoad(IRLocate locate) {
        this.loadSize = 4;
        this.src = locate;
        this.dest = new IRTemporary();
    }
    public IRLoad(IRLocate locate, int loadSize) {
        this.src = locate;
        this.dest = new IRTemporary();
        this.loadSize = loadSize;
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();

        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }

        if (!this.src.headPoint.inRegister) {
            this.src.headPoint.registerName = mipsMachine.getEmptyRegister();
            if (this.src.headPoint.registerName == -1) {
                throw new RuntimeException("no enough register.");
            }
            this.src.headPoint.inRegister = true;
            mipsMachine.use(this.src.headPoint.registerName, this.src.headPoint);

            if (this.src.headPoint instanceof IRLabelGlobalData) {
                mipsInstructions.add(
                        String.format("\tla %s, %s", this.src.headPoint.toRegister(), this.src.headPoint.toString())
                );
                this.src.produce();
            } else if (this.src.headPoint instanceof IRVariable) {
                mipsInstructions.add(
                        String.format("\tlw %s, %s", this.src.headPoint.toRegister(), this.src.headPoint.toAddress())
                );
                this.src.produce();
            } else if (this.src.headPoint instanceof IRLocate) {
                throw new RuntimeException("what the fuck!!!");
            }
        }
        if (this.src.shift instanceof IRWordLiteral) {
            String headRegister = this.src.headPoint.toRegister();
            this.src.headPoint.consume();

            this.dest.produce();
            this.dest.registerName = mipsMachine.getEmptyRegister();
            if (this.dest.registerName == -1) {
                throw new RuntimeException("no enough register.");
            }
            this.dest.inRegister = true;
            mipsMachine.use(this.dest.registerName, this.dest);

            if (this.loadSize == 4) {
                mipsInstructions.add(
                        String.format("\tlw %s, %d(%s)", this.dest.toRegister(), ((IRWordLiteral) this.src.shift).context, headRegister)
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlb %s, %d(%s)", this.dest.toRegister(), ((IRWordLiteral) this.src.shift).context, headRegister)
                );
            }
        } else {
            if (this.src.shift instanceof IRVariable) {
                if (!this.src.shift.inRegister) {
                    this.src.shift.registerName = mipsMachine.getEmptyRegister();
                    if (this.src.shift.registerName == -1) {
                        throw new RuntimeException("no enough register.");
                    }
                    this.src.shift.inRegister = true;
                    this.src.shift.produce();
                    mipsMachine.use(this.src.shift.registerName, this.src.shift);
                }
            }
            String headRegister = this.src.headPoint.toRegister();
            String shiftRegister = this.src.shift.toRegister();
            this.src.headPoint.consume();
            this.src.shift.consume();
            int anEmptyRegister = mipsMachine.getEmptyRegister();
            mipsInstructions.add(
                    String.format("\tadd $%s, %s, %s", anEmptyRegister, headRegister, shiftRegister)
            );
            if (this.loadSize == 4) {
                mipsInstructions.add(
                        String.format("\tlw $%s, 0($%s)", anEmptyRegister, anEmptyRegister)
                );
            } else {
                mipsInstructions.add(
                        String.format("\tlb $%s, 0($%s)", anEmptyRegister, anEmptyRegister)
                );
            }
            this.dest.registerName = anEmptyRegister;
            this.dest.inRegister = true;
            this.dest.produce();
            mipsMachine.use(this.dest.registerName, this.dest);
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}

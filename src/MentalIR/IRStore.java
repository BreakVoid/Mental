package MentalIR;

import MentalTranslator.MIPSMachine;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRStore extends IRInstruction {
    public IRData src;
    public IRData dest;
    public IRStore() {
        this.src = this.dest = null;
    }
    public IRStore(IRData src, IRData dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "\tstore " + this.src.toString() + ", " + this.dest.toString();
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label.toString() + ":");
        }
        // process the source of data.
        if (!this.src.inRegister) {
            this.src.registerName = mipsMachine.getEmptyRegister();
            if (this.src.registerName == -1) {
                throw new RuntimeException("no enough register.");
            }
            this.src.inRegister = true;
            if (this.src instanceof IRVariable) {
                ((IRVariable) this.src).produce();
            }
            if (this.src instanceof IRWordLiteral) {
                ((IRWordLiteral) this.src).produce();
            }
            if (this.src instanceof IRStringLiteral) {
                this.src.produce();
            }
            mipsMachine.use(this.src.registerName, this.src);
            if (this.src instanceof IRStringLiteral) {
                mipsInstructions.add(
                        String.format("\tla %s, %s", this.src.toRegister(), ((IRStringLiteral) this.src).label.toString())
                );
            } else if (this.src instanceof IRWordLiteral) {
                mipsInstructions.add(
                        String.format("\tli %s, %d", this.src.toRegister(), ((IRWordLiteral) this.src).context)
                );
            } else if (this.src instanceof IRVariable) {
                mipsInstructions.add(
                        String.format("\tlw %s, %s", this.src.toRegister(), this.src.toAddress())
                );
            }
        }

        // process the real address to store.
        if (this.dest instanceof IRLocate) {
            // would store a item of a array or a member of a class.
            if (!((IRLocate) this.dest).headPoint.inRegister) {
                // load the head to the register.
                ((IRLocate) this.dest).headPoint.registerName = mipsMachine.getEmptyRegister();
                if (((IRLocate) this.dest).headPoint.registerName == -1) {
                    throw new RuntimeException("no enough register.");
                }
                ((IRLocate) this.dest).headPoint.inRegister = true;
                if (((IRLocate) this.dest).headPoint instanceof IRVariable) {
                    ((IRVariable) ((IRLocate) this.dest).headPoint).produce();
                }
                // take a register to store.
                mipsMachine.use(((IRLocate) this.dest).headPoint.registerName, ((IRLocate) this.dest).headPoint);

                // load the head for memory.
                mipsInstructions.add(
                        String.format("\tlw %s, %s", ((IRLocate) this.dest).headPoint.toRegister(), ((IRLocate) this.dest).headPoint.toAddress())
                );
            }

            if (((IRLocate) this.dest).shift instanceof IRWordLiteral) {
                // the shift is a literal.
                mipsInstructions.add(
                        String.format("\tsw %s, %d(%s)",
                                this.src.toRegister(),
                                ((IRWordLiteral) ((IRLocate) this.dest).shift).context, ((IRLocate) this.dest).headPoint.toRegister())
                );
                if (this.src instanceof IRTemporary) {
                    this.src.consume();
                } else if (this.src instanceof IRVariable) {
                    this.src.consume();
                } else if (this.dest instanceof IRStringLiteral) {
                    this.src.consume();
                } else {
                    mipsMachine.erase(this.src.registerName);
                }
            } else if (((IRLocate) this.dest).shift instanceof IRVariable) {
                // the shift is a data and it is in a variable.
                IRVariable shift = (IRVariable) ((IRLocate) this.dest).shift;
                if (!shift.inRegister) {
                    shift.registerName = mipsMachine.getEmptyRegister();
                    if (shift.registerName == -1) {
                        throw new RuntimeException("no enough register.");
                    }
                    shift.inRegister = true;
                    shift.produce();
                    mipsMachine.use(shift.registerName, shift);
                }
                String headRegister = ((IRLocate) this.dest).headPoint.toRegister();
                if (((IRLocate) this.dest).headPoint instanceof IRVariable) {
                    ((IRVariable) ((IRLocate) this.dest).headPoint).consume();
                } else if (((IRLocate) this.dest).headPoint instanceof IRTemporary) {
                    ((IRTemporary) ((IRLocate) this.dest).headPoint).consume();
                }
                IRTemporary realAddr = new IRTemporary();
                realAddr.produce();
                realAddr.inRegister = true;
                realAddr.registerName = mipsMachine.getEmptyRegister();
                mipsMachine.use(realAddr.registerName, realAddr);
                mipsInstructions.add(
                        String.format("\tadd %s, %s, %s", realAddr.toRegister(), ((IRLocate) this.dest).shift.toRegister(), headRegister)
                );
                mipsInstructions.add(
                        String.format("\tsw %s, 0(%s)", this.src.toRegister(), realAddr.toRegister())
                );
                realAddr.consume();
                ((IRVariable) ((IRLocate) this.dest).shift).consume();
                if (this.src instanceof IRVariable) {
                    ((IRVariable) this.src).consume();
                } else if (this.src instanceof IRTemporary) {
                    ((IRTemporary) this.src).consume();
                } else if (this.src instanceof IRStringLiteral) {
                    ((IRStringLiteral) this.src).consume();
                } else {
                    mipsMachine.erase(this.src.registerName);
                }
            } else if (((IRLocate) this.dest).shift instanceof IRTemporary) {
                String headRegister = ((IRLocate) this.dest).headPoint.toRegister();
                String shiftRegister = ((IRLocate) this.dest).shift.toRegister();
                if (((IRLocate) this.dest).headPoint instanceof IRVariable) {
                    ((IRVariable) ((IRLocate) this.dest).headPoint).consume();
                } else if (((IRLocate) this.dest).headPoint instanceof IRTemporary) {
                    ((IRTemporary) ((IRLocate) this.dest).headPoint).consume();
                }
                ((IRTemporary) ((IRLocate) this.dest).shift).consume();
                IRTemporary realAddr = new IRTemporary();
                realAddr.produce();
                realAddr.inRegister = true;
                realAddr.registerName = mipsMachine.getEmptyRegister();
                mipsMachine.use(realAddr.registerName, realAddr);
                mipsInstructions.add(
                        String.format("\tadd %s, %s, %s", realAddr.toRegister(), headRegister, shiftRegister)
                );
                mipsInstructions.add(
                        String.format("\tsw %s, 0(%s)", this.src.toRegister(), realAddr.toRegister())
                );
                realAddr.consume();
                if (this.src instanceof IRVariable) {
                    ((IRVariable) this.src).consume();
                } else if (this.src instanceof IRTemporary) {
                    ((IRTemporary) this.src).consume();
                } else if (this.src instanceof IRStringLiteral) {
                    ((IRStringLiteral) this.src).consume();
                } else {
                    mipsMachine.erase(this.src.registerName);
                }
            }
        } else if (this.dest instanceof IRVariable) {
            mipsInstructions.add(
                    String.format("\tsw %s, %s", this.src.toRegister(), this.dest.toAddress())
            );
            if (this.src instanceof IRVariable) {
                this.src.consume();
            } else if (this.src instanceof IRTemporary){
                this.src.consume();
            } else if (this.src instanceof IRStringLiteral) {
                this.src.consume();
            } else {
                mipsMachine.erase(this.src.registerName);
            }
        } else {
            throw new RuntimeException("a strange address.");
        }
        String resultString = "";
        for (String line : mipsInstructions) {
            resultString += line + "\n";
        }
        return resultString.substring(0, resultString.length() - 1);
    }
}

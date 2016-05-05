package MentalTranslator;

import MentalIR.Arithmetic.IRArithmetic;
import MentalIR.Arithmetic.IRBinaryArithmetic;
import MentalIR.Arithmetic.IRMod;
import MentalIR.Arithmetic.IRUnaryArithmetic;
import MentalIR.Data.IRDataAddress;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.IRInstruction;
import MentalIR.IRLoad;
import MentalIR.IRMemoryAllocate;
import MentalIR.IRMove;

/**
 * Created by Songyu on 16/5/5.
 */
public class DeadCodeKiller {
    public static void kill(IRInstruction inputInstruction) {
        while (true) {
            boolean anyKilled = false;
            for (IRInstruction instruction = inputInstruction; instruction != null; instruction = instruction.nextInstruction) {
                if (!instruction.beTranslate) {
                    continue;
                }
                if (instruction instanceof IRArithmetic) {
                    if (((IRArithmetic) instruction).res.refCount <= 0) {
                        instruction.beTranslate = false;
                        anyKilled = true;
                        if (instruction instanceof IRBinaryArithmetic) {
                            ((IRBinaryArithmetic) instruction).lhs.refCount--;
                            ((IRBinaryArithmetic) instruction).rhs.refCount--;
                        } else if (instruction instanceof IRUnaryArithmetic) {
                            ((IRUnaryArithmetic) instruction).child.refCount--;
                        }
                    }
                } else if (instruction instanceof IRLoad) {
                    if (((IRLoad) instruction).dest.refCount <= 0) {
                        instruction.beTranslate = false;
                        anyKilled = true;
                        if (!(((IRLoad) instruction).src instanceof IRDataStringLiteral)) {
                            ((IRLoad) instruction).src.address.refCount--;
                        }
                    }
                } else if (instruction instanceof IRMove) {
                    if (((IRMove) instruction).dest.globalID == -1 && ((IRMove) instruction).dest.refCount == 0) {
                        instruction.beTranslate = false;
                        anyKilled = true;
                        ((IRMove) instruction).src.refCount--;
                    }
                } else if (instruction instanceof IRMemoryAllocate) {
                    if (((IRMemoryAllocate) instruction).res.refCount <= 0) {
                        instruction.beTranslate = false;
                        anyKilled = true;
                        ((IRMemoryAllocate) instruction).amount.refCount--;
                    }
                }
            }
            if (!anyKilled) {
                break;
            }
        }
    }
}

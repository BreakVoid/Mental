package MentalTranslator;

import MentalIR.Arithmetic.*;
import MentalIR.Branch.*;
import MentalIR.IRInstruction;
import MentalIR.IRNullOperation;

/**
 * Created by Songyu on 16/5/5.
 */
public class BranchCompressor {
    public static IRInstruction compress(IRInstruction instruction) {
        IRNullOperation headInstruction = new IRNullOperation();
        headInstruction.nextInstruction = instruction;
        for (instruction = headInstruction; instruction != null; instruction = instruction.nextInstruction) {
            if (instruction.nextInstruction instanceof IRCompare) {
                if (instruction.nextInstruction.nextInstruction instanceof IRBranchWithCondition) {
                    IRCompare compare = (IRCompare) instruction.nextInstruction;
                    IRBranchWithCondition branch = (IRBranchWithCondition) instruction.nextInstruction.nextInstruction;

                    // whether the result of compare is the condition of the branch
                    if (compare.res == branch.condition && compare.res.refCount == 1) {
                        // process the new branch instruction.
                        IRBranchCompare newBranch;

                        // decrease the reference count of the result of compare
                        compare.res.refCount--;


                        if ((compare instanceof IRCompareEqual && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareNotEqual && branch instanceof IRBranchEqualZero)) {
                            // branch when equal
                            newBranch = new IRBranchCompareEqual(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else if ((compare instanceof IRCompareNotEqual && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareEqual && branch instanceof IRBranchEqualZero)) {
                            // branch when unequal
                            newBranch = new IRBranchCompareNotEqual(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else if ((compare instanceof IRCompareLess && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareGreaterEqual && branch instanceof IRBranchEqualZero)) {
                            // branch when less
                            newBranch = new IRBranchCompareLess(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else if ((compare instanceof IRCompareLessEqual && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareGreater && branch instanceof IRBranchEqualZero)) {
                            // branch when less equal
                            newBranch = new IRBranchCompareLessEqual(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else if ((compare instanceof IRCompareGreater && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareLessEqual && branch instanceof IRBranchEqualZero)) {
                            // branch when greater
                            newBranch = new IRBranchCompareGreater(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else if ((compare instanceof IRCompareGreaterEqual && branch instanceof IRBranchNotEqualZero)
                                || (compare instanceof IRCompareLess && branch instanceof IRBranchEqualZero)) {
                            // branch when greater equal
                            newBranch = new IRBranchCompareGreaterEqual(
                                    compare.lhs,
                                    compare.rhs,
                                    branch.gotoLabel
                            );
                        } else {
                            throw new RuntimeException("unknown combination of branch after compare");
                        }

                        // all combinations have been enumerated
                        //     it is time for re-link the link list.
                        instruction.nextInstruction = newBranch;
                        newBranch.nextInstruction = branch.nextInstruction;
                        newBranch.label = compare.label;
                    }
                }
            }
        }
        return headInstruction.nextInstruction;
    }
}

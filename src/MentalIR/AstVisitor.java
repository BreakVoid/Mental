package MentalIR;
import MentalAST.*;
import MentalAST.AstDeclaration.AstDeclaration;
import MentalAST.AstExpression.*;
import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/19.
 */
public class AstVisitor {
    public LinkedList<IRInstruction> labelLocations;
    public HashMap<AstBaseNode, IRData> expressionResult;
    public LinkedList<IRStringLiteral> stringLiterals;
    public int nextLabel;

    public AstVisitor() {
        this.labelLocations = new LinkedList<>();
        this.expressionResult = new HashMap<>();
        this.stringLiterals = new LinkedList<>();
        this.nextLabel = 0;
    }

    public LinkedList<IRInstruction> visitBase(AstBaseNode node) {
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitProgram(AstProgram astProgram) {
        for (AstBaseNode astDeclaration : astProgram.declarations) {

        }
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitIdentifier(AstIdentifier astIdentifier) {
        IRVariable irVariable = new IRVariable();
        this.expressionResult.put(astIdentifier, irVariable);
        irVariable.variableID = astIdentifier.variable.variableID;
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitIntLiteral(AstIntLiteral astIntLiteral) {
        IRWordLiteral irWordLiteral = new IRWordLiteral(astIntLiteral.literalContext);
        this.expressionResult.put(astIntLiteral, irWordLiteral);
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitNullConstant(AstNullConstant astNullConstant) {
        IRWordLiteral irWordLiteral = new IRWordLiteral();
        this.expressionResult.put(astNullConstant, irWordLiteral);
        irWordLiteral.context = IRWordLiteral.NULL_VALUE;
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitBoolConstant(AstBoolConstant astBoolConstant) {
        IRWordLiteral irWordLiteral = new IRWordLiteral();
        this.expressionResult.put(astBoolConstant, irWordLiteral);
        if (astBoolConstant.boolConstant) {
            irWordLiteral.context = IRWordLiteral.TRUE_VALUE;
        } else {
            irWordLiteral.context = IRWordLiteral.FALSE_VALUE;
        }
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitStringLiteral(AstStringLiteral astStringLiteral) {
        IRStringLiteral irStringLiteral = new IRStringLiteral(astStringLiteral.literalContext);
        this.stringLiterals.add(irStringLiteral);
        this.expressionResult.put(astStringLiteral, irStringLiteral);
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitAssignExpression(AstAssignExpression astAssignExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astAssignExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astAssignExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astAssignExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astAssignExpression.rightExpression);
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.getLast() != null) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = lhsInstructions;
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
        }
        resultInstructions.addAll(rhsInstructions);
        IRStore irStore = new IRStore(rhsRes, lhsRes);
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = irStore;
        }
        resultInstructions.add(irStore);
        this.expressionResult.put(astAssignExpression, lhsRes);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitAdditiveExpression(AstAdditiveExpression astAdditiveExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astAdditiveExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astAdditiveExpression.rightExpression.visit(this);

        IRData lhsRes = this.expressionResult.get(astAdditiveExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astAdditiveExpression.rightExpression);

        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.getLast() != null) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.getLast() != null) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = lhsInstructions;
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
        }
        resultInstructions.addAll(rhsInstructions);
        if (astAdditiveExpression.op == AstAdditiveExpression.ADD) {
            IRAdd irAdd = new IRAdd(lhsRes, rhsRes, new IRTemporary());
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);
            this.expressionResult.put(astAdditiveExpression, irAdd.res);
        } else {
            IRSub irSub = new IRSub(lhsRes, rhsRes, new IRTemporary());
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irSub;
            }
            resultInstructions.add(irSub);
            this.expressionResult.put(astAdditiveExpression, irSub.res);
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitUnaryAdditiveExpression(AstUnaryAdditiveExpression astUnaryAdditiveExpression) {
        LinkedList<IRInstruction> resultInstructions = astUnaryAdditiveExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astUnaryAdditiveExpression.childExpression);
        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        if (astUnaryAdditiveExpression.op == AstUnaryAdditiveExpression.ADD) {
            IRAdd irAdd = new IRAdd(new IRWordLiteral(0), childRes, new IRTemporary());
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);
            this.expressionResult.put(astUnaryAdditiveExpression, irAdd.res);
        } else {
            IRSub irSub = new IRSub(new IRWordLiteral(0), childRes, new IRTemporary());
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irSub;
            }
            resultInstructions.add(irSub);
            this.expressionResult.put(astUnaryAdditiveExpression, irSub.res);
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitMulDivExpression(AstMulDivExpression astMulDivExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astMulDivExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astMulDivExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astMulDivExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astMulDivExpression.rightExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.getLast() != null) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.getLast() != null) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.getLast() != null) {
            lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
        }
        resultInstructions = lhsInstructions;
        resultInstructions.addAll(rhsInstructions);
        IRBinaryArithmetic thisInstruction;
        if (astMulDivExpression.op == AstMulDivExpression.MUL) {
            thisInstruction = new IRMul(lhsRes, rhsRes, new IRTemporary());
        } else if (astMulDivExpression.op == AstMulDivExpression.DIV) {
            thisInstruction = new IRDiv(lhsRes, rhsRes, new IRTemporary());
        } else if (astMulDivExpression.op == AstMulDivExpression.MOD) {
            thisInstruction = new IRMod(lhsRes, rhsRes, new IRTemporary());
        } else {
            throw new RuntimeException();
        }
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astMulDivExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitArraySubscriptingExpression(AstArraySubscriptingExpression astArraySubscriptingExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> primaryInstructions = astArraySubscriptingExpression.primaryExpression.visit(this);
        LinkedList<IRInstruction> positionInstructions = astArraySubscriptingExpression.positionExpression.visit(this);
        IRData primaryRes = this.expressionResult.get(astArraySubscriptingExpression.primaryExpression);
        IRData positionRes = this.expressionResult.get(astArraySubscriptingExpression.positionExpression);
        if (primaryRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) primaryRes).load();
            if (primaryInstructions.getLast() != null) {
                primaryInstructions.getLast().nextInstruction = irLoad;
            }
            primaryInstructions.add(irLoad);
            primaryRes = irLoad.dest;
        }
        if (positionRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) positionRes).load();
            if (positionInstructions.getLast() != null) {
                positionInstructions.getLast().nextInstruction = irLoad;
            }
            positionInstructions.add(irLoad);
            positionRes = irLoad.dest;
        }
        resultInstructions = primaryInstructions;
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = positionInstructions.getFirst();
        }
        resultInstructions.addAll(positionInstructions);
        IRLocate irLocate = new IRLocate(primaryRes, positionRes);
        this.expressionResult.put(astArraySubscriptingExpression, irLocate);
        return new LinkedList<>();
    }
}

package MentalIR;
import MentalAST.*;
import MentalAST.AstExpression.*;
import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRAstVisitor {
    public LinkedList<IRInstruction> labelLocations;
    public HashMap<AstBaseNode, IRData> expressionResult;
    public int lastLabel;
    public IRAstVisitor() {
        this.labelLocations = new LinkedList<>();
        this.expressionResult = new HashMap<>();
        this.lastLabel = 0;
    }
    public LinkedList<IRInstruction> visitBase(AstBaseNode node) {
        return new LinkedList<>();
    }
    public LinkedList<IRInstruction> visitAdditiveExpression(AstAdditiveExpression astAdditiveExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astAdditiveExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astAdditiveExpression.rightExpression.visit(this);

        IRData lhsRes = this.expressionResult.get(astAdditiveExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astAdditiveExpression.rightExpression);

        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).flat();
            if (lhsInstructions.getLast() != null) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).flat();
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
            IRAdd irAdd = new IRAdd();
            irAdd.lhs = lhsRes;
            irAdd.rhs = rhsRes;
            irAdd.res = new IRTemporary();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);
            this.expressionResult.put(astAdditiveExpression, irAdd.res);
        } else {
            IRSub irSub = new IRSub();
            irSub.lhs = lhsRes;
            irSub.rhs = rhsRes;
            irSub.res = new IRTemporary();
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
            IRLoad irLoad = new IRLoad();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        if (astUnaryAdditiveExpression.op == AstUnaryAdditiveExpression.ADD) {
            IRAdd irAdd = new IRAdd();
            irAdd.lhs = new IRWordLiteral(0);
            irAdd.rhs = childRes;
            irAdd.res = new IRTemporary();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);
            this.expressionResult.put(astUnaryAdditiveExpression, irAdd.res);
        } else {
            IRSub irSub = new IRSub();
            irSub.lhs = new IRWordLiteral(0);
            irSub.rhs = childRes;
            irSub.res = new IRTemporary();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irSub;
            }
            resultInstructions.add(irSub);
            this.expressionResult.put(astUnaryAdditiveExpression, irSub.res);
        }
        return resultInstructions;
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

    public LinkedList<IRInstruction> visitProgram(AstProgram astProgram) {
        for (AstBaseNode astBaseNode : astProgram.declarations) {

        }
        return new LinkedList<>();
    }
}

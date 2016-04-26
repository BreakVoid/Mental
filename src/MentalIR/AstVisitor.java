package MentalIR;
import MentalAST.*;
import MentalAST.AstDeclaration.AstDeclaration;
import MentalAST.AstExpression.*;
import MentalAST.AstStatement.*;
import MentalType.MentalClass;
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

    public LinkedList<IRInstruction> visitBitNotExpression(AstBitNotExpression astBitNotExpression) {
        LinkedList<IRInstruction> resultInstructions = astBitNotExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astBitNotExpression.childExpression);
        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        IRBitNot irBitNot = new IRBitNot(childRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = irBitNot;
        }
        this.expressionResult.put(astBitNotExpression, irBitNot.res);
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
        IRMul getRealPos = new IRMul(new IRWordLiteral(4), positionRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = getRealPos;
        }
        resultInstructions.add(getRealPos);
        IRLocate irLocate = new IRLocate(primaryRes, getRealPos.res);
        this.expressionResult.put(astArraySubscriptingExpression, irLocate);
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitBitAndExpression(AstBitAndExpression astBitAndExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astBitAndExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astBitAndExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astBitAndExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astBitAndExpression.rightExpression);
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
        thisInstruction = new IRBitAnd(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astBitAndExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitBitOrExpression(AstBitOrExpression astBitOrExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astBitOrExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astBitOrExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astBitOrExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astBitOrExpression.rightExpression);
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
        thisInstruction = new IRBitOr(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astBitOrExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitBitXorExpression(AstBitXorExpression astBitXorExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astBitXorExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astBitXorExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astBitXorExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astBitXorExpression.rightExpression);
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
        thisInstruction = new IRBitXor(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astBitXorExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitBitShiftExpression(AstBitShiftExpression astBitShiftExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astBitShiftExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astBitShiftExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astBitShiftExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astBitShiftExpression.rightExpression);
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
        if (astBitShiftExpression.op == AstBitShiftExpression.LEFT_SHIFT) {
            thisInstruction = new IRBitLsh(lhsRes, rhsRes, new IRTemporary());
        } else if (astBitShiftExpression.op == AstBitShiftExpression.RIGHT_SHIFT) {
            thisInstruction = new IRBitRsh(lhsRes, rhsRes, new IRTemporary());
        } else {
            throw new RuntimeException();
        }
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astBitShiftExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalAndExpression(AstLogicalAndExpression astLogicalAndExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astLogicalAndExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astLogicalAndExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astLogicalAndExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astLogicalAndExpression.rightExpression);
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
        thisInstruction = new IRBitAnd(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astLogicalAndExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalOrExpression(AstLogicalOrExpression astLogicalOrExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astLogicalOrExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astLogicalOrExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astLogicalOrExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astLogicalOrExpression.rightExpression);
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
        thisInstruction = new IRBitOr(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astLogicalOrExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalNotExpression(AstLogicalNotExpression astLogicalNotExpression) {
        LinkedList<IRInstruction> resultInstructions = astLogicalNotExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astLogicalNotExpression.childExpression);
        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        IRSub irLogicalNot = new IRSub(new IRWordLiteral(1), childRes, new IRTemporary());
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = irLogicalNot;
        }
        this.expressionResult.put(astLogicalNotExpression, irLogicalNot.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitPrefixExpression(AstPrefixExpression astPrefixExpression) {
        LinkedList<IRInstruction> resultInstructions = astPrefixExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astPrefixExpression.childExpression);
        IRData originChildRes = childRes;

        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }

        IRBinaryArithmetic thisInstruction;
        if (astPrefixExpression.op == AstPrefixExpression.PLUS_PLUS) {
            thisInstruction = new IRAdd(childRes, new IRWordLiteral(1), childRes);
        } else if (astPrefixExpression.op == AstPrefixExpression.MINUS_MINUS) {
            thisInstruction = new IRSub(childRes, new IRWordLiteral(1), childRes);
        } else {
            throw new RuntimeException();
        }

        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);

        if (originChildRes instanceof IRLocate) {
            IRStore irStore = new IRStore(childRes, originChildRes);
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irStore;
            }
            resultInstructions.add(irStore);
        }

        this.expressionResult.put(astPrefixExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitSuffixExpression(AstSuffixExpression astSuffixExpression) {
        LinkedList<IRInstruction> resultInstructions = astSuffixExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astSuffixExpression.childExpression);
        IRData originChildRes = childRes;
        IRData exprRes = new IRTemporary();

        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }

        //-------------------------------------------------------

        IRStore irStore;
        irStore = new IRStore(childRes, exprRes);
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = irStore;
        }
        resultInstructions.add(irStore);
        this.expressionResult.put(astSuffixExpression, exprRes);

        //-------------------------------------------------------

        IRBinaryArithmetic thisInstruction;
        if (astSuffixExpression.op == AstSuffixExpression.PLUS_PLUS) {
            thisInstruction = new IRAdd(childRes, new IRWordLiteral(1), childRes);
        } else if (astSuffixExpression.op == AstSuffixExpression.MINUS_MINUS) {
            thisInstruction = new IRSub(childRes, new IRWordLiteral(1), childRes);
        } else {
            throw new RuntimeException();
        }
        if (resultInstructions.getLast() != null) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);

        if (originChildRes instanceof IRLocate) {
            irStore = new IRStore(childRes, originChildRes);
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = irStore;
            }
            resultInstructions.add(irStore);
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitMemberAccessExpression(AstMemberAccessExpression astMemberAccessExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> primaryInstructions = astMemberAccessExpression.primaryExpression.visit(this);
        LinkedList<IRInstruction> memberInstructions;
        if (astMemberAccessExpression.memberExpression == null) {
            memberInstructions = new LinkedList<>();
        } else {
            memberInstructions = astMemberAccessExpression.memberExpression.visit(this);
        }

        IRData primaryRes = this.expressionResult.get(astMemberAccessExpression.primaryExpression);
        if (primaryRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) primaryRes).load();
            if (primaryInstructions.getLast() != null) {
                primaryInstructions.getLast().nextInstruction = irLoad;
            }
            primaryInstructions.add(irLoad);
            primaryRes = irLoad.dest;
        }

        if (astMemberAccessExpression.memberExpression == null) {
            if (astMemberAccessExpression.primaryExpression.returnType instanceof MentalClass) {
                MentalClass classDetail = (MentalClass) astMemberAccessExpression.primaryExpression.returnType;
                int shift = classDetail.classComponents.get(astMemberAccessExpression.memberName).memberID;
                int realShift = 4 * shift;
                IRLocate expressionRes = new IRLocate(primaryRes, new IRWordLiteral(realShift));
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
                return primaryInstructions;
            } else {
                throw new RuntimeException();
            }
        } else {
            resultInstructions = primaryInstructions;
            if (resultInstructions.getLast() != null) {
                resultInstructions.getLast().nextInstruction = memberInstructions.getFirst();
            }
            resultInstructions.addAll(memberInstructions);
            if (astMemberAccessExpression.memberExpression instanceof AstCallOrd) {
                // call string.ord()
                // get position
                IRData callParameter = this.expressionResult.get(astMemberAccessExpression.memberExpression);
                // load data
                IRLoad irLoad = new IRLoad(new IRLocate(primaryRes, callParameter), 1);
                // set result
                IRData expressionRes = irLoad.dest;
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
                if (resultInstructions.getLast() != null) {
                    resultInstructions.getLast().nextInstruction = irLoad;
                }
                resultInstructions.add(irLoad);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallLength) {
                // call string.length()
                // locate the data of length
                // set result
                IRData expressionRes = new IRLocate(primaryRes, new IRWordLiteral(-4));
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallSize) {
                // call array.size()
                // locate the data of length
                // set result
                IRData expressionRes = new IRLocate(primaryRes, new IRWordLiteral(-4));
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
            }
        }
        return resultInstructions;
    }
    
    public LinkedList<IRInstruction> visitCallOrd(AstCallOrd astCallOrd) {
        LinkedList<IRInstruction> resultInstruction = astCallOrd.childExpression.visit(this);
        this.expressionResult.put(astCallOrd, this.expressionResult.get(astCallOrd.childExpression));
        return resultInstruction;
    }

    public LinkedList<IRInstruction> visitCallLength(AstCallLength astCallLength) {
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitCreationExpression(AstCreationExpression astCreationExpression) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitEqualityExpression(AstEqualityExpression astEqualityExpression) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitFunctionCall(AstFunctionCall astFunctionCall) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitRelationExpression(AstRelationExpression astRelationExpression) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitSubgroupExpression(AstSubgroupExpression astSubgroupExpression) {
        LinkedList<IRInstruction> resultInstructions = astSubgroupExpression.childExpression.visit(this);
        this.expressionResult.put(astSubgroupExpression, this.expressionResult.get(astSubgroupExpression.childExpression));
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCompoundStatement(AstCompoundStatement astCompoundStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitExpressionStatement(AstExpressionStatement astExpressionStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitForStatement(AstForStatement astForStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitIfStatement(AstIfStatement astIfStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitJumpStatement(AstJumpStatement astJumpStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitWhileStatment(AstWhileStatement astWhileStatement) {
        // TODO
        return null;
    }

    public LinkedList<IRInstruction> visitExpressionList(AstExpressionList astExpressionList) {
        // TODO
        return null;
    }
}

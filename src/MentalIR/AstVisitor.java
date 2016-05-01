package MentalIR;

import MentalAST.AstBaseNode;
import MentalAST.AstDeclaration.AstFunctionDefinition;
import MentalAST.AstDeclaration.AstSingleVariableDeclaration;
import MentalAST.AstDeclaration.AstVariableDeclaration;
import MentalAST.AstExpression.AstAdditiveExpression;
import MentalAST.AstExpression.AstArraySubscriptingExpression;
import MentalAST.AstExpression.AstAssignExpression;
import MentalAST.AstExpression.AstBitAndExpression;
import MentalAST.AstExpression.AstBitNotExpression;
import MentalAST.AstExpression.AstBitOrExpression;
import MentalAST.AstExpression.AstBitShiftExpression;
import MentalAST.AstExpression.AstBitXorExpression;
import MentalAST.AstExpression.AstBoolConstant;
import MentalAST.AstExpression.AstCallGetInt;
import MentalAST.AstExpression.AstCallGetString;
import MentalAST.AstExpression.AstCallLength;
import MentalAST.AstExpression.AstCallOrd;
import MentalAST.AstExpression.AstCallParseInt;
import MentalAST.AstExpression.AstCallPrint;
import MentalAST.AstExpression.AstCallPrintln;
import MentalAST.AstExpression.AstCallSize;
import MentalAST.AstExpression.AstCallSubString;
import MentalAST.AstExpression.AstCallToString;
import MentalAST.AstExpression.AstCreationExpression;
import MentalAST.AstExpression.AstEqualityExpression;
import MentalAST.AstExpression.AstExpression;
import MentalAST.AstExpression.AstFunctionCall;
import MentalAST.AstExpression.AstIdentifier;
import MentalAST.AstExpression.AstIntLiteral;
import MentalAST.AstExpression.AstLogicalAndExpression;
import MentalAST.AstExpression.AstLogicalNotExpression;
import MentalAST.AstExpression.AstLogicalOrExpression;
import MentalAST.AstExpression.AstMemberAccessExpression;
import MentalAST.AstExpression.AstMulDivExpression;
import MentalAST.AstExpression.AstNullConstant;
import MentalAST.AstExpression.AstPrefixExpression;
import MentalAST.AstExpression.AstRelationExpression;
import MentalAST.AstExpression.AstStringLiteral;
import MentalAST.AstExpression.AstSubgroupExpression;
import MentalAST.AstExpression.AstSuffixExpression;
import MentalAST.AstExpression.AstUnaryAdditiveExpression;
import MentalAST.AstExpressionList;
import MentalAST.AstProgram;
import MentalAST.AstStatement.AstCompoundStatement;
import MentalAST.AstStatement.AstExpressionStatement;
import MentalAST.AstStatement.AstForStatement;
import MentalAST.AstStatement.AstIfStatement;
import MentalAST.AstStatement.AstJumpStatement;
import MentalAST.AstStatement.AstVarStatement;
import MentalAST.AstStatement.AstWhileStatement;
import MentalType.MentalClass;
import MentalType.MentalInt;
import MentalType.MentalString;
import MentalType.MentalVoid;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * Created by Songyu on 16/4/19.
 */
public class AstVisitor {
    public HashMap<AstBaseNode, IRData> expressionResult;

    public LinkedList<IRInstruction> functionInstructionLists;
    public LinkedList<Integer> functionStackSize;

    public LinkedList<IRInstruction> globalVariableInitialize;

    public HashMap<String, IRStringLiteral> stringMap;
    public LinkedList<IRStringLiteral> stringLiterals;
    public IRStringLiteral literalNewline;

    public HashMap<Integer, IRVariable> variableMap;
    public HashMap<Integer, IRLabelGlobalData> globalVariableMap;
    public LinkedList<IRVariable> globalVariables;

    public IRLabel endFunction;
    public IRLabel continueLoop;
    public IRLabel endLoop;

    public AstVisitor() {
        this.expressionResult = new HashMap<>();

        this.functionInstructionLists = new LinkedList<>();
        this.functionStackSize = new LinkedList<>();
        this.globalVariableInitialize = new LinkedList<>();

        this.stringLiterals = new LinkedList<>();
        this.stringMap = new HashMap<>();
        this.literalNewline = new IRStringLiteral("\"\\n\"");
        this.stringMap.put("\"\\n\"", this.literalNewline);
        this.stringLiterals.add(this.literalNewline);

        this.globalVariableMap = new HashMap<>();
        this.variableMap = new HashMap<>();
        this.globalVariables = new LinkedList<>();

        this.endFunction = null;
        this.endLoop = null;
        this.continueLoop = null;
    }

    public LinkedList<IRInstruction> visitBase(AstBaseNode node) {
        // would never be called.
        return null;
    }

    public LinkedList<IRInstruction> visitProgram(AstProgram astProgram) {
        for (AstBaseNode astDeclaration : astProgram.declarations) {
            if (astDeclaration instanceof AstVariableDeclaration) {
                LinkedList<IRInstruction> variableInstructions = astDeclaration.visit(this);
                if (variableInstructions.size() > 0) {
                    this.globalVariableInitialize.add(variableInstructions.getFirst());
                }
            } else if (astDeclaration instanceof AstFunctionDefinition) {
                LinkedList<IRInstruction> functionInstructions = astDeclaration.visit(this);
                if (functionInstructions.size() > 0) {
                    this.functionInstructionLists.add(functionInstructions.getFirst());
                    this.functionStackSize.add(((AstFunctionDefinition) astDeclaration).lastVariableID - ((AstFunctionDefinition) astDeclaration).firstVariableID + 1);
                }
            }
        }
        return null;
    }

    public LinkedList<IRInstruction> visitIdentifier(AstIdentifier astIdentifier) {
        IRVariable irVariable;
        irVariable = this.variableMap.get(astIdentifier.variable.globalID);
        if (irVariable == null) {
            irVariable = new IRVariable();
            irVariable.variableID = astIdentifier.variable.globalID;
            irVariable.stackShift = astIdentifier.variable.localID;
            irVariable.globalDataLabel = this.globalVariableMap.get(irVariable.variableID);
            this.variableMap.put(astIdentifier.variable.globalID, irVariable);
        }
        this.expressionResult.put(astIdentifier, irVariable);
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
        IRStringLiteral irStringLiteral = null;
        if (this.stringMap.get(astStringLiteral.literalContext) == null) {
            irStringLiteral = new IRStringLiteral(astStringLiteral.literalContext);
            this.stringLiterals.add(irStringLiteral);
            this.stringMap.put(astStringLiteral.literalContext, irStringLiteral);
        } else {
            irStringLiteral = this.stringMap.get(astStringLiteral.literalContext);
        }
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
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = rhsInstructions;
        if (resultInstructions.size() > 0) {
            if (lhsInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = lhsInstructions.getFirst();
            }
        }
        resultInstructions.addAll(lhsInstructions);
        IRStore irStore = new IRStore(rhsRes, lhsRes);
        if (resultInstructions.size() > 0) {
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
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = lhsInstructions;
        if (resultInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions.addAll(rhsInstructions);
        if (astAdditiveExpression.returnType instanceof MentalString) {
            IRCall irCall = new IRCall(new IRLabelFunction("____built_in_string_join"));
            irCall.parameters.add(lhsRes);
            irCall.parameters.add(rhsRes);
        } else if (astAdditiveExpression.returnType instanceof MentalInt) {
            if (astAdditiveExpression.op == AstAdditiveExpression.ADD) {
                IRAdd irAdd = new IRAdd(lhsRes, rhsRes, new IRTemporary());
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irAdd;
                }
                resultInstructions.add(irAdd);
                this.expressionResult.put(astAdditiveExpression, irAdd.res);
            } else {
                IRSub irSub = new IRSub(lhsRes, rhsRes, new IRTemporary());
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irSub;
                }
                resultInstructions.add(irSub);
                this.expressionResult.put(astAdditiveExpression, irSub.res);
            }
        } else {
            throw new RuntimeException();
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitUnaryAdditiveExpression(AstUnaryAdditiveExpression astUnaryAdditiveExpression) {
        LinkedList<IRInstruction> resultInstructions = astUnaryAdditiveExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astUnaryAdditiveExpression.childExpression);
        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        if (astUnaryAdditiveExpression.op == AstUnaryAdditiveExpression.ADD) {
            IRAdd irAdd = new IRAdd(new IRWordLiteral(0), childRes, new IRTemporary());
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);
            this.expressionResult.put(astUnaryAdditiveExpression, irAdd.res);
        } else {
            IRSub irSub = new IRSub(new IRWordLiteral(0), childRes, new IRTemporary());
            if (resultInstructions.size() > 0) {
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
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        IRBitNot irBitNot = new IRBitNot(childRes, new IRTemporary());
        if (resultInstructions.size() > 0) {
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
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
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
        if (resultInstructions.size() > 0) {
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
            if (primaryInstructions.size() > 0) {
                primaryInstructions.getLast().nextInstruction = irLoad;
            }
            primaryInstructions.add(irLoad);
            primaryRes = irLoad.dest;
        }
        if (positionRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) positionRes).load();
            if (positionInstructions.size() > 0) {
                positionInstructions.getLast().nextInstruction = irLoad;
            }
            positionInstructions.add(irLoad);
            positionRes = irLoad.dest;
        }
        resultInstructions = primaryInstructions;
        if (resultInstructions.size() > 0) {
            if (positionInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = positionInstructions.getFirst();
            }
        }
        resultInstructions.addAll(positionInstructions);

        IRMul getRealPos = new IRMul(positionRes, new IRWordLiteral(4), new IRTemporary());
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = getRealPos;
        }
        resultInstructions.add(getRealPos);
        IRLocate irLocate = new IRLocate(primaryRes, getRealPos.res);
        this.expressionResult.put(astArraySubscriptingExpression, irLocate);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitBitAndExpression(AstBitAndExpression astBitAndExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astBitAndExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astBitAndExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astBitAndExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astBitAndExpression.rightExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions = lhsInstructions;
        resultInstructions.addAll(rhsInstructions);
        IRBinaryArithmetic thisInstruction;
        thisInstruction = new IRBitAnd(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.size() > 0) {
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
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions = lhsInstructions;
        resultInstructions.addAll(rhsInstructions);
        IRBinaryArithmetic thisInstruction;
        thisInstruction = new IRBitOr(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.size() > 0) {
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
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions = lhsInstructions;
        resultInstructions.addAll(rhsInstructions);
        IRBinaryArithmetic thisInstruction;
        thisInstruction = new IRBitXor(lhsRes, rhsRes, new IRTemporary());
        if (resultInstructions.size() > 0) {
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
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (lhsInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
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
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        this.expressionResult.put(astBitShiftExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalAndExpression(AstLogicalAndExpression astLogicalAndExpression) {
        LinkedList<IRInstruction> resultInstructions;
        IRLabelShortPathEvaluate irLabelShortPathEvaluate = new IRLabelShortPathEvaluate();
        IRNullOperation irNullOperation = new IRNullOperation();
        irNullOperation.label = irLabelShortPathEvaluate;
        // get left expression result and instructions.
        LinkedList<IRInstruction> lhsInstructions = astLogicalAndExpression.leftExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astLogicalAndExpression.leftExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        // set the read time of lhsRes as 3 if it is a temporary.
        if (lhsRes instanceof IRTemporary) {
            ((IRTemporary) lhsRes).counter = 3;
        }

        resultInstructions = lhsInstructions;
        // if lhsRes == 0 then the right expression would not be evaluated.
        IRBranchEqualZero irBranchEqualZero = new IRBranchEqualZero(lhsRes, irLabelShortPathEvaluate);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irBranchEqualZero;
        }
        resultInstructions.add(irBranchEqualZero);

        LinkedList<IRInstruction> rhsInstructions = astLogicalAndExpression.rightExpression.visit(this);
        IRData rhsRes = this.expressionResult.get(astLogicalAndExpression.rightExpression);
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }

        if (rhsInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
        }
        resultInstructions.addAll(rhsInstructions);

        IRBinaryArithmetic thisInstruction = new IRBitAnd(lhsRes, rhsRes, lhsRes);
        resultInstructions.getLast().nextInstruction = thisInstruction;
        resultInstructions.add(thisInstruction);
        resultInstructions.getLast().nextInstruction = irNullOperation;
        resultInstructions.add(irNullOperation);

        this.expressionResult.put(astLogicalAndExpression, thisInstruction.res);

        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalOrExpression(AstLogicalOrExpression astLogicalOrExpression) {
        LinkedList<IRInstruction> resultInstructions;
        // set label for short evaluate.
        IRLabelShortPathEvaluate irLabelShortPathEvaluate = new IRLabelShortPathEvaluate();
        IRNullOperation irNullOperation = new IRNullOperation();
        irNullOperation.label = irLabelShortPathEvaluate;

        LinkedList<IRInstruction> lhsInstructions = astLogicalOrExpression.leftExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astLogicalOrExpression.leftExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (lhsRes instanceof IRTemporary) {
            ((IRTemporary) lhsRes).counter = 3;
        }
        resultInstructions = lhsInstructions;
        IRBranchNotEqualZero irBranchNotEqualZero = new IRBranchNotEqualZero(lhsRes, irLabelShortPathEvaluate);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irBranchNotEqualZero;
        }
        resultInstructions.add(irBranchNotEqualZero);

        LinkedList<IRInstruction> rhsInstructions = astLogicalOrExpression.rightExpression.visit(this);
        IRData rhsRes = this.expressionResult.get(astLogicalOrExpression.rightExpression);
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        if (rhsInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
        }
        resultInstructions.addAll(rhsInstructions);

        IRBinaryArithmetic thisInstruction;
        thisInstruction = new IRBitOr(lhsRes, rhsRes, lhsRes);

        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);
        resultInstructions.getLast().nextInstruction = irNullOperation;
        resultInstructions.add(irNullOperation);

        this.expressionResult.put(astLogicalOrExpression, thisInstruction.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitLogicalNotExpression(AstLogicalNotExpression astLogicalNotExpression) {
        LinkedList<IRInstruction> resultInstructions = astLogicalNotExpression.childExpression.visit(this);
        IRData childRes = this.expressionResult.get(astLogicalNotExpression.childExpression);
        if (childRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) childRes).load();
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }
        IRSub irLogicalNot = new IRSub(new IRWordLiteral(1), childRes, new IRTemporary());
        if (resultInstructions.size() > 0) {
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
            if (resultInstructions.size() > 0) {
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

        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);

        if (originChildRes instanceof IRLocate) {
            IRStore irStore = new IRStore(childRes, originChildRes);
            if (resultInstructions.size() > 0) {
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
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            childRes = irLoad.dest;
        }

        //-------------------------------------------------------

        IRStore irStore;
        irStore = new IRStore(childRes, exprRes);
        if (resultInstructions.size() > 0) {
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
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = thisInstruction;
        }
        resultInstructions.add(thisInstruction);

        if (originChildRes instanceof IRLocate) {
            irStore = new IRStore(childRes, originChildRes);
            if (resultInstructions.size() > 0) {
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
            if (primaryInstructions.size() > 0) {
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
            if (resultInstructions.size() > 0) {
                if (memberInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = memberInstructions.getFirst();
                }
            }
            resultInstructions.addAll(memberInstructions);
            if (astMemberAccessExpression.memberExpression instanceof AstCallOrd) {
                // call string.ord(pos)
                // get position
                if (primaryRes instanceof IRStringLiteral) {
                    primaryRes = ((IRStringLiteral) primaryRes).label;
                }
                IRData callParameter = this.expressionResult.get(astMemberAccessExpression.memberExpression);
                if (callParameter instanceof IRLocate) {
                    IRLoad irLoad = ((IRLocate) callParameter).load();
                    if (resultInstructions.size() > 1) {
                        resultInstructions.getLast().nextInstruction = irLoad;
                    }
                    resultInstructions.add(irLoad);
                    callParameter = irLoad.dest;
                }

                // load data
                IRLoad irLoad = new IRLoad(new IRLocate(primaryRes, callParameter), 1);
                // set result
                IRData expressionRes = irLoad.dest;
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irLoad;
                }
                resultInstructions.add(irLoad);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallLength) {
                // call string.length()
                // locate the data of length
                // set result
                if (primaryRes instanceof IRStringLiteral) {
                    primaryRes = ((IRStringLiteral) primaryRes).label;
                }
                IRData expressionRes = new IRLocate(primaryRes, new IRWordLiteral(-4));
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallSize) {
                // call array.size()
                // locate the data of length
                // set result
                IRData expressionRes = new IRLocate(primaryRes, new IRWordLiteral(-4));
                this.expressionResult.put(astMemberAccessExpression, expressionRes);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallSubString){
                if (primaryRes instanceof IRStringLiteral) {
                    primaryRes = ((IRStringLiteral) primaryRes).label;
                }
                // call string.substring(left, right)
                AstCallSubString astCallSubString = (AstCallSubString) astMemberAccessExpression.memberExpression;
                // get left and right boundary of the substring
                LinkedList<IRInstruction> leftBoundInstructions = astCallSubString.leftExpression.visit(this);
                LinkedList<IRInstruction> rightBoundInstructions = astCallSubString.rightExpression.visit(this);
                IRData leftBoundRes = this.expressionResult.get(astCallSubString.leftExpression);
                IRData rightBoundRes = this.expressionResult.get(astCallSubString.rightExpression);
                if (leftBoundRes instanceof IRLocate) {
                    IRLoad irLoad = ((IRLocate) leftBoundRes).load();
                    if (leftBoundInstructions.size() > 0) {
                        leftBoundInstructions.getLast().nextInstruction = irLoad;
                    }
                    leftBoundInstructions.add(irLoad);
                    leftBoundRes = irLoad.dest;
                }
                if (rightBoundRes instanceof  IRLocate) {
                    IRLoad irLoad = ((IRLocate) rightBoundRes).load();
                    if (rightBoundInstructions.size() > 0) {
                        rightBoundInstructions.getLast().nextInstruction = irLoad;
                    }
                    rightBoundInstructions.add(irLoad);
                    rightBoundRes = irLoad.dest;
                }
                if (resultInstructions.size() > 0) {
                    if (leftBoundInstructions.size() > 0) {
                        resultInstructions.getLast().nextInstruction = leftBoundInstructions.getFirst();
                    }
                }
                resultInstructions.addAll(leftBoundInstructions);
                if (resultInstructions.size() > 0) {
                    if (rightBoundInstructions.size() > 0) {
                        resultInstructions.getLast().nextInstruction = rightBoundInstructions.getFirst();
                    }
                }
                resultInstructions.addAll(rightBoundInstructions);
                IRCall irCall = new IRCall(new IRLabelFunction("____built_in_substring"));
                irCall.parameters.add(primaryRes);
                irCall.parameters.add(leftBoundRes);
                irCall.parameters.add(rightBoundRes);
                this.expressionResult.put(astMemberAccessExpression, irCall.res);
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irCall;
                }
                resultInstructions.add(irCall);
            } else if (astMemberAccessExpression.memberExpression instanceof AstCallParseInt) {
                // TODO
                // call string.parseInt();
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
        // do nothing.
        return new LinkedList<>();
    }

    public LinkedList<IRInstruction> visitCreationExpression(AstCreationExpression astCreationExpression) {
        LinkedList<IRInstruction> resultInstructions;
        if (astCreationExpression.resultDim - astCreationExpression.determinedDim > 1) {
            throw new RuntimeException("no grammar sugar.");
        }
        if (astCreationExpression.expressionList != null && astCreationExpression.expressionList.size() == 1) {
            // new a array.
            // allocate 4 * (1 + size) bytes memory to store data.
            // get the size of array.
            LinkedList<IRInstruction> sizeInstructions = astCreationExpression.expressionList.get(0).visit(this);
            IRData sizeExprRes = this.expressionResult.get(astCreationExpression.expressionList.get(0));

            if (sizeExprRes instanceof IRLocate) {
                IRLoad irLoad = ((IRLocate) sizeExprRes).load();
                if (sizeInstructions.size() > 0) {
                    sizeInstructions.getLast().nextInstruction = irLoad;
                }
                sizeInstructions.add(irLoad);
                sizeExprRes = irLoad.dest;
            }
            if (sizeExprRes instanceof IRTemporary) {
                ((IRTemporary) sizeExprRes).counter = 2;
            }
            resultInstructions = sizeInstructions;
            // size + 1
            IRWordLiteral one = new IRWordLiteral(1);
            IRAdd irAdd = new IRAdd(sizeExprRes, one, new IRTemporary());
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irAdd;
            }
            resultInstructions.add(irAdd);

            // 4 * (size + 1)
            IRWordLiteral eachSize = new IRWordLiteral(4);
            IRMul getRealSize = new IRMul(irAdd.res, eachSize, new IRTemporary());
            resultInstructions.getLast().nextInstruction = getRealSize;
            resultInstructions.add(getRealSize);

            // add instruction to get heap memory
            IRMemoryAllocate irMemoryAllocate = new IRMemoryAllocate(getRealSize.res);
            ((IRTemporary) irMemoryAllocate.res).counter = 2;
            resultInstructions.getLast().nextInstruction = irMemoryAllocate;
            resultInstructions.add(irMemoryAllocate);

            //store the size of the array to the memory.
            IRStore irStore = new IRStore(sizeExprRes, new IRLocate(irMemoryAllocate.res, new IRWordLiteral(0)));
            resultInstructions.getLast().nextInstruction = irStore;
            resultInstructions.add(irStore);

            //calculate the address of the head of the array as the result of this expression.
            IRAdd irAddressAdd = new IRAdd(irMemoryAllocate.res, new IRWordLiteral(4), new IRTemporary());
            this.expressionResult.put(astCreationExpression, irAddressAdd.res);
            resultInstructions.getLast().nextInstruction = irAddressAdd;
            resultInstructions.add(irAddressAdd);
        } else if (astCreationExpression.resultDim == 0) {
            // new a class.
            resultInstructions = new LinkedList<>();
            // get size of class by the number of class members.
            IRWordLiteral amount = new IRWordLiteral(((MentalClass) astCreationExpression.returnType).classSize * 4);
            // add instruction to get heap memory.
            IRMemoryAllocate irMemoryAllocate = new IRMemoryAllocate(amount);
            this.expressionResult.put(astCreationExpression, irMemoryAllocate.res);
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irMemoryAllocate;
            }
            resultInstructions.add(irMemoryAllocate);
        } else {
            throw new RuntimeException();
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitEqualityExpression(AstEqualityExpression astEqualityExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astEqualityExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astEqualityExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astEqualityExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astEqualityExpression.rightExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = lhsInstructions;
        if (resultInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions.addAll(rhsInstructions);
        if (astEqualityExpression.leftExpression.returnType instanceof MentalString) {
            IRCall irCall;
            if (astEqualityExpression.op == AstEqualityExpression.EQUAL) {
                irCall = new IRCall(new IRLabelFunction("____built_in_string_equal"));
                irCall.parameters.add(lhsRes);
                irCall.parameters.add(rhsRes);
            } else if (astEqualityExpression.op == AstEqualityExpression.INEQUAL) {
                irCall = new IRCall(new IRLabelFunction(("____built_in_string_inequal")));
                irCall.parameters.add(lhsRes);
                irCall.parameters.add(rhsRes);
            } else {
                throw new RuntimeException();
            }
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irCall;
            }
            resultInstructions.add(irCall);
            this.expressionResult.put(astEqualityExpression, irCall.res);
        } else {
            IRCompare irCompare;
            if (astEqualityExpression.op == AstEqualityExpression.EQUAL) {
                irCompare = new IRCompareEqual(lhsRes, rhsRes);
            } else if (astEqualityExpression.op == AstEqualityExpression.INEQUAL) {
                irCompare = new IRCompareNotEqual(lhsRes, rhsRes);
            } else {
                throw new RuntimeException();
            }
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irCompare;
            }
            resultInstructions.add(irCompare);
            this.expressionResult.put(astEqualityExpression, irCompare.res);
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitFunctionCall(AstFunctionCall astFunctionCall) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRInstruction lastInstructions = null;
        IRCall irCall = new IRCall(new IRLabelFunction(astFunctionCall.functionName));
        if (astFunctionCall.returnType instanceof MentalVoid) {
            irCall.res = null;
        }
        if (astFunctionCall.parameters.expressions != null) {
            for (AstExpression astExpression : astFunctionCall.parameters.expressions) {
                LinkedList<IRInstruction> expressionInstructions = astExpression.visit(this);
                IRData expressionRes = this.expressionResult.get(astExpression);
                if (expressionRes instanceof IRLocate) {
                    IRLoad irLoad = ((IRLocate) expressionRes).load();
                    if (expressionInstructions.size() > 0) {
                        expressionInstructions.getLast().nextInstruction = irLoad;
                    }
                    expressionInstructions.add(irLoad);
                    expressionRes = irLoad.dest;
                }
                irCall.parameters.add(expressionRes);
                if (lastInstructions != null) {
                    if (expressionInstructions.size() > 0) {
                        lastInstructions.nextInstruction = expressionInstructions.getFirst();
                    }
                }
                resultInstructions.addAll(expressionInstructions);
                if (resultInstructions.size() > 0) {
                    lastInstructions = resultInstructions.getLast();
                }
            }
        }
        this.expressionResult.put(astFunctionCall, irCall.res);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitRelationExpression(AstRelationExpression astRelationExpression) {
        LinkedList<IRInstruction> resultInstructions;
        LinkedList<IRInstruction> lhsInstructions = astRelationExpression.leftExpression.visit(this);
        LinkedList<IRInstruction> rhsInstructions = astRelationExpression.rightExpression.visit(this);
        IRData lhsRes = this.expressionResult.get(astRelationExpression.leftExpression);
        IRData rhsRes = this.expressionResult.get(astRelationExpression.rightExpression);
        if (lhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) lhsRes).load();
            if (lhsInstructions.size() > 0) {
                lhsInstructions.getLast().nextInstruction = irLoad;
            }
            lhsInstructions.add(irLoad);
            lhsRes = irLoad.dest;
        }
        if (rhsRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) rhsRes).load();
            if (rhsInstructions.size() > 0) {
                rhsInstructions.getLast().nextInstruction = irLoad;
            }
            rhsInstructions.add(irLoad);
            rhsRes = irLoad.dest;
        }
        resultInstructions = lhsInstructions;
        if (resultInstructions.size() > 0) {
            if (rhsInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = rhsInstructions.getFirst();
            }
        }
        resultInstructions.addAll(rhsInstructions);
        if (astRelationExpression.leftExpression.returnType instanceof MentalString) {
            IRCall irCall;
            if (astRelationExpression.op == AstRelationExpression.LESS) {
                irCall = new IRCall(new IRLabelFunction("____built_in_string_less"));
                irCall.parameters.add(lhsRes);
                irCall.parameters.add(rhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.LESS_EQ) {
                irCall = new IRCall(new IRLabelFunction(("____built_in_string_less_equal")));
                irCall.parameters.add(lhsRes);
                irCall.parameters.add(rhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.GREATER) {
                irCall = new IRCall(new IRLabelFunction(("____built_in_string_less")));
                irCall.parameters.add(rhsRes);
                irCall.parameters.add(lhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.GREATER_EQ) {
                irCall = new IRCall(new IRLabelFunction(("____built_in_string_less_equal")));
                irCall.parameters.add(rhsRes);
                irCall.parameters.add(lhsRes);
            } else {
                throw new RuntimeException();
            }
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irCall;
            }
            resultInstructions.add(irCall);
            this.expressionResult.put(astRelationExpression, irCall.res);
        } else {
            IRCompare irCompare;
            if (astRelationExpression.op == AstRelationExpression.LESS) {
                irCompare = new IRCompareLess(lhsRes, rhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.LESS_EQ) {
                irCompare = new IRCompareLessEqual(lhsRes, rhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.GREATER) {
                irCompare = new IRCompareGreater(lhsRes, rhsRes);
            } else if (astRelationExpression.op == AstRelationExpression.GREATER_EQ) {
                irCompare = new IRCompareGreaterEqual(lhsRes, rhsRes);
            } else {
                throw new RuntimeException();
            }
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irCompare;
            }
            resultInstructions.add(irCompare);
            this.expressionResult.put(astRelationExpression, irCompare.res);
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitSubgroupExpression(AstSubgroupExpression astSubgroupExpression) {
        LinkedList<IRInstruction> resultInstructions = astSubgroupExpression.childExpression.visit(this);
        this.expressionResult.put(astSubgroupExpression, this.expressionResult.get(astSubgroupExpression.childExpression));
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCompoundStatement(AstCompoundStatement astCompoundStatement) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRInstruction lastInstruction = null;
        for (AstBaseNode astBaseNode : astCompoundStatement.statements) {
            LinkedList<IRInstruction> instructions = astBaseNode.visit(this);
            if (instructions.size() > 0) {
                if (lastInstruction != null) {
                    lastInstruction.nextInstruction = instructions.getFirst();
                }
                resultInstructions.addAll(instructions);
                if (resultInstructions.size() > 0) {
                    lastInstruction = resultInstructions.getLast();
                }
            }
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitExpressionStatement(AstExpressionStatement astExpressionStatement) {
        return astExpressionStatement.expression.visit(this);
    }

    public LinkedList<IRInstruction> visitForStatement(AstForStatement astForStatement) {
        IRLabel endLoopBackup = this.endLoop;
        IRLabel continueLoopBackup = this.continueLoop;
        //--------------------------------------------------------------
        IRLabel thisForCondition = new IRLabelBeginLoop();
        this.endLoop = new IRLabelEndLoop();
        this.continueLoop = new IRLabelContinueLoop();

        // a null operation for the end of loop.
        IRNullOperation endLoopInstructions = new IRNullOperation();
        endLoopInstructions.label = endLoop;

        // initial expression of a `for` statement.
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        if (astForStatement.start != null) {
            LinkedList<IRInstruction> initializeExpressionInstructions = astForStatement.start.visit(this);
            resultInstructions.addAll(initializeExpressionInstructions);
        }

        // condition expression and loop body for a `for` statement;
        LinkedList<IRInstruction> loopInstructions = new LinkedList<>();

        if (astForStatement.cond instanceof AstBoolConstant) {
            if (!((AstBoolConstant) astForStatement.cond).boolConstant) {
                IRJumpLabel irJumpLabel = new IRJumpLabel(this.endLoop);
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irJumpLabel;
                }
                resultInstructions.add(irJumpLabel);
            }
        } else {
            LinkedList<IRInstruction> conditionExpressionInstructions = astForStatement.cond.visit(this);
            IRData conditionRes = this.expressionResult.get(astForStatement.cond);
            if (conditionRes instanceof IRLocate) {
                IRLoad irLoad = ((IRLocate) conditionRes).load();
                if (conditionExpressionInstructions.size() > 0) {
                    conditionExpressionInstructions.getLast().nextInstruction = irLoad;
                }
                conditionExpressionInstructions.add(irLoad);
                conditionRes = irLoad.dest;
            }
            loopInstructions.addAll(conditionExpressionInstructions);
            IRBranchEqualZero irBranchEqualZero = new IRBranchEqualZero(conditionRes, this.endLoop);
            if (loopInstructions.size() > 0) {
                loopInstructions.getLast().nextInstruction = irBranchEqualZero;
            }
            loopInstructions.add(irBranchEqualZero);
        }
        loopInstructions.addAll(astForStatement.loopBody.visit(this));
        if (loopInstructions.size() > 0) {
            loopInstructions.getFirst().label = thisForCondition;
        }

        resultInstructions.addAll(loopInstructions);

        // step expression for a `for` statement;
        if (astForStatement.loop != null) {
            LinkedList<IRInstruction> stepInstructions = astForStatement.loop.visit(this);
            IRJumpLabel irJumpLabel = new IRJumpLabel(thisForCondition);
            if (stepInstructions.size() > 0) {
                stepInstructions.getLast().nextInstruction = irJumpLabel;
            }
            stepInstructions.add(irJumpLabel);
            stepInstructions.getFirst().label = this.continueLoop;

            if (resultInstructions.size() > 0) {
                if (stepInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = stepInstructions.getFirst();
                }
            }
            resultInstructions.addAll(stepInstructions);
        } else {
            IRJumpLabel irJumpLabel = new IRJumpLabel(thisForCondition);
            irJumpLabel.label = this.continueLoop;
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irJumpLabel;
            }
            resultInstructions.add(irJumpLabel);
        }

        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = endLoopInstructions;
        }
        resultInstructions.add(endLoopInstructions);
        //--------------------------------------------------------------
        this.endLoop = endLoopBackup;
        this.continueLoop = continueLoopBackup;
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitIfStatement(AstIfStatement astIfStatement) {
        LinkedList<IRInstruction> resultInstructions;
        IRLabelElse irLabelElse = new IRLabelElse();
        IRLabelEndIf irLabelEndIf = new IRLabelEndIf();
        IRNullOperation irEndIfInstruction = new IRNullOperation();
        irEndIfInstruction.label = irLabelEndIf;

        // condition expression instructions.
        LinkedList<IRInstruction> conditionInstructions = astIfStatement.condition.visit(this);
        IRData conditionRes = this.expressionResult.get(astIfStatement.condition);
        if (conditionRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) conditionRes).load();
            if (conditionInstructions.size() > 0) {
                conditionInstructions.getLast().nextInstruction = irLoad;
            }
            conditionInstructions.add(irLoad);
            conditionRes = irLoad.dest;
        }
        resultInstructions = conditionInstructions;

        // set branch instruction.
        IRBranchEqualZero irBranchEqualZero = new IRBranchEqualZero(conditionRes, irLabelElse);

        // else statement.
        LinkedList<IRInstruction> elseInstructions;
        if (astIfStatement.elseStatement == null) {
            irBranchEqualZero.gotoLabel = irLabelEndIf;
            elseInstructions = new LinkedList<>();
        } else {
            elseInstructions = astIfStatement.elseStatement.visit(this);
            if (elseInstructions.size() > 0) {
                elseInstructions.getFirst().label = irLabelElse;
            } else {
                irBranchEqualZero.gotoLabel = irLabelEndIf;
            }
        }

        // translate branch instruction.
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irBranchEqualZero;
        }
        resultInstructions.add(irBranchEqualZero);

        // then statement.
        LinkedList<IRInstruction> thenInstructions = astIfStatement.thenStatement.visit(this);
        if (astIfStatement.elseStatement != null) {
            IRJumpLabel irJumpLabel = new IRJumpLabel(irLabelEndIf);
            if (thenInstructions.size() > 0) {
                thenInstructions.getLast().nextInstruction = irJumpLabel;
            }
            thenInstructions.add(irJumpLabel);
        }
        if (resultInstructions.size() > 0) {
            if (thenInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = thenInstructions.getFirst();
            }
        }
        resultInstructions.addAll(thenInstructions);

        // translate else instructions.
        if (resultInstructions.size() > 0) {
            if (elseInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = elseInstructions.getFirst();
            }
        }
        resultInstructions.addAll(elseInstructions);

        //translate null operation as EndIF.
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irEndIfInstruction;
        }
        resultInstructions.add(irEndIfInstruction);

        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitJumpStatement(AstJumpStatement astJumpStatement) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRJumpLabel irJumpLabel;
        if (astJumpStatement.variant == AstJumpStatement.CONTINUE) {
            irJumpLabel = new IRJumpLabel(this.continueLoop);
        } else if (astJumpStatement.variant == AstJumpStatement.BREAK) {
            irJumpLabel = new IRJumpLabel(this.endLoop);
        } else if (astJumpStatement.variant == AstJumpStatement.RETURN) {
            IRData expressionRes = null;
            if (astJumpStatement.returnExpression != null) {
                LinkedList<IRInstruction> expressionInstructions = astJumpStatement.returnExpression.visit(this);
                expressionRes = this.expressionResult.get(astJumpStatement.returnExpression);
                if (expressionRes instanceof IRLocate) {
                    IRLoad irLoad = ((IRLocate) expressionRes).load();
                    if (expressionInstructions.size() > 0) {
                        expressionInstructions.getLast().nextInstruction = irLoad;
                    }
                    expressionRes = irLoad.dest;
                    expressionInstructions.add(irLoad);
                    resultInstructions.addAll(expressionInstructions);
                }
            }
            irJumpLabel = new IRReturn(this.endFunction, expressionRes);
        } else {
            throw new RuntimeException();
        }
        resultInstructions.add(irJumpLabel);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitWhileStatement(AstWhileStatement astWhileStatement) {
        IRLabel endLoopBackup = this.endLoop;
        IRLabel continueLoopBackup = this.continueLoop;
        //--------------------------------------------------------------
        IRLabel thisForCondition = new IRLabelBeginLoop();
        this.endLoop = new IRLabelEndLoop();
        this.continueLoop = new IRLabelContinueLoop();

        // a null operation for the end of loop.
        IRNullOperation endLoopInstructions = new IRNullOperation();
        endLoopInstructions.label = endLoop;

        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();

        // condition expression and loop body for a `while` statement;
        LinkedList<IRInstruction> loopInstructions = new LinkedList<>();

        if (astWhileStatement.cond instanceof AstBoolConstant) {
            if (!((AstBoolConstant) astWhileStatement.cond).boolConstant) {
                IRJumpLabel irJumpLabel = new IRJumpLabel(this.endLoop);
                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irJumpLabel;
                }
                resultInstructions.add(irJumpLabel);
            }
        } else {
            LinkedList<IRInstruction> conditionExpressionInstructions = astWhileStatement.cond.visit(this);
            IRData conditionRes = this.expressionResult.get(astWhileStatement.cond);
            if (conditionRes instanceof IRLocate) {
                IRLoad irLoad = ((IRLocate) conditionRes).load();
                if (conditionExpressionInstructions.size() > 0) {
                    conditionExpressionInstructions.getLast().nextInstruction = irLoad;
                }
                conditionExpressionInstructions.add(irLoad);
                conditionRes = irLoad.dest;
            }
            loopInstructions.addAll(conditionExpressionInstructions);
            IRBranchEqualZero irBranchEqualZero = new IRBranchEqualZero(conditionRes, this.endLoop);
            if (loopInstructions.size() > 0) {
                loopInstructions.getLast().nextInstruction = irBranchEqualZero;
            }
            loopInstructions.add(irBranchEqualZero);
        }
        loopInstructions.addAll(astWhileStatement.loopBody.visit(this));
        if (loopInstructions.size() > 0) {
            loopInstructions.getFirst().label = this.continueLoop;
        }
        resultInstructions.addAll(loopInstructions);

        // translate the null operation.
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = endLoopInstructions;
        }
        resultInstructions.add(endLoopInstructions);
        //--------------------------------------------------------------
        this.endLoop = endLoopBackup;
        this.continueLoop = continueLoopBackup;
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitExpressionList(AstExpressionList astExpressionList) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRInstruction lastInstruction = null;
        for (AstExpression astExpression : astExpressionList.expressions) {
            LinkedList<IRInstruction> instructions = astExpression.visit(this);
            if (instructions.size() > 0) {
                if (lastInstruction != null) {
                    if (instructions.size() > 0) {
                        lastInstruction.nextInstruction = instructions.getFirst();
                    }
                }
                resultInstructions.addAll(instructions);
                if (resultInstructions.size() > 0) {
                    lastInstruction = resultInstructions.getLast();
                }
            }
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCallGetInt(AstCallGetInt astCallGetInt) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRGetInt irGetInt = new IRGetInt();
        this.expressionResult.put(astCallGetInt, irGetInt.res);
        resultInstructions.add(irGetInt);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCallGetString(AstCallGetString astCallGetString) {
        // TODO
        throw new RuntimeException();
    }

    public LinkedList<IRInstruction> visitCallParseInt(AstCallParseInt astCallParseInt) {
        // would never be called.
        throw new RuntimeException();
    }

    public LinkedList<IRInstruction> visitCallPrint(AstCallPrint astCallPrint) {
        LinkedList<IRInstruction> resultInstructions = astCallPrint.parameter.visit(this);
        IRData parameterRes = this.expressionResult.get(astCallPrint.parameter);
        if (parameterRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) parameterRes).load();
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            parameterRes = irLoad.dest;
        }
        IRPrintString irPrintString = new IRPrintString(parameterRes);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irPrintString;
        }
        resultInstructions.add(irPrintString);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCallPrintln(AstCallPrintln astCallPrintln) {
        LinkedList<IRInstruction> resultInstructions = astCallPrintln.parameter.visit(this);
        IRData parameterRes = this.expressionResult.get(astCallPrintln.parameter);
        if (parameterRes instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) parameterRes).load();
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            parameterRes = irLoad.dest;
        }
        IRPrintString irPrintString = new IRPrintString(parameterRes);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irPrintString;
        }
        resultInstructions.add(irPrintString);
        IRPrintString irPrintNewLine = new IRPrintString(this.literalNewline);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irPrintNewLine;
        }
        resultInstructions.add(irPrintNewLine);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitCallSubString(AstCallSubString astCallSubString) {
        // would never be called.
        throw new RuntimeException();
    }

    public LinkedList<IRInstruction> visitCallToString(AstCallToString astCallToString) {
        LinkedList<IRInstruction> resultInstructions = astCallToString.childExpression.visit(this);
        IRData parameter = this.expressionResult.get(astCallToString.childExpression);
        if (parameter instanceof IRLocate) {
            IRLoad irLoad = ((IRLocate) parameter).load();
            if (resultInstructions.size() > 0) {
                resultInstructions.getLast().nextInstruction = irLoad;
            }
            resultInstructions.add(irLoad);
            parameter = irLoad.dest;
        }
        IRCall irCall = new IRCall(new IRLabelFunction("____built_in_toString"));
        irCall.parameters.add(parameter);
        this.expressionResult.put(astCallToString, irCall.res);
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irCall;
        }
        resultInstructions.add(irCall);
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitFunctionDefinition(AstFunctionDefinition astFunctionDefinition) {
        IRLabel endFunctionBackup = this.endFunction;
        this.endFunction = new IRLabelEndFunction(astFunctionDefinition.functionHead.functionName);
        LinkedList<IRInstruction> resultInstructions = astFunctionDefinition.functionBody.visit(this);
        if (resultInstructions.size() > 0) {
            if (resultInstructions.getFirst().label == null) {
                resultInstructions.getFirst().label = new IRLabelFunction(astFunctionDefinition.functionHead.functionName);
            } else {
                IRNullOperation irNullOperation = new IRNullOperation();
                irNullOperation.label = new IRLabelFunction(astFunctionDefinition.functionHead.functionName);
                irNullOperation.nextInstruction = resultInstructions.getFirst();
                resultInstructions.addFirst(irNullOperation);
            }
        }

        IRNullOperation irNullOperation = new IRNullOperation();
        irNullOperation.label = this.endFunction;
        if (resultInstructions.size() > 0) {
            resultInstructions.getLast().nextInstruction = irNullOperation;
        }
        resultInstructions.add(irNullOperation);
        this.endFunction = endFunctionBackup;
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitSingleVariableDeclaration(AstSingleVariableDeclaration astSingleVariableDeclaration) {
        // would never be called.
        throw new RuntimeException();
    }

    public LinkedList<IRInstruction> visitVariableDeclaration(AstVariableDeclaration astVariableDeclaration) {
        LinkedList<IRInstruction> resultInstructions = new LinkedList<>();
        IRInstruction lastInstruction = null;
        for (AstSingleVariableDeclaration astSingleVariableDeclaration : astVariableDeclaration.variables) {
            IRVariable irVariable = this.variableMap.get(astSingleVariableDeclaration.variable.globalID);

            if (irVariable == null) {
                irVariable = new IRVariable();
                irVariable.variableID = astSingleVariableDeclaration.variable.globalID;
                irVariable.stackShift = astSingleVariableDeclaration.variable.localID;
                this.variableMap.put(astSingleVariableDeclaration.variable.globalID, irVariable);
            }

            if (astSingleVariableDeclaration.parent.parent instanceof AstProgram) {
                irVariable.globalDataLabel = new IRLabelGlobalData();
                this.globalVariableMap.put(irVariable.variableID, irVariable.globalDataLabel);
                this.globalVariables.add(irVariable);
            }

            if (astSingleVariableDeclaration.initializeExpression != null) {
                LinkedList<IRInstruction> initialExpressionInstructions = astSingleVariableDeclaration.initializeExpression.visit(this);
                if (lastInstruction != null) {
                    if (initialExpressionInstructions.size() > 0) {
                        lastInstruction.nextInstruction = initialExpressionInstructions.getFirst();
                    }
                }
                IRData initialExpressionRes = this.expressionResult.get(astSingleVariableDeclaration.initializeExpression);
                if (initialExpressionRes instanceof IRLocate) {
                    IRLoad irLoad = ((IRLocate) initialExpressionRes).load();
                    if (initialExpressionInstructions.size() > 0) {
                        initialExpressionInstructions.getLast().nextInstruction = irLoad;
                    }
                    initialExpressionInstructions.add(irLoad);
                    initialExpressionRes = irLoad.dest;
                }
                resultInstructions.addAll(initialExpressionInstructions);

                IRStore irStore = new IRStore(initialExpressionRes, irVariable);

                if (resultInstructions.size() > 0) {
                    resultInstructions.getLast().nextInstruction = irStore;
                }
                resultInstructions.add(irStore);
                if (resultInstructions.size() > 0) {
                    lastInstruction = resultInstructions.getLast();
                }
            }
        }
        return resultInstructions;
    }

    public LinkedList<IRInstruction> visitAstVarStatement(AstVarStatement astVarStatement) {
        return astVarStatement.variableDeclaration.visit(this);
    }
}

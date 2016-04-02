package MentalAST;

import MentalAST.AstDeclaration.AstClassDeclaration;
import MentalAST.AstDeclaration.AstFunctionDefinition;
import MentalAST.AstDeclaration.AstSingleVariableDeclaration;
import MentalAST.AstDeclaration.AstVariableDeclaration;
import MentalAST.AstExpression.*;
import MentalAST.AstStatement.*;
import MentalParser.MentalParser;
import MentalParser.MentalBaseListener;
import MentalSymbols.*;
import MentalType.MentalArray;
import MentalType.MentalFunction;
import MentalType.MentalType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides an empty implementation of {@link MentalBaseListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class BuildTreeListener extends MentalBaseListener {
	public HashMap<ParseTree, AstBaseNode> tree;
	public SymbolTable curSymbolTable;
	public LinkedList<SymbolTable> symbolTableList;
	public BuildTreeListener() {
		this.tree = new HashMap<>();
		this.symbolTableList = new LinkedList<>();
		this.symbolTableList.add(new SymbolTable());
		this.curSymbolTable = this.symbolTableList.getLast();
	}
	public void beginScope() {
		this.symbolTableList.add(new SymbolTable(curSymbolTable));
		this.curSymbolTable = this.symbolTableList.getLast();
		this.curSymbolTable.stackLayer++;
	}
	public void endScope() {
		this.symbolTableList.removeLast();
		this.curSymbolTable = this.symbolTableList.getLast();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassName(MentalParser.ClassNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassName(MentalParser.ClassNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeName(MentalParser.TypeNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeName(MentalParser.TypeNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArray(MentalParser.ArrayContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArray(MentalParser.ArrayContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(MentalParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(MentalParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParametersList(MentalParser.ParametersListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParametersList(MentalParser.ParametersListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProgram(MentalParser.ProgramContext ctx) {
        this.tree.put(ctx, new AstProgram());
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgram(MentalParser.ProgramContext ctx) {
		AstProgram node = (AstProgram) tree.get(ctx);
		List<AstBaseNode> child = node.declarations;
		for (int i = 0, count = ctx.getChildCount(); i < count; ++i) {
            if (ctx.getChild(i) instanceof MentalParser.EmptyStatementContext) {
                continue;
            }
            child.add(tree.get(ctx.getChild(i)));
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration(MentalParser.DeclarationContext ctx) {
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(MentalParser.DeclarationContext ctx) {
        if (ctx.classDeclaration() != null) {
            this.tree.put(ctx, tree.get(ctx.classDeclaration()));
            this.tree.get(ctx).parent = this.tree.get(ctx.parent);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassDeclaration(MentalParser.ClassDeclarationContext ctx) {
		if (ctx.className() != null) {
			this.curSymbolTable.add(ctx.className().getText(), new SymbolType(curSymbolTable, ctx));
		}
        AstClassDeclaration classDeclaration = new AstClassDeclaration();
        classDeclaration.classDetail = (SymbolType) this.curSymbolTable.getSymbol(ctx.className().getText());
        this.tree.put(ctx, classDeclaration);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassDeclaration(MentalParser.ClassDeclarationContext ctx) {
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDefinition(MentalParser.DefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDefinition(MentalParser.DefinitionContext ctx) {
        if (ctx.functionDefinition() != null) {
            this.tree.put(ctx, this.tree.get(ctx.functionDefinition()));
        } else if (ctx.variableDefinition() != null) {
            this.tree.put(ctx, this.tree.get(ctx.variableDefinition()));
        }
        this.tree.get(ctx).parent = this.tree.get(ctx.parent);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSingleVariable(MentalParser.SingleVariableContext ctx) {
        AstSingleVariableDeclaration singleVariableDeclaration = new AstSingleVariableDeclaration();
        this.tree.put(ctx, singleVariableDeclaration);
        AstVariableDeclaration variableDeclaration = null;
        if (ctx.parent != null && ctx.parent.parent instanceof MentalParser.ClassDeclarationContext) {
            return ;
        }
        if (ctx.parent instanceof MentalParser.VariableDefinitionContext) {
            variableDeclaration = (AstVariableDeclaration) this.tree.get(ctx.parent);
        } else {
            System.err.println("unknown exception.");
            System.exit(-1);
        }
        singleVariableDeclaration.variable = new AstVariable();
        singleVariableDeclaration.variable.variableName = ctx.Identifier().getText();
        singleVariableDeclaration.variable.variableType = variableDeclaration.variableType;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSingleVariable(MentalParser.SingleVariableContext ctx) {
        if (ctx.parent != null && ctx.parent.parent instanceof MentalParser.ClassDeclarationContext) {
            return ;
        }
        AstSingleVariableDeclaration singleVariableDeclaration = (AstSingleVariableDeclaration) this.tree.get(ctx);
        if (ctx.expression() != null) {
            singleVariableDeclaration.initializeExpression = (AstExpression) this.tree.get(ctx.expression());
        }
        if (singleVariableDeclaration.initializeExpression == null) {
            return;
        }
        if (!singleVariableDeclaration.variable.variableType.equals(singleVariableDeclaration.initializeExpression.returnType)) {
            System.err.println("fatal: The types of variable and initial value are different.\n\t"
                    + "<var>" + singleVariableDeclaration.variable.variableType.toString()
                    + "<initial value>" + singleVariableDeclaration.initializeExpression.returnType
            );
            System.exit(-1);
        }
        singleVariableDeclaration.parent = this.tree.get(ctx.parent);
    }
    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableDefinition(MentalParser.VariableDefinitionContext ctx) {
        if (ctx.parent instanceof MentalParser.ClassDeclarationContext) {
            return ;
        }
		SymbolVariableList variableList = new SymbolVariableList(this.curSymbolTable, ctx);
		for (SymbolVariable var : variableList.variables) {
			this.curSymbolTable.add(var.variableName, var);
		}
        AstVariableDeclaration variableDeclaration = new AstVariableDeclaration();
        variableDeclaration.variables = new LinkedList<>();
        variableDeclaration.variableType = variableList.variableType;
        this.tree.put(ctx, variableDeclaration);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableDefinition(MentalParser.VariableDefinitionContext ctx) {
        if (ctx.parent instanceof MentalParser.ClassDeclarationContext) {
            return ;
        }
        AstVariableDeclaration variableDeclaration = (AstVariableDeclaration) this.tree.get(ctx);
        for (MentalParser.SingleVariableContext singleVariable : ctx.singleVariable()) {
            variableDeclaration.variables.add((AstSingleVariableDeclaration) this.tree.get(singleVariable));
        }
        variableDeclaration.parent = this.tree.get(ctx.parent);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDefinition(MentalParser.FunctionDefinitionContext ctx) {
		this.curSymbolTable.add(ctx.functionName.getText(), new SymbolFunction(this.curSymbolTable, ctx));
        this.beginScope();
        AstFunctionDefinition functionDefinition = new AstFunctionDefinition();
        functionDefinition.functionHead = (SymbolFunction) this.curSymbolTable.getSymbol(ctx.functionName.getText());
        this.tree.put(ctx, functionDefinition);
        for (int i = 0, count = functionDefinition.functionHead.parameterName.size(); i < count; ++i) {
            this.curSymbolTable.add(
                    functionDefinition.functionHead.parameterName.get(i),
                    new SymbolType(functionDefinition.functionHead.parameterType.get(i))
            );
        }
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionDefinition(MentalParser.FunctionDefinitionContext ctx) {
        this.endScope();
        AstFunctionDefinition functionDefinition = (AstFunctionDefinition) this.tree.get(ctx);
        functionDefinition.functionBody = (AstComponentStatement) this.tree.get(ctx.compoundStatement());
        functionDefinition.parent = this.tree.get(ctx.parent);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompoundStatement(MentalParser.CompoundStatementContext ctx) {
		if (!(ctx.parent instanceof MentalParser.FunctionDefinitionContext)) {
            this.beginScope();
        }
        AstComponentStatement componentStatement = new AstComponentStatement();
        this.tree.put(ctx, componentStatement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompoundStatement(MentalParser.CompoundStatementContext ctx) {
        if (!(ctx.parent instanceof MentalParser.FunctionDefinitionContext)) {
            this.endScope();
        }
        AstComponentStatement componentStatement = (AstComponentStatement) this.tree.get(ctx);
        for (MentalParser.StatementContext statementContext : ctx.statement()) {
            componentStatement.statements.add(this.tree.get(statementContext));
        }
        componentStatement.parent = this.tree.get(ctx.parent);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(MentalParser.StatementContext ctx) {
        if (ctx.variableDefinition() != null) {
            AstVarStatement varStatement = new AstVarStatement();
            this.tree.put(ctx, varStatement);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(MentalParser.StatementContext ctx) {
        if (ctx.variableDefinition() != null) {
            AstVarStatement varStatement = (AstVarStatement) this.tree.get(ctx);
            varStatement.variableDeclaration = (AstVariableDeclaration) this.tree.get(ctx.variableDefinition());
        } else if (ctx.ifElseStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.ifElseStatement()));
        } else if (ctx.ifStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.ifStatement()));
        } else if (ctx.compoundStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.compoundStatement()));
        } else if (ctx.emptyStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.emptyStatement()));
        } else if (ctx.callPrint() != null) {
            this.tree.put(ctx, this.tree.get(ctx.callPrint()));
        } else if (ctx.callPrintln() != null) {
            this.tree.put(ctx, this.tree.get(ctx.callPrintln()));
        } else if (ctx.expressionStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.expressionStatement()));
        } else if (ctx.forStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.forStatement()));
        } else if (ctx.whileStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.whileStatement()));
        }
        this.tree.get(ctx).parent = this.tree.get(ctx.parent);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallPrint(MentalParser.CallPrintContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallPrint(MentalParser.CallPrintContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallPrintln(MentalParser.CallPrintlnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallPrintln(MentalParser.CallPrintlnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallGetString(MentalParser.CallGetStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallGetString(MentalParser.CallGetStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallGetInt(MentalParser.CallGetIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallGetInt(MentalParser.CallGetIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallToString(MentalParser.CallToStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallToString(MentalParser.CallToStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallSubString(MentalParser.CallSubStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallSubString(MentalParser.CallSubStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallLength(MentalParser.CallLengthContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallLength(MentalParser.CallLengthContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallParseInt(MentalParser.CallParseIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallParseInt(MentalParser.CallParseIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallOrd(MentalParser.CallOrdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCallOrd(MentalParser.CallOrdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEmptyStatement(MentalParser.EmptyStatementContext ctx) {
        AstEmptyStatement emptyStatement = new AstEmptyStatement();
        this.tree.put(ctx, emptyStatement);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEmptyStatement(MentalParser.EmptyStatementContext ctx) {
        return;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(MentalParser.IfStatementContext ctx) {
        AstIfStatement ifStatement = new AstIfStatement();
        ifStatement.elseStatement = null;
        this.tree.put(ctx, ifStatement);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfStatement(MentalParser.IfStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfElseStatement(MentalParser.IfElseStatementContext ctx) {
        AstIfStatement ifElseStatement = new AstIfStatement();
        this.tree.put(ctx, ifElseStatement);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfElseStatement(MentalParser.IfElseStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForStatement(MentalParser.ForStatementContext ctx) {
        AstForStatement forStatement = new AstForStatement();
        this.tree.put(ctx, forStatement);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForStatement(MentalParser.ForStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileStatement(MentalParser.WhileStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileStatement(MentalParser.WhileStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJumpStatement(MentalParser.JumpStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitJumpStatement(MentalParser.JumpStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionStatement(MentalParser.ExpressionStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionStatement(MentalParser.ExpressionStatementContext ctx) {
        AstExpressionStatement expressionStatement = new AstExpressionStatement();
        expressionStatement.expression = (AstExpression) this.tree.get(ctx.expression());
        this.tree.put(ctx, expressionStatement);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_XOR_EXPRESSION(MentalParser.BIT_XOR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_XOR_EXPRESSION(MentalParser.BIT_XOR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) {
        AstLogicalNotExpression expression = new AstLogicalNotExpression();
        this.tree.put(ctx, expression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) {
        AstLogicalNotExpression thisExpression = (AstLogicalNotExpression) this.tree.get(ctx);
        AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression());
        if (!childExpression.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: try to apply logical-not-operator on a no-boolean item. " + ctx.getText());
        }
        thisExpression.childExpression = childExpression;
        childExpression.parent = thisExpression;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) {
        AstAdditiveExpression additiveExpression = new AstAdditiveExpression();
        if (ctx.op.getType() == MentalParser.PLUS) {
            additiveExpression.op = AstAdditiveExpression.ADD;
        } else {
            additiveExpression.op = AstAdditiveExpression.SUB;
        }
        this.tree.put(ctx, additiveExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) {
        AstAdditiveExpression thisExpression = (AstAdditiveExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(thisExpression.rightExpression.returnType)) {
            if (thisExpression.op == AstAdditiveExpression.ADD) {
                if (thisExpression.leftExpression.equals(SymbolTable.mentalString)) {
                    if (thisExpression.rightExpression.equals(SymbolTable.mentalString)) {
                        // string + string
                        thisExpression.returnType = SymbolTable.mentalString;
                        return;
                    }
                } else {
                    if (thisExpression.leftExpression.equals(SymbolTable.mentalInt)) {
                        if (thisExpression.rightExpression.equals(SymbolTable.mentalInt)) {
                            // int + int
                            thisExpression.returnType = SymbolTable.mentalInt;
                            return;
                        }
                    }
                }
            } else {
                if (thisExpression.leftExpression.equals(SymbolTable.mentalInt)) {
                    if (thisExpression.rightExpression.equals(SymbolTable.mentalInt)) {
                        // int - int
                        thisExpression.returnType = SymbolTable.mentalInt;
                        return;
                    }
                }
            }
        }
        System.err.println("fatal: the types of additive expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx) {
        AstCreationExpression creationExpression = new AstCreationExpression();
		SymbolType type = (SymbolType) this.curSymbolTable.getSymbol(ctx.typeName().getText());
		if (ctx.expression() == null || ctx.expression().size() == 0) {
			creationExpression.returnType = type.type;
			creationExpression.expressionList = null;
		} else {
			creationExpression.returnType = new MentalArray();
			((MentalArray) creationExpression.returnType).arrayType = type.type;
			((MentalArray) creationExpression.returnType).arrayDim = ctx.expression().size();
		}
        this.tree.put(ctx, creationExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx) {
        AstCreationExpression thisExpression = (AstCreationExpression) this.tree.get(ctx);
		if (ctx.expression() != null) {
			for (int i = 0, count = ctx.expression().size(); i < count; ++i) {
				AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression(i));
				childExpression.parent = thisExpression;
				if (!childExpression.returnType.equals(SymbolTable.mentalInt)) {
					System.err.println("fatal: new an array with no-int size. " + ctx.expression(i).getText());
					System.exit(-1);
				}
				thisExpression.expressionList.add(childExpression);
			}
		}
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_NOT_EXPRESSION(MentalParser.BIT_NOT_EXPRESSIONContext ctx) {
        AstBitNotExpression expression = new AstBitNotExpression();
        this.tree.put(ctx, expression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_NOT_EXPRESSION(MentalParser.BIT_NOT_EXPRESSIONContext ctx) {
        AstBitNotExpression thisExpression = (AstBitNotExpression) this.tree.get(ctx);
        AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression());
        if (!childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: try to apply bit-not-operator on a no-integer item. " + ctx.getText());
        }
        thisExpression.childExpression = childExpression;
        childExpression.parent = thisExpression;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRELATION_EXPRESSION(MentalParser.RELATION_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRELATION_EXPRESSION(MentalParser.RELATION_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEQUALITY_EXPRESSION(MentalParser.EQUALITY_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEQUALITY_EXPRESSION(MentalParser.EQUALITY_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterINT_LITERAL(MentalParser.INT_LITERALContext ctx) {
        AstIntLiteral intLiteral = new AstIntLiteral();
        intLiteral.literalContext = Integer.parseInt(ctx.getText());
        this.tree.put(ctx, intLiteral);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitINT_LITERAL(MentalParser.INT_LITERALContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIDENTIFIER(MentalParser.IDENTIFIERContext ctx) {
        AstIdentifier identifier = new AstIdentifier();
        identifier.name = ctx.Identifier().getText();
        if (this.curSymbolTable.getSymbol(identifier.name) == null) {
            System.err.println("warning: undefined identifier.");
        } else {
            SymbolBase base = this.curSymbolTable.getSymbol(identifier.name);
            if (base instanceof SymbolVariable) {
                identifier.returnType = ((SymbolVariable) base).variableType;
                identifier.leftValue = true;
            } else if (base instanceof SymbolFunction) {
                identifier.returnType = new MentalFunction();
                ((MentalFunction) identifier.returnType).functionHead = (SymbolFunction) base;
            } else {
                System.err.println("fatal: the identifier is a type.<" + identifier.name + ">");
                System.exit(-1);
            }
        }
        this.tree.put(ctx, identifier);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIDENTIFIER(MentalParser.IDENTIFIERContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstSuffixExpression suffixExpression = new AstSuffixExpression();
        if (ctx.op.getType() == MentalParser.INC) {
            suffixExpression.op = AstSuffixExpression.PLUS_PLUS;
        } else {
            suffixExpression.op = AstSuffixExpression.MINUS_MINUS;
        }
        this.tree.put(ctx, suffixExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstSuffixExpression thisExpression = (AstSuffixExpression) this.tree.get(ctx);
        AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression());
        if (!childExpression.leftValue) {
            System.err.println("fatal: try to apply suffix (inc/dec)reasement on a no-leftvalue. " + ctx.expression().getText());
            System.exit(-1);
        }
        if (!childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("warning: try to apply suffix (inc/dec)reasement on a no-digit. " + ctx.expression().getText());
        }
        childExpression.parent = thisExpression;
        thisExpression.childExpression = childExpression;
        thisExpression.returnType = childExpression.returnType;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx) {
        AstMulDivExpression mulDivExpression = new AstMulDivExpression();
        if (ctx.op.getType() == MentalParser.MUL) {
            mulDivExpression.op = AstMulDivExpression.MUL;
        } else if (ctx.op.getType() == MentalParser.DIV) {
            mulDivExpression.op = AstMulDivExpression.DIV;
        } else {
            mulDivExpression.op = AstMulDivExpression.MOD;
        }
        this.tree.put(ctx, mulDivExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx) {
        AstMulDivExpression thisExpression = (AstMulDivExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        }
        System.err.println("fatal: the types of multiply/divide expression cannot accept. " + ctx.getText());
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_OR_EXPRESSION(MentalParser.LOGICAL_OR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLOGICAL_OR_EXPRESSION(MentalParser.LOGICAL_OR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterASSIGN_EXPRESSION(MentalParser.ASSIGN_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitASSIGN_EXPRESSION(MentalParser.ASSIGN_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNULL(MentalParser.NULLContext ctx) {
		this.tree.put(ctx, new AstNullConstant());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNULL(MentalParser.NULLContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTRUE(MentalParser.TRUEContext ctx) {
        AstBoolConstant node = new AstBoolConstant();
        node.boolConstant = true;
        this.tree.put(ctx, node);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTRUE(MentalParser.TRUEContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_OR_EXPRESSION(MentalParser.BIT_OR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_OR_EXPRESSION(MentalParser.BIT_OR_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_AND_EXPRESSION(MentalParser.LOGICAL_AND_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLOGICAL_AND_EXPRESSION(MentalParser.LOGICAL_AND_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx) {
        AstBitShiftExpression bitShiftExpression = new AstBitShiftExpression();
        this.tree.put(ctx, bitShiftExpression);
        if (ctx.op.getType() == MentalParser.LEFT_SHIFT) {
            bitShiftExpression.op = AstBitShiftExpression.LEFT_SHIFT;
        } else {
            bitShiftExpression.op = AstBitShiftExpression.RIGHT_SHIFT;
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx) {
        AstBitShiftExpression thisExpression = (AstBitShiftExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        }
        System.err.println("fatal: the types of bit-shift expression cannnot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstPrefixExpression prefixExpression = new AstPrefixExpression();
        if (ctx.op.getType() == MentalParser.INC) {
            prefixExpression.op = AstPrefixExpression.PLUS_PLUS;
        } else {
            prefixExpression.op = AstPrefixExpression.MINUS_MINUS;
        }
        this.tree.put(ctx, prefixExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstPrefixExpression thisExpression = (AstPrefixExpression) this.tree.get(ctx);
        AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression = childExpression;
        childExpression.parent = thisExpression;
        if (!childExpression.leftValue) {
            System.err.println("fatal: try to apply a prefix inc/dec on a non-left-value. " + ctx.getText());
            System.exit(-1);
        }
        if (!childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: try to apply a prefix inc/dec on a no-integer. " + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterARRAY_SUBSCRIPTING_EXPRESSION(MentalParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx) {
        AstArraySubscriptingExpression arraySubscriptingExpression = new AstArraySubscriptingExpression();
        this.tree.put(ctx, arraySubscriptingExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitARRAY_SUBSCRIPTING_EXPRESSION(MentalParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx) {
        AstArraySubscriptingExpression thisExpression = (AstArraySubscriptingExpression) this.tree.get(ctx);
        thisExpression.primaryExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.positionExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.primaryExpression.parent = thisExpression;
        thisExpression.positionExpression.parent = thisExpression;
        if (thisExpression.primaryExpression.returnType instanceof MentalArray) {
            if (thisExpression.positionExpression.returnType.equals(SymbolTable.mentalInt)) {
                if (((MentalArray) thisExpression.primaryExpression.returnType).arrayDim > 1) {
                    thisExpression.returnType = new MentalArray((MentalArray) thisExpression.primaryExpression.returnType);
                    ((MentalArray) thisExpression.returnType).arrayDim--;
                } else {
                    thisExpression.returnType = ((MentalArray) thisExpression.primaryExpression.returnType).arrayType;
                }
            } else {
                System.err.println("fatal: the result of position expression is not a integer. " + ctx.getText());
                System.exit(-1);
            }
        } else {
            System.err.println("fatal: the result of primary expression is not a array. " + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSUBGROUP_EXPRESSION(MentalParser.SUBGROUP_EXPRESSIONContext ctx) {
        AstSubgroupExpression subgroupExpression = new AstSubgroupExpression();
        this.tree.put(ctx, subgroupExpression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSUBGROUP_EXPRESSION(MentalParser.SUBGROUP_EXPRESSIONContext ctx) {
        AstSubgroupExpression thisExpression = (AstSubgroupExpression) this.tree.get(ctx);
        thisExpression.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression.parent = thisExpression;
        thisExpression.returnType = thisExpression.childExpression.returnType;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx) {
		AstBitAndExpression bitAndExpression = new AstBitAndExpression();
        this.tree.put(ctx, bitAndExpression);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx) {
        AstBitAndExpression thisExpression = (AstBitAndExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.equals(SymbolTable.mentalInt)) {
                return ;
            }
        }
        System.err.println("fatal: the types of sides of bit-and expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSTRING_LITERAL(MentalParser.STRING_LITERALContext ctx) {
        AstStringLiteral stringLiteral = new AstStringLiteral();
        stringLiteral.literalContext = ctx.getText();
        this.tree.put(ctx, stringLiteral);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSTRING_LITERAL(MentalParser.STRING_LITERALContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFALSE(MentalParser.FALSEContext ctx) {
        AstBoolConstant node = new AstBoolConstant();
        node.boolConstant = false;
        this.tree.put(ctx, node);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFALSE(MentalParser.FALSEContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx) {
        AstUnaryAdditiveExpression expression = new AstUnaryAdditiveExpression();
        if (ctx.op.getType() == MentalParser.PLUS) {
            expression.op = AstUnaryAdditiveExpression.ADD;
        } else {
            expression.op = AstUnaryAdditiveExpression.SUB;
        }
        this.tree.put(ctx, expression);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx) {
        AstUnaryAdditiveExpression thisExpression = (AstUnaryAdditiveExpression) this.tree.get(ctx);
        AstExpression childExpression = (AstExpression) this.tree.get(ctx.expression());
        childExpression.parent = thisExpression;
        thisExpression.childExpression = childExpression;
        if (!childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: try to apply unary plus/minus on a no-int type. " + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionList(MentalParser.ExpressionListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionList(MentalParser.ExpressionListContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) {
        System.err.println("fatal: there is an error in grammar analysis.");
        System.exit(-1);
    }
}
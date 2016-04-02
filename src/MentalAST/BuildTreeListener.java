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
import MentalType.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
	@Override public void enterClassName(MentalParser.ClassNameContext ctx) { }
	@Override public void exitClassName(MentalParser.ClassNameContext ctx) { }
	@Override public void enterTypeName(MentalParser.TypeNameContext ctx) { }
	@Override public void exitTypeName(MentalParser.TypeNameContext ctx) { }
	@Override public void enterArray(MentalParser.ArrayContext ctx) { }
	@Override public void exitArray(MentalParser.ArrayContext ctx) { }
	@Override public void enterType(MentalParser.TypeContext ctx) { }
	@Override public void exitType(MentalParser.TypeContext ctx) { }
	@Override public void enterParametersList(MentalParser.ParametersListContext ctx) { }
	@Override public void exitParametersList(MentalParser.ParametersListContext ctx) { }
	@Override public void enterProgram(MentalParser.ProgramContext ctx) {
        this.tree.put(ctx, new AstProgram());
    }
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
	@Override public void enterDeclaration(MentalParser.DeclarationContext ctx) { }
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
	@Override public void exitClassDeclaration(MentalParser.ClassDeclarationContext ctx) {	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	@Override public void exitFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDefinition(MentalParser.DefinitionContext ctx) { }
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
	@Override public void exitFunctionDefinition(MentalParser.FunctionDefinitionContext ctx) {
        this.endScope();
        AstFunctionDefinition functionDefinition = (AstFunctionDefinition) this.tree.get(ctx);
        functionDefinition.functionBody = (AstComponentStatement) this.tree.get(ctx.compoundStatement());
        functionDefinition.parent = this.tree.get(ctx.parent);
        functionDefinition.functionBody.parent = functionDefinition;
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
        } else if (ctx.jumpStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.jumpStatement()));
        }
        this.tree.get(ctx).parent = this.tree.get(ctx.parent);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallPrint(MentalParser.CallPrintContext ctx) {
        AstCallPrint callPrint = new AstCallPrint();
        this.tree.put(ctx, callPrint);
    }
	@Override public void exitCallPrint(MentalParser.CallPrintContext ctx) {
        AstCallPrint thisCall = (AstCallPrint) this.tree.get(ctx);
        thisCall.parameter = (AstExpression) this.tree.get(ctx.expression());
        thisCall.parameter.parent = thisCall;
        if (!thisCall.parameter.returnType.equals(SymbolTable.mentalString)) {
            System.err.println("fatal: print only accept string as parameter.\n\t" + ctx.getText());
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallPrintln(MentalParser.CallPrintlnContext ctx) {
        AstCallPrintln callPrintln = new AstCallPrintln();
        this.tree.put(ctx, callPrintln);
    }
	@Override public void exitCallPrintln(MentalParser.CallPrintlnContext ctx) {
        AstCallPrintln thisCall = (AstCallPrintln) this.tree.get(ctx);
        thisCall.parameter = (AstExpression) this.tree.get(ctx.expression());
        thisCall.parameter.parent = thisCall;
        if (!thisCall.parameter.returnType.equals(SymbolTable.mentalString)) {
            System.err.println("fatal: println only accept string as parameter.\n\t" + ctx.getText());
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallGetString(MentalParser.CallGetStringContext ctx) {
        AstCallGetString callGetString = new AstCallGetString();
        this.tree.put(ctx, callGetString);
    }
	@Override public void exitCallGetString(MentalParser.CallGetStringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallGetInt(MentalParser.CallGetIntContext ctx) {
        AstCallGetInt callGetInt = new AstCallGetInt();
        this.tree.put(ctx, callGetInt);
    }
	@Override public void exitCallGetInt(MentalParser.CallGetIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallToString(MentalParser.CallToStringContext ctx) {
        AstCallToString callToString = new AstCallToString();
        this.tree.put(ctx, callToString);
    }
	@Override public void exitCallToString(MentalParser.CallToStringContext ctx) {
        AstCallToString thisCall = (AstCallToString) this.tree.get(ctx);
        thisCall.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisCall.childExpression.parent = thisCall;
        if (!thisCall.childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: the parameter of toString(int) call is not an integer.\n\t" + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallSubString(MentalParser.CallSubStringContext ctx) {
        AstCallSubString callSubString = new AstCallSubString();
        this.tree.put(ctx, callSubString);
    }
	@Override public void exitCallSubString(MentalParser.CallSubStringContext ctx) {
        AstCallSubString thisCall = (AstCallSubString) this.tree.get(ctx);
        thisCall.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisCall.leftExpression.parent = thisCall;
        thisCall.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisCall.rightExpression.parent = thisCall;
        if (thisCall.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisCall.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        }
        System.err.println("fatal: at least one parameter in substring call is not integer.\n"
                + "\t" + ctx.expression(0).getText() + "\n"
                + "\t" + ctx.expression(1).getText()
        );
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallLength(MentalParser.CallLengthContext ctx) {
        AstCallLength callLength = new AstCallLength();
        this.tree.put(ctx, callLength);
    }
	@Override public void exitCallLength(MentalParser.CallLengthContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallParseInt(MentalParser.CallParseIntContext ctx) {
        AstCallParseInt callParseInt = new AstCallParseInt();
        this.tree.put(ctx, callParseInt);
    }
	@Override public void exitCallParseInt(MentalParser.CallParseIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCallOrd(MentalParser.CallOrdContext ctx) {
        AstCallOrd callOrd = new AstCallOrd();
        this.tree.put(ctx, callOrd);
    }
	@Override public void exitCallOrd(MentalParser.CallOrdContext ctx) {
        AstCallOrd thisCall = (AstCallOrd) this.tree.get(ctx);
        thisCall.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisCall.childExpression.parent = thisCall;
        if (!(thisCall.childExpression.returnType instanceof MentalInt)) {
            System.err.println("fatal: the parameter of ord(int) call is not an integer.\n\t" + ctx.getText());
            System.exit(-1);
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCallSize(MentalParser.CallSizeContext ctx) {
        AstCallSize callSize = new AstCallSize();
        this.tree.put(ctx, callSize);
    }
    @Override public void exitCallSize(MentalParser.CallSizeContext ctx) { }
    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEmptyStatement(MentalParser.EmptyStatementContext ctx) {
        AstEmptyStatement emptyStatement = new AstEmptyStatement();
        this.tree.put(ctx, emptyStatement);
    }
	@Override public void exitEmptyStatement(MentalParser.EmptyStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(MentalParser.IfStatementContext ctx) {
        AstIfStatement ifStatement = new AstIfStatement();
        this.tree.put(ctx, ifStatement);
    }
	@Override public void exitIfStatement(MentalParser.IfStatementContext ctx) {
        AstIfStatement thisStatement = (AstIfStatement) this.tree.get(ctx);
        thisStatement.condition = (AstExpression) this.tree.get(ctx.expression());
        thisStatement.condition.parent = thisStatement;
        thisStatement.thenStatement = (AstStatement) this.tree.get(ctx.thenStatement);
        thisStatement.thenStatement.parent = thisStatement;
        if (!thisStatement.condition.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: the condition of if-statement is not boolean." + ctx.expression().getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfElseStatement(MentalParser.IfElseStatementContext ctx) {
        AstIfStatement ifElseStatement = new AstIfStatement();
        this.tree.put(ctx, ifElseStatement);
    }
	@Override public void exitIfElseStatement(MentalParser.IfElseStatementContext ctx) {
        AstIfStatement thisStatement = (AstIfStatement) this.tree.get(ctx);
        thisStatement.condition = (AstExpression) this.tree.get(ctx.expression());
        thisStatement.condition.parent = thisStatement;
        thisStatement.thenStatement = (AstStatement) this.tree.get(ctx.thenStatement);
        thisStatement.thenStatement.parent = thisStatement;
        thisStatement.elseStatement = (AstStatement) this.tree.get(ctx.elseStatment);
        thisStatement.elseStatement.parent = thisStatement;
        if (!thisStatement.condition.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: the condition of if-statement is not boolean." + ctx.expression().getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForStatement(MentalParser.ForStatementContext ctx) {
        AstForStatement forStatement = new AstForStatement();
        this.tree.put(ctx, forStatement);
    }
	@Override public void exitForStatement(MentalParser.ForStatementContext ctx) {
        AstForStatement thisStatement = (AstForStatement) this.tree.get(ctx);
        thisStatement.start = (AstExpression) this.tree.get(ctx.start);
        thisStatement.start.parent = thisStatement;
        thisStatement.cond = (AstExpression) this.tree.get(ctx.cond);
        thisStatement.cond.parent = thisStatement;
        thisStatement.loop = (AstExpression) this.tree.get(ctx.loop);
        thisStatement.loop.parent = thisStatement;
        thisStatement.loopBody = (AstStatement) this.tree.get(ctx.statement());
        thisStatement.loopBody.parent = thisStatement;
        if (!thisStatement.cond.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: the loop condition of for statement does not return boolean. " + ctx.cond.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileStatement(MentalParser.WhileStatementContext ctx) {
        AstWhileStatement whileStatement = new AstWhileStatement();
        this.tree.put(ctx, whileStatement);
    }
	@Override public void exitWhileStatement(MentalParser.WhileStatementContext ctx) {
        AstWhileStatement thisStatement = (AstWhileStatement) this.tree.get(ctx);
        thisStatement.cond = (AstExpression) this.tree.get(ctx.cond);
        thisStatement.cond.parent = thisStatement;
        thisStatement.loopBody = (AstStatement) this.tree.get(ctx.statement());
        thisStatement.loopBody.parent = thisStatement;
        if (!thisStatement.cond.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: the loop condition of for statement does not return boolean. " + ctx.cond.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJumpStatement(MentalParser.JumpStatementContext ctx) {
        AstJumpStatement jumpStatement = new AstJumpStatement();
        if (ctx.expression() == null) {
            if (ctx.getText().equals("continue")) {
                jumpStatement.variant = AstJumpStatement.CONTINUE;
            } else {
                jumpStatement.variant = AstJumpStatement.BREAK;
            }
        } else {
            jumpStatement.variant = AstJumpStatement.RETURN;
        }
        this.tree.put(ctx, jumpStatement);
    }
	@Override public void exitJumpStatement(MentalParser.JumpStatementContext ctx) {
        AstJumpStatement thisStatement = (AstJumpStatement) this.tree.get(ctx);
        if (thisStatement.variant == AstJumpStatement.BREAK || thisStatement.variant == AstJumpStatement.CONTINUE) {
            RuleContext node = ctx;
            while (node != null && !(node.parent instanceof MentalParser.ForStatementContext
                    || node.parent instanceof MentalParser.WhileStatementContext)
                    ) {
                node = node.parent;
            }
            if (node != null) {
                return;
            }
        } else {
            thisStatement.returnExpression = (AstExpression) this.tree.get(ctx.expression());
            thisStatement.returnExpression.parent = thisStatement;
            RuleContext node = ctx.parent;
            while (node != null && !(node instanceof MentalParser.FunctionDefinitionContext)) {
                node = node.parent;
            }
            if (node != null) {
                AstFunctionDefinition functionDefinition = (AstFunctionDefinition) this.tree.get(node);
                if (functionDefinition.functionHead.returnType.equals(thisStatement.returnExpression.returnType)) {
                    return;
                } else {
                    System.err.println("fatal: return a wrong type value.\n"
                            + "\texpected " + functionDefinition.functionHead.returnType.toString()
                            + "\n\toccurs " + thisStatement.returnExpression.returnType.toString()
                    );
                    System.exit(-1);
                }
            }
        }
        System.err.println("fatal: a illegal jump statement. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionStatement(MentalParser.ExpressionStatementContext ctx) { }
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
	@Override public void enterBIT_XOR_EXPRESSION(MentalParser.BIT_XOR_EXPRESSIONContext ctx) {
        AstBitXorExpression bitXorExpression = new AstBitXorExpression();
        this.tree.put(ctx, bitXorExpression);
    }
	@Override public void exitBIT_XOR_EXPRESSION(MentalParser.BIT_XOR_EXPRESSIONContext ctx) {
        AstBitXorExpression thisExpression = (AstBitXorExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        }
        System.err.println("fatal: the types of bit-xor expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) {
        AstLogicalNotExpression expression = new AstLogicalNotExpression();
        this.tree.put(ctx, expression);
    }
	@Override public void exitLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) {
        AstLogicalNotExpression thisExpression = (AstLogicalNotExpression) this.tree.get(ctx);
        thisExpression.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression.parent = thisExpression;
        if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: try to apply logical-not-operator on a no-boolean item. " + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) {
        AstMemberAccessExpression memberAccessExpression = new AstMemberAccessExpression();
        this.tree.put(ctx, memberAccessExpression);
    }
	@Override public void exitMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) {
        AstMemberAccessExpression thisExpression = (AstMemberAccessExpression) this.tree.get(ctx);
        thisExpression.primaryExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.primaryExpression.parent = thisExpression;
        if (ctx.callLength() != null) {
            if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                thisExpression.memberExpression = (AstExpression) this.tree.get(ctx.callLength());
                thisExpression.memberExpression.parent = thisExpression;
                thisExpression.returnType = SymbolTable.mentalInt;
            } else {
                System.err.println("fatal: try to apply length() method on other type except string. " + ctx.getText());
                System.exit(-1);
            }
        } else if (ctx.callSubString() != null) {
            if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                thisExpression.memberExpression = (AstExpression) this.tree.get(ctx.callSubString());
                thisExpression.memberExpression.parent = thisExpression;
                thisExpression.returnType = SymbolTable.mentalString;
            } else {
                System.err.println("fatal: try to apply substring(int, int) method on other type except string. " + ctx.getText());
                System.exit(-1);
            }
        } else if (ctx.callOrd() != null) {
            if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                thisExpression.memberExpression = (AstExpression) this.tree.get(ctx.callOrd());
                thisExpression.memberExpression.parent = thisExpression;
                thisExpression.returnType = SymbolTable.mentalInt;
            } else {
                System.err.println("fatal: try to apply ord(int) method on other type except string. " + ctx.getText());
                System.exit(-1);
            }
        } else if (ctx.callParseInt() != null) {
            if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                thisExpression.memberExpression = (AstExpression) this.tree.get(ctx.callParseInt());
                thisExpression.memberExpression.parent = thisExpression;
                thisExpression.returnType = SymbolTable.mentalInt;
            } else {
                System.err.println("fatal: try to apply parseInt() method on other type except string. " + ctx.getText());
                System.exit(-1);
            }
        } else if (ctx.callSize() != null) {
            if (thisExpression.primaryExpression.returnType instanceof MentalArray) {
                thisExpression.memberExpression = (AstExpression) this.tree.get(ctx.callSize());
                thisExpression.returnType = SymbolTable.mentalInt;
            } else {
                System.err.println("fatal: try to apply size() method on other type except array. " + ctx.getText());
                System.exit(-1);
            }
        } else {
            thisExpression.memberExpression = null;
            thisExpression.memberName = ctx.Identifier().getText();
            if (thisExpression.primaryExpression.returnType instanceof MentalClass) {
                MentalClass thisClass = (MentalClass) thisExpression.primaryExpression.returnType;
                if (thisClass.classComponents.get(thisExpression.memberName) != null) {
                    thisExpression.leftValue = true;
                    thisExpression.returnType = thisClass.classComponents.get(thisExpression.memberName);
                } else {
                    System.out.println("fatal: the class `" + thisClass.className
                            + "` does not have the memeber `" + thisExpression.memberName + "`."
                    );
                    System.exit(-1);
                }
            } else {
                System.err.println("fatal: " + ctx.expression().getText() + "is not a class. ");
                System.exit(-1);
            }
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    // TODO
	@Override public void enterFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) { }
	@Override public void exitFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) {
        AstAdditiveExpression additiveExpression = new AstAdditiveExpression();
        additiveExpression.op = ctx.op.getType();
        this.tree.put(ctx, additiveExpression);
    }
	@Override public void exitADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) {
        AstAdditiveExpression thisExpression = (AstAdditiveExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(thisExpression.rightExpression.returnType)) {
            if (thisExpression.op == AstAdditiveExpression.ADD) {
                if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalString)) {
                    if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalString)) {
                        // string + string
                        thisExpression.returnType = SymbolTable.mentalString;
                        return;
                    }
                } else {
                    if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
                        if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                            // int + int
                            thisExpression.returnType = SymbolTable.mentalInt;
                            return;
                        }
                    }
                }
            } else {
                if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
                    if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
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
            creationExpression.baseType = type.type;
			creationExpression.expressionList = null;
		} else {
			creationExpression.returnType = new MentalArray();
            creationExpression.baseType = type.type;
			((MentalArray) creationExpression.returnType).arrayType = type.type;
			((MentalArray) creationExpression.returnType).arrayDim = ctx.expression().size();
		}
        this.tree.put(ctx, creationExpression);
    }
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
        thisExpression.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression.parent = thisExpression;
        if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: try to apply bit-not-operator on a no-integer item. " + ctx.getText());
            System.exit(-1);
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRELATION_EXPRESSION(MentalParser.RELATION_EXPRESSIONContext ctx) {
        AstRelationExpression relationExpression = new AstRelationExpression();
        if (ctx.op.getType() == MentalParser.LESS) {
            relationExpression.op = AstRelationExpression.LESS;
        } else if (ctx.op.getType() == MentalParser.LESS_EQUAL) {
            relationExpression.op = AstRelationExpression.LESS_EQ;
        } else if (ctx.op.getType() == MentalParser.GREATER) {
            relationExpression.op = AstRelationExpression.GREATER;
        } else {
            relationExpression.op = AstRelationExpression.GREATER_EQ;
        }
        this.tree.put(ctx, relationExpression);
    }
	@Override public void exitRELATION_EXPRESSION(MentalParser.RELATION_EXPRESSIONContext ctx) {
        AstRelationExpression thisExpression = (AstRelationExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        } else if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalString)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalString)) {
                return;
            }
        }
        System.err.println("fatal: the types of relation expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEQUALITY_EXPRESSION(MentalParser.EQUALITY_EXPRESSIONContext ctx) {
        AstEqualityExpression equalityExpression = new AstEqualityExpression();
        equalityExpression.op = ctx.op.getType();
        this.tree.put(ctx, equalityExpression);
    }
	@Override public void exitEQUALITY_EXPRESSION(MentalParser.EQUALITY_EXPRESSIONContext ctx) {
        AstEqualityExpression thisExpression = (AstEqualityExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(thisExpression.rightExpression.returnType)) {
            return;
        }
        System.err.println("fatal: the types of equality expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
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
	@Override public void exitIDENTIFIER(MentalParser.IDENTIFIERContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstSuffixExpression suffixExpression = new AstSuffixExpression();
        suffixExpression.op = ctx.op.getType();
        this.tree.put(ctx, suffixExpression);
    }
	@Override public void exitSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstSuffixExpression thisExpression = (AstSuffixExpression) this.tree.get(ctx);
        thisExpression.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression.parent = thisExpression;
        thisExpression.returnType = thisExpression.childExpression.returnType;
        if (!thisExpression.childExpression.leftValue) {
            System.err.println("fatal: try to apply suffix (inc/dec)reasement on a no-leftvalue. " + ctx.expression().getText());
            System.exit(-1);
        }
        if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalInt)) {
            System.err.println("fatal: try to apply suffix (inc/dec)reasement on a no-digit. " + ctx.expression().getText());
            System.exit(-1);
        }

    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx) {
        AstMulDivExpression mulDivExpression = new AstMulDivExpression();
        mulDivExpression.op = ctx.op.getType();
        this.tree.put(ctx, mulDivExpression);
    }
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
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_OR_EXPRESSION(MentalParser.LOGICAL_OR_EXPRESSIONContext ctx) {
        AstLogicalOrExpression logicalOrExpression = new AstLogicalOrExpression();
        this.tree.put(ctx, logicalOrExpression);
    }
	@Override public void exitLOGICAL_OR_EXPRESSION(MentalParser.LOGICAL_OR_EXPRESSIONContext ctx) {
        AstLogicalOrExpression thisExpression = (AstLogicalOrExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalBool)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalBool)) {
                return;
            }
        }
        System.err.println("fatal: the types of logical-or expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterASSIGN_EXPRESSION(MentalParser.ASSIGN_EXPRESSIONContext ctx) {
        AstAssignExpression assignExpression = new AstAssignExpression();
        this.tree.put(ctx, assignExpression);
    }
	@Override public void exitASSIGN_EXPRESSION(MentalParser.ASSIGN_EXPRESSIONContext ctx) {
        AstAssignExpression thisExpression = (AstAssignExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.rightExpression.parent = thisExpression;
        if (!thisExpression.leftExpression.leftValue) {
            System.err.println("fatal: the left side of operator= cannot be a left-value. " + ctx.getText());
            System.exit(-1);
        }
        if (!thisExpression.leftExpression.returnType.equals(thisExpression.rightExpression.returnType)) {
            System.err.println("fatal: the types of both sides of operator= are different.\n"
                    + "\t left side: " + thisExpression.leftExpression.returnType + "\n"
                    + "\tright side: " + thisExpression.rightExpression.returnType
            );
            System.exit(-1);
        }
        thisExpression.returnType = thisExpression.leftExpression.returnType;
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNULL(MentalParser.NULLContext ctx) {
		this.tree.put(ctx, new AstNullConstant());
	}
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
	@Override public void exitTRUE(MentalParser.TRUEContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_OR_EXPRESSION(MentalParser.BIT_OR_EXPRESSIONContext ctx) {
		AstBitOrExpression bitOrExpression = new AstBitOrExpression();
        this.tree.put(ctx, bitOrExpression);
	}
	@Override public void exitBIT_OR_EXPRESSION(MentalParser.BIT_OR_EXPRESSIONContext ctx) {
        AstBitOrExpression thisExpression = (AstBitOrExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                return;
            }
        }
        System.err.println("fatal: the types of bit-or expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLOGICAL_AND_EXPRESSION(MentalParser.LOGICAL_AND_EXPRESSIONContext ctx) {
        AstLogicalAndExpression logicalAndExpression = new AstLogicalAndExpression();
        this.tree.put(ctx, logicalAndExpression);
    }
	@Override public void exitLOGICAL_AND_EXPRESSION(MentalParser.LOGICAL_AND_EXPRESSIONContext ctx) {
        AstLogicalAndExpression thisExpression = (AstLogicalAndExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalBool)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalBool)) {
                return;
            }
        }
        System.err.println("fatal: the types of logical-and expression cannot accept. " + ctx.getText());
        System.exit(-1);
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx) {
        AstBitShiftExpression bitShiftExpression = new AstBitShiftExpression();
        bitShiftExpression.op = ctx.op.getType();
        this.tree.put(ctx, bitShiftExpression);
    }
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
        prefixExpression.op = ctx.op.getType();
        this.tree.put(ctx, prefixExpression);
    }
	@Override public void exitPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx) {
        AstPrefixExpression thisExpression = (AstPrefixExpression) this.tree.get(ctx);
        thisExpression.childExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.childExpression.parent = thisExpression;
        if (!thisExpression.childExpression.leftValue) {
            System.err.println("fatal: try to apply a prefix inc/dec on a non-left-value. " + ctx.getText());
            System.exit(-1);
        }
        if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalInt)) {
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
	@Override public void exitBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx) {
        AstBitAndExpression thisExpression = (AstBitAndExpression) this.tree.get(ctx);
        thisExpression.leftExpression = (AstExpression) this.tree.get(ctx.expression(0));
        thisExpression.rightExpression = (AstExpression) this.tree.get(ctx.expression(1));
        thisExpression.leftExpression.parent = thisExpression;
        thisExpression.rightExpression.parent = thisExpression;
        if (thisExpression.leftExpression.returnType.equals(SymbolTable.mentalInt)) {
            if (thisExpression.rightExpression.returnType.equals(SymbolTable.mentalInt)) {
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
	@Override public void exitFALSE(MentalParser.FALSEContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx) {
        AstUnaryAdditiveExpression unaryAdditiveExpression = new AstUnaryAdditiveExpression();
        unaryAdditiveExpression.op = ctx.op.getType();
        this.tree.put(ctx, unaryAdditiveExpression);
    }
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
    // TODO
	@Override public void enterExpressionList(MentalParser.ExpressionListContext ctx) { }
	@Override public void exitExpressionList(MentalParser.ExpressionListContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) {
        System.err.println("fatal: there is an error in grammar analysis.");
        System.exit(-1);
    }
}
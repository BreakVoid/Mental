package MentalAST;

import MentalParser.MentalParser;
import MentalParser.MentalBaseListener;
import MentalSymbols.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

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
            System.out.println(tree.get(ctx.getChild(i)));
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
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSingleVariable(MentalParser.SingleVariableContext ctx) {
        // TODO
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
        AstVariableDeclaration treeNode = (AstVariableDeclaration) this.tree.get(ctx);
        for (MentalParser.SingleVariableContext singleVariable : ctx.singleVariable()) {
            treeNode.variables.add((AstSingleVariableDeclaration) this.tree.get(singleVariable));
        }
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
        if (ctx.parent instanceof MentalParser.StatementContext) {
            this.tree.put(ctx.parent, componentStatement);
        }
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(MentalParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(MentalParser.StatementContext ctx) { }
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
	@Override public void enterEmptyStatement(MentalParser.EmptyStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEmptyStatement(MentalParser.EmptyStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(MentalParser.IfStatementContext ctx) { }
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
	@Override public void enterIfElseStatement(MentalParser.IfElseStatementContext ctx) { }
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
	@Override public void enterForStatement(MentalParser.ForStatementContext ctx) { }
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
	@Override public void exitExpressionStatement(MentalParser.ExpressionStatementContext ctx) { }
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
	@Override public void enterLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx) { }
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
	@Override public void enterADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_NOT_EXPRESSION(MentalParser.BIT_NOT_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_NOT_EXPRESSION(MentalParser.BIT_NOT_EXPRESSIONContext ctx) { }
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
	@Override public void enterINT_LITERAL(MentalParser.INT_LITERALContext ctx) { }
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
	@Override public void enterIDENTIFIER(MentalParser.IDENTIFIERContext ctx) { }
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
	@Override public void enterSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx) { }
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
	@Override public void enterREFERENCE_EXPRESSION(MentalParser.REFERENCE_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitREFERENCE_EXPRESSION(MentalParser.REFERENCE_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNULL(MentalParser.NULLContext ctx) { }
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
	@Override public void enterTRUE(MentalParser.TRUEContext ctx) { }
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
	@Override public void enterBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterARRAY_SUBSCRIPTING_EXPRESSION(MentalParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitARRAY_SUBSCRIPTING_EXPRESSION(MentalParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSUBGROUP_EXPRESSION(MentalParser.SUBGROUP_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSUBGROUP_EXPRESSION(MentalParser.SUBGROUP_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSTRING_LITERAL(MentalParser.STRING_LITERALContext ctx) { }
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
	@Override public void enterFALSE(MentalParser.FALSEContext ctx) { }
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
	@Override public void enterUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx) { }
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
	@Override public void visitErrorNode(ErrorNode node) { }
}
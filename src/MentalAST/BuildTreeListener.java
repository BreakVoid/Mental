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

import java.util.HashMap;
import java.util.LinkedList;

public class BuildTreeListener extends MentalBaseListener {
    /**
     * Initialize the listener
     */
    public boolean existError;                                      // record whether there is any error in the program.
	public HashMap<ParseTree, AstBaseNode> tree;                    // a K-V map used in building my abstract syntax tree.
	public SymbolTable curSymbolTable;                              // the symbol table in current scope.
	public LinkedList<SymbolTable> symbolTableList;                 // list of different stack scope

	public BuildTreeListener() {
        this.existError = false;
		this.tree = new HashMap<>();
		this.symbolTableList = new LinkedList<>();
		this.symbolTableList.add(new SymbolTable());
		this.curSymbolTable = this.symbolTableList.getLast();
	}
    public boolean checkMain() {
        if (this.curSymbolTable.getSymbol("main") == null) {
            System.err.println("fatal: the function `main` is undefined.");
            return false;
        } else {
            SymbolFunction functionMain = (SymbolFunction) this.curSymbolTable.getSymbol("main");
            if (functionMain.returnType.equals(SymbolTable.mentalInt)) {
                if (functionMain.parameterType == null || functionMain.parameterType.size() == 0) {
                    return true;
                }
            }
            System.err.println("fatal: the format of `main` is incorrect.\n\t"
                    + "expects: int main()\n\t"
                    + "occurs:  " + functionMain.toString().substring(10)
            );
            return false;
        }
    }
    /**
     * make a copy of current scope and increase the stack label.
     */
	public void beginScope() {
		this.symbolTableList.add(new SymbolTable(curSymbolTable));
		this.curSymbolTable = this.symbolTableList.getLast();
		this.curSymbolTable.stackLayer++;
	}
    /**
     * remove the current scope and back the lastest one.
     */
	public void endScope() {
		this.symbolTableList.removeLast();
		this.curSymbolTable = this.symbolTableList.getLast();
	}
    @Override public void enterEveryRule(ParserRuleContext ctx) {
        if (this.existError) {
            System.exit(1);
        }
    }
    @Override public void exitEveryRule(ParserRuleContext ctx) {
        if (this.existError) {
            System.exit(1);
        }
    }
    @Override public void visitTerminal(TerminalNode node) { }
    @Override public void visitErrorNode(ErrorNode node) {
        System.err.println("fatal: there is an error in grammar analysis.");
        System.exit(1);
    }
    /**
     * function following do nothing because none of them have effect.
     */
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
    /**
     * iterate the child of program twice in this function.
     * first time
     *     get the name of all functions and classes and allocate a space in symbol table for each one.
     * second time
     *     process the members of a class and the format of a function.
     */
	@Override public void enterProgram(MentalParser.ProgramContext ctx) {
        this.tree.put(ctx, new AstProgram());
        for (int i = 0, count = ctx.getChildCount(); i < count; ++i) {
            if (ctx.getChild(i) instanceof MentalParser.EmptyStatementContext) {
                continue;
            }
            if (ctx.getChild(i) instanceof MentalParser.DeclarationContext) {
                // class is declaration.
                MentalParser.DeclarationContext declarationContext = (MentalParser.DeclarationContext) ctx.getChild(i);
                if (declarationContext.classDeclaration() != null) {
                    this.curSymbolTable.add(declarationContext.classDeclaration().className().getText(), new SymbolType());
                }
            } else if (ctx.getChild(i) instanceof MentalParser.DefinitionContext) {
                // variable and function is definition.
                MentalParser.DefinitionContext definitionContext = (MentalParser.DefinitionContext) ctx.getChild(i);
                if (definitionContext.functionDefinition() != null) {
                    // it is a function definition.
                    this.curSymbolTable.add(definitionContext.functionDefinition().functionName.getText(), new SymbolFunction());
                }
            }
        }
        for (int i = 0, count = ctx.getChildCount(); i < count; ++i) {
            if (ctx.getChild(i) instanceof MentalParser.EmptyStatementContext) {
                continue;
            }
            if (ctx.getChild(i) instanceof MentalParser.DefinitionContext) {
                MentalParser.DefinitionContext definitionContext = (MentalParser.DefinitionContext) ctx.getChild(i);
                if (definitionContext.functionDefinition() != null) {
                    MentalParser.FunctionDefinitionContext functionDefinitionContext = definitionContext.functionDefinition();
                    SymbolFunction symbolFunction = (SymbolFunction) this.curSymbolTable.getSymbol(functionDefinitionContext.functionName.getText());
                    // setFunction will process the basic message of a function
                    //     function name, type of return value, types of parameters.
                    // if there is anything wrong the function returns true.
                    if (symbolFunction.setFunction(this.curSymbolTable, functionDefinitionContext)) {
                        this.existError = true;
                    }
                }
            } else if (ctx.getChild(i) instanceof MentalParser.DeclarationContext) {
                MentalParser.DeclarationContext declarationContext = (MentalParser.DeclarationContext) ctx.getChild(i);
                if (declarationContext.classDeclaration() != null) {
                    MentalParser.ClassDeclarationContext classDeclaration = declarationContext.classDeclaration();
                    if (classDeclaration.className() != null) {
                        SymbolType symbolType = (SymbolType) this.curSymbolTable.getSymbol(classDeclaration.className().getText());
                        // setType will process the members of a class
                        //     name and type of each member.
                        // returns true if there is anything wrong.
                        if (symbolType.setType(this.curSymbolTable, classDeclaration)) {
                            this.existError = true;
                        }
                    }
                }
            }
        }
    }
	@Override public void exitProgram(MentalParser.ProgramContext ctx) {
		AstProgram program = (AstProgram) tree.get(ctx);
		for (int i = 0, count = ctx.getChildCount(); i < count; ++i) {
            if (ctx.getChild(i) instanceof MentalParser.EmptyStatementContext) {
                continue;
            }
            // connect the child to their parent.
            program.declarations.add(tree.get(ctx.getChild(i)));
		}
        if (!this.checkMain()) {
            this.existError = true;
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
            // just do the path compression.
            this.tree.put(ctx, tree.get(ctx.classDeclaration()));
            this.tree.get(ctx).parent = this.tree.get(ctx.parent);
        }
    }
	/**
	 * all the messages of a class have been got in enterProgram()
     *    so this function just build the AST for a class declaration from the message in the symbol table. 
	 */
	@Override public void enterClassDeclaration(MentalParser.ClassDeclarationContext ctx) {
		AstClassDeclaration classDeclaration = new AstClassDeclaration();
        classDeclaration.classDetail = (SymbolType) this.curSymbolTable.getSymbol(ctx.className().getText());
        this.tree.put(ctx, classDeclaration);
        if (ctx.variableDefinition() != null) {
            for (int i = 0, count = ctx.variableDefinition().size(); i < count; ++i) {
                MentalParser.VariableDefinitionContext variableDefinitionContext = ctx.variableDefinition(i);
                if (variableDefinitionContext.singleVariable() != null) {
                    for (int j = 0, varCount = variableDefinitionContext.singleVariable().size(); j < varCount; ++j) {
                        MentalParser.SingleVariableContext singleVariableContext = variableDefinitionContext.singleVariable(j);
                        if (singleVariableContext.expression() != null) {
                            System.err.println("warning: variable declaration in class declaration should not have initial value\n\t"
                                    + "which will ignored.:\n\t\t" + singleVariableContext.getText());
                        }
                    }
                }
            }
        }
	}
	@Override public void exitClassDeclaration(MentalParser.ClassDeclarationContext ctx) {	}
	/**
	 * there is no function declaration in this language,
     *     this pair of functions is for the furture support if function declaration is need.
	 */
	@Override public void enterFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	@Override public void exitFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx) { }
	/**
	 * compress the path on AST.
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
     * In my compiler, it is allowed to define several variables in a single variable definition.
     *     this pair of functions processes one variable in a variable definition.
     */
    @Override public void enterSingleVariable(MentalParser.SingleVariableContext ctx) {
        AstSingleVariableDeclaration singleVariableDeclaration = new AstSingleVariableDeclaration();
        this.tree.put(ctx, singleVariableDeclaration);
        AstVariableDeclaration variableDeclaration = null;
        if (ctx.parent != null && ctx.parent.parent instanceof MentalParser.ClassDeclarationContext) {
            // the parent of this definition is a class declaration, so the message of this statement is useless
            return ;
        }
        if (ctx.parent instanceof MentalParser.VariableDefinitionContext) {
            // the type is contained in its parent, and the node of its parent is in the map.
            variableDeclaration = (AstVariableDeclaration) this.tree.get(ctx.parent);
        } else {
            System.err.println("unknown exception.");
            this.existError = true;
        }
        // new a node.
        singleVariableDeclaration.variable = new AstVariable();
        // get the name of the variable.
        singleVariableDeclaration.variable.variableName = ctx.Identifier().getText();
        // set the type of the variable.
        singleVariableDeclaration.variable.variableType = variableDeclaration.variableType;
    }
    @Override public void exitSingleVariable(MentalParser.SingleVariableContext ctx) {
        /**
         * this function mainly process the initializing expression of a variable.
         */
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
            this.existError = true;
        }
        singleVariableDeclaration.parent = this.tree.get(ctx.parent);
    }
    /**
	 * process a sentence of variable definition, which may define several variable.
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
	 * build the ast of a function.
	 */
	@Override public void enterFunctionDefinition(MentalParser.FunctionDefinitionContext ctx) {
        if (ctx.parent instanceof MentalParser.ClassDeclarationContext) {
            return;
        }
		this.beginScope();
        AstFunctionDefinition functionDefinition = new AstFunctionDefinition();
        functionDefinition.functionHead = (SymbolFunction) this.curSymbolTable.getSymbol(ctx.functionName.getText());
        // I think the name of itself cannot be redefine in the function.
        functionDefinition.functionHead.stackLayer = SymbolTable.maxLayer;
        // add the parameters to the scope.
        this.tree.put(ctx, functionDefinition);
        for (int i = 0, count = functionDefinition.functionHead.parameterName.size(); i < count; ++i) {
            this.curSymbolTable.add(
                    functionDefinition.functionHead.parameterName.get(i),
                    new SymbolVariable(
                            this.curSymbolTable,
                            functionDefinition.functionHead.parameterType.get(i),
                            functionDefinition.functionHead.parameterName.get(i)
                    )
            );
        }
	}
	@Override public void exitFunctionDefinition(MentalParser.FunctionDefinitionContext ctx) {
        if (ctx.parent instanceof MentalParser.ClassDeclarationContext) {
            // for furture support of member method.
            return;
        }

        this.endScope();
        // connect the tree node.
        AstFunctionDefinition functionDefinition = (AstFunctionDefinition) this.tree.get(ctx);
        functionDefinition.functionBody = (AstCompoundStatement) this.tree.get(ctx.compoundStatement());
        functionDefinition.parent = this.tree.get(ctx.parent);
        functionDefinition.functionBody.parent = functionDefinition;
    }
	/**
	 * just a C-style union of statements
	 */
	@Override public void enterStatement(MentalParser.StatementContext ctx) {
        if (ctx.parent instanceof MentalParser.ForStatementContext
                || ctx.parent instanceof MentalParser.WhileStatementContext
                || ctx.parent instanceof MentalParser.IfStatementContext
                || ctx.parent instanceof MentalParser.IfElseStatementContext) {
            this.beginScope();
        }
        if (ctx.variableDefinition() != null) {
            AstVarStatement varStatement = new AstVarStatement();
            this.tree.put(ctx, varStatement);
        }
    }
	@Override public void exitStatement(MentalParser.StatementContext ctx) {
        // compress the path
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
        } else if (ctx.expressionStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.expressionStatement()));
        } else if (ctx.forStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.forStatement()));
        } else if (ctx.whileStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.whileStatement()));
        } else if (ctx.jumpStatement() != null) {
            this.tree.put(ctx, this.tree.get(ctx.jumpStatement()));
        }
        // connect its parent link
        if (this.tree.get(ctx) != null) {
            this.tree.get(ctx).parent = this.tree.get(ctx.parent);
        } else {
            System.err.println("fatal: unknown statement.");
            this.existError = true;
        }
        if (ctx.parent instanceof MentalParser.ForStatementContext
                || ctx.parent instanceof MentalParser.WhileStatementContext
                || ctx.parent instanceof MentalParser.IfStatementContext
                || ctx.parent instanceof MentalParser.IfElseStatementContext) {
            this.endScope();
        }
    }
    /**
     * build tree of a compound statement
     * new a scope if it is not the function body.
     */
    @Override public void enterCompoundStatement(MentalParser.CompoundStatementContext ctx) {
        // new a scope if it is not the function body.
        if (!(ctx.parent instanceof MentalParser.FunctionDefinitionContext)) {
            if (ctx.parent instanceof MentalParser.StatementContext
                    && !(
                        ctx.parent.parent instanceof MentalParser.ForStatementContext
                        || ctx.parent.parent instanceof MentalParser.WhileStatementContext
                        || ctx.parent.parent instanceof MentalParser.IfStatementContext
                        || ctx.parent.parent instanceof MentalParser.IfElseStatementContext
                        )
                    ) {
                this.beginScope();
            }
        }
        AstCompoundStatement componentStatement = new AstCompoundStatement();
        this.tree.put(ctx, componentStatement);
    }
    @Override public void exitCompoundStatement(MentalParser.CompoundStatementContext ctx) {
        if (!(ctx.parent instanceof MentalParser.FunctionDefinitionContext)) {
            if (ctx.parent instanceof MentalParser.StatementContext
                    && !(
                    ctx.parent.parent instanceof MentalParser.ForStatementContext
                            || ctx.parent.parent instanceof MentalParser.WhileStatementContext
                            || ctx.parent.parent instanceof MentalParser.IfStatementContext
                            || ctx.parent.parent instanceof MentalParser.IfElseStatementContext
            )
                    ) {
                this.endScope();
            }
        }
        AstCompoundStatement thisStatement = (AstCompoundStatement) this.tree.get(ctx);
        // it is not necessary to set the parent of children, it will be done in the exitStatement().
        for (MentalParser.StatementContext statementContext : ctx.statement()) {
            thisStatement.statements.add(this.tree.get(statementContext));
        }
        thisStatement.parent = this.tree.get(ctx.parent);
    }
    /**
     * empty statement
     */
	@Override public void enterEmptyStatement(MentalParser.EmptyStatementContext ctx) {
        AstEmptyStatement emptyStatement = new AstEmptyStatement();
        this.tree.put(ctx, emptyStatement);
    }
	@Override public void exitEmptyStatement(MentalParser.EmptyStatementContext ctx) { }
	/**
	 * process `if (expression) statement`
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
            System.err.println("fatal: the condition of if-statement is not boolean.\n\t"
                    + ctx.expression().getText() + "@" + thisStatement.condition.returnType.toString()
            );
            this.existError = true;
        }
    }
	/**
	 * process `if (expression) statement else statement`
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
            this.existError = true;
        }
    }
	/**
	 * for statement
     * for (start?; cond?; loop) loopBody
	 */
	@Override public void enterForStatement(MentalParser.ForStatementContext ctx) {
        AstForStatement forStatement = new AstForStatement();
        this.tree.put(ctx, forStatement);
    }
	@Override public void exitForStatement(MentalParser.ForStatementContext ctx) {
        AstForStatement thisStatement = (AstForStatement) this.tree.get(ctx);
        if (ctx.start != null) {
            thisStatement.start = (AstExpression) this.tree.get(ctx.start);
            thisStatement.start.parent = thisStatement;
        }
        if (ctx.cond != null) {
            thisStatement.cond = (AstExpression) this.tree.get(ctx.cond);
        } else {
            thisStatement.cond = new AstBoolConstant();
            ((AstBoolConstant) thisStatement.cond).boolConstant = true;
        }
        thisStatement.cond.parent = thisStatement;
        if (ctx.loop != null) {
            thisStatement.loop = (AstExpression) this.tree.get(ctx.loop);
            thisStatement.loop.parent = thisStatement;
        }
        thisStatement.loopBody = (AstStatement) this.tree.get(ctx.statement());
        thisStatement.loopBody.parent = thisStatement;
        if (!thisStatement.cond.returnType.equals(SymbolTable.mentalBool)) {
            System.err.println("fatal: the loop condition of for statement does not return boolean.\n\t"
                    + ctx.cond.getText() + "@" + thisStatement.cond.returnType.toString()
            );
            this.existError = true;
        }
    }
	/**
	 * while statement
     * while (cond) loopBody
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
            System.err.println("fatal: the loop condition of for statement does not return boolean.\n\t"
                    + ctx.cond.getText() + "@" + thisStatement.cond.returnType.toString()
            );
            this.existError = true;
        }
    }
	/**
	 * return expression;
     * continue;
     * break;
	 */
	@Override public void enterJumpStatement(MentalParser.JumpStatementContext ctx) {
        AstJumpStatement jumpStatement = new AstJumpStatement();
        if (ctx.expression() == null) {
            if (ctx.getText().equals("continue;")) {
                jumpStatement.variant = AstJumpStatement.CONTINUE;
            } else if (ctx.getText().equals("break;")) {
                jumpStatement.variant = AstJumpStatement.BREAK;
            } else if (ctx.getText().equals("return;")) {
                jumpStatement.variant = AstJumpStatement.RETURN;
            }
        } else {
            jumpStatement.variant = AstJumpStatement.RETURN;
        }
        this.tree.put(ctx, jumpStatement);
    }
	@Override public void exitJumpStatement(MentalParser.JumpStatementContext ctx) {
        AstJumpStatement thisStatement = (AstJumpStatement) this.tree.get(ctx);
        if (thisStatement.variant == AstJumpStatement.BREAK || thisStatement.variant == AstJumpStatement.CONTINUE) {
            // continue and break are not allowed out of loop statement.
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
            if (ctx.expression() != null) {
                thisStatement.returnExpression = (AstExpression) this.tree.get(ctx.expression());
                thisStatement.returnExpression.parent = thisStatement;
            } else {
                thisStatement.returnExpression = new AstExpression();
                thisStatement.returnExpression.returnType = SymbolTable.mentalVoid;
                thisStatement.returnExpression.parent = thisStatement;
            }
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
                    this.existError = true;
                }
            }
        }
        System.err.println("fatal: a illegal jump statement.\n\t" + ctx.getText());
        this.existError = true;
    }
	/**
	 * expression statement
     *     most important one is `a=b;`
	 */
	@Override public void enterExpressionStatement(MentalParser.ExpressionStatementContext ctx) { }
	@Override public void exitExpressionStatement(MentalParser.ExpressionStatementContext ctx) {
        AstExpressionStatement expressionStatement = new AstExpressionStatement();
        expressionStatement.expression = (AstExpression) this.tree.get(ctx.expression());
        this.tree.put(ctx, expressionStatement);
    }
	
	/**
	 * !a
     * a should be boolean.
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
            System.err.println("fatal: try to apply logical-not-operator on a no-boolean item.\n\t" + ctx.getText());
            this.existError = true;
        }
    }
	/**
	 * a.b 
     * a shouble be a class for member access 
     *     or a array for array.size() 
     *     or some other string method
	 */
	@Override public void enterMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) {
        AstMemberAccessExpression memberAccessExpression = new AstMemberAccessExpression();
        this.tree.put(ctx, memberAccessExpression);
    }
	@Override public void exitMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx) {
        AstMemberAccessExpression thisExpression = (AstMemberAccessExpression) this.tree.get(ctx);
        thisExpression.primaryExpression = (AstExpression) this.tree.get(ctx.expression());
        thisExpression.primaryExpression.parent = thisExpression;
        if (ctx.functionCall() != null) {
            // this member access expression is a internal method call
            // the the function call message from functionCall context.
            AstFunctionCall functionCall = (AstFunctionCall) this.tree.get(ctx.functionCall());
            if (ctx.functionCall().functionName.getText().equals("length")) {
                // it may be string.length()
                if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                    thisExpression.memberExpression = new AstCallLength();
                    thisExpression.memberExpression.parent = thisExpression;
                    thisExpression.returnType = SymbolTable.mentalInt;
                    if (functionCall.parameters.expressions.size() != 0) {
                        System.err.println("fatal: the number of parameters of string.length is wrong.\n\t" + ctx.functionCall().getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: try to apply length() method on other type.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (ctx.functionCall().functionName.getText().equals("substring")) {
                // it may be string.substring(left, right)
                //     both left and right should be int.
                if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                    thisExpression.memberExpression = new AstCallSubString();
                    thisExpression.memberExpression.parent = thisExpression;
                    thisExpression.returnType = SymbolTable.mentalString;
                    if (functionCall.parameters.expressions.size() == 2) {
                        ((AstCallSubString) thisExpression.memberExpression).leftExpression = functionCall.parameters.expressions.get(0);
                        ((AstCallSubString) thisExpression.memberExpression).rightExpression = functionCall.parameters.expressions.get(1);
                        if (!((AstCallSubString) thisExpression.memberExpression).leftExpression.returnType.equals(SymbolTable.mentalInt)) {
                            System.err.println("fatal: the type of the first parameter of string.substring is not int.\n\t" + ctx.functionCall().getText());
                        }
                        if (!((AstCallSubString) thisExpression.memberExpression).rightExpression.returnType.equals(SymbolTable.mentalInt)) {
                            System.err.println("fatal: the type of the second parameter of string.substring is not int.\n\t" + ctx.functionCall().getText());
                        }
                    } else {
                        System.err.println("fatal: the number of parameters of string.substring is wrong.\n\t" + ctx.functionCall().getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: try to apply substring(int, int) method on other type.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (ctx.functionCall().functionName.getText().equals("ord")) {
                // it may be a string.ord(index)
                //     index should be int. 
                if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                    thisExpression.memberExpression = new AstCallOrd();
                    thisExpression.memberExpression.parent = thisExpression;
                    thisExpression.returnType = SymbolTable.mentalInt;
                    if (functionCall.parameters.expressions.size() == 1) {
                        ((AstCallOrd) thisExpression.memberExpression).childExpression = functionCall.parameters.expressions.get(0);
                        if (!((AstCallOrd) thisExpression.memberExpression).childExpression.returnType.equals(SymbolTable.mentalInt)) {
                            System.err.println("fatal: the type of the parameter of string.ord is not int.\n\t" + ctx.functionCall().getText());
                        }
                    } else {
                        System.err.println("fatal: the number of parameters of string.ord is wrong.\n\t" + ctx.functionCall().getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: try to apply ord(int) method on other type except string.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (ctx.functionCall().functionName.getText().equals("parseInt")) {
                // it may be a string.parseInt()
                if (thisExpression.primaryExpression.returnType instanceof MentalString) {
                    thisExpression.memberExpression = new AstCallParseInt();
                    thisExpression.memberExpression.parent = thisExpression;
                    thisExpression.returnType = SymbolTable.mentalInt;
                    if (functionCall.parameters.expressions.size() != 0) {
                        System.err.println("fatal: the number of parameters of string.parseInt is wrong.\n\t" + ctx.functionCall().getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: try to apply parseInt() method on other type except string.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (ctx.functionCall().functionName.getText().equals("size")) {
                // it may be a array.size()
                if (thisExpression.primaryExpression.returnType instanceof MentalArray) {
                    thisExpression.memberExpression = new AstCallSize();
                    thisExpression.memberExpression.parent = thisExpression;
                    thisExpression.returnType = SymbolTable.mentalInt;
                    if (functionCall.parameters.expressions.size() != 0) {
                        System.err.println("fatal: the number of parameters of array.size is wrong.\n\t" + ctx.functionCall().getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: try to apply size() method on other type except array.\n\t" + ctx.getText());
                    this.existError = true;
                }
            }
        } else {
            // it is a member access.
            thisExpression.memberExpression = null;
            thisExpression.memberName = ctx.Identifier().getText();
            if (thisExpression.primaryExpression.returnType instanceof MentalClass) {
                // the primary expression is not a class.
                MentalClass thisClass = (MentalClass) thisExpression.primaryExpression.returnType;
                if (thisClass.classComponents.get(thisExpression.memberName) != null) {
                    thisExpression.leftValue = thisExpression.primaryExpression.leftValue;
                    thisExpression.returnType = thisClass.classComponents.get(thisExpression.memberName);
                } else {
                    System.err.println("fatal: the class `" + thisClass.className
                            + "` does not have the member `" + thisExpression.memberName + "`."
                    );
                    this.existError = true;
                }
            } else {
                System.err.println("fatal: " + ctx.expression().getText() + "is not a class. ");
                this.existError = true;
            }
        }
    }
	/**
	 * process function call.
	 */
	@Override public void enterFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) {
        AstFunctionCall functionCall = new AstFunctionCall();
        this.tree.put(ctx, functionCall);
        String functionName = ctx.functionCall().functionName.getText();
        functionCall.functionName = functionName;
        if (functionName.equals("print")
                || functionName.equals("println")
                || functionName.equals("getInt")
                || functionName.equals("getString")
                || functionName.equals("toString")) {
            // internal functions are not in symbol table.
            // it will produce an error if find them in the symbol table.
            return ;
        }
        // get the message of the function
        //     function name, parameters' type, set the return value of this call.
        SymbolBase symbol = this.curSymbolTable.getSymbol(functionName);
        if (symbol != null) {
             if (symbol instanceof SymbolFunction) {
                 functionCall.functionHead = (SymbolFunction) symbol;
                 functionCall.returnType = functionCall.functionHead.returnType;
             } else {
                 System.err.println("fatal: the symbol `" + functionName + "` is not a function.");
                 this.existError = true;
             }
        } else {
            System.err.println("fatal: the symbol `" + functionName + "` is not defined.");
            this.existError = true;
        }
    }
	@Override public void exitFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx) {
        AstFunctionCall thisCall = (AstFunctionCall) this.tree.get(ctx);
        String functionName = thisCall.functionName;
        if (ctx.functionCall().expressionList() != null) {
            thisCall.parameters = (AstExpressionList) this.tree.get(ctx.functionCall().expressionList());
        } else {
            thisCall.parameters = new AstExpressionList();
        }
        if (functionName.equals("print")
                || functionName.equals("println")
                || functionName.equals("getInt")
                || functionName.equals("getString")
                || functionName.equals("toString")) {
            // it is an internal function call
            //     and the node of this function call will be replaced by an internal function call node.
            if (functionName.equals("print")) {
                // may be print(str)
                if (thisCall.parameters.expressions.size() == 1) {
                    if (thisCall.parameters.expressions.get(0).returnType.equals(SymbolTable.mentalString)) {
                        AstCallPrint callPrint = new AstCallPrint();
                        callPrint.parameter = thisCall.parameters.expressions.get(0);
                        callPrint.parameter.parent = callPrint;
                        this.tree.replace(ctx, callPrint);
                    } else {
                        System.err.println("fatal: print only accept string as parameter.\n\t" + ctx.getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: the number of parameters of print(str) is wrong.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (functionName.equals("println")) {
                // may be println(str)
                if (thisCall.parameters.expressions.size() == 1) {
                    if (thisCall.parameters.expressions.get(0).returnType.equals(SymbolTable.mentalString)) {
                        AstCallPrintln callPrintln = new AstCallPrintln();
                        callPrintln.parameter = thisCall.parameters.expressions.get(0);
                        callPrintln.parameter.parent = callPrintln;
                        this.tree.replace(ctx, callPrintln);
                    } else {
                        System.err.println("fatal: println only accept string as parameter.\n\t" + ctx.getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: the number of parameters of println(str) is wrong.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (functionName.equals("getInt")) {
                // may be getInt()
                if (thisCall.parameters.expressions.size() == 0) {
                    AstCallGetInt callGetInt = new AstCallGetInt();
                    this.tree.replace(ctx, callGetInt);
                } else {
                    System.err.println("fatal: getInt() accepts no parameter.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (functionName.equals("getString")) {
                // may be getString()
                if (thisCall.parameters.expressions.size() == 0) {
                    AstCallGetString callGetString = new AstCallGetString();
                    this.tree.replace(ctx, callGetString);
                } else {
                    System.err.println("fatal: getString() accepts no parameter.\n\t" + ctx.getText());
                    this.existError = true;
                }
            } else if (functionName.equals("toString")) {
                // may be toString(int)
                if (thisCall.parameters.expressions.size() == 1) {
                    if (thisCall.parameters.expressions.get(0).returnType.equals(SymbolTable.mentalInt)) {
                        AstCallToString callToString = new AstCallToString();
                        callToString.childExpression = thisCall.parameters.expressions.get(0);
                        callToString.childExpression.parent = callToString;
                        this.tree.replace(ctx, callToString);
                    } else {
                        System.err.println("fatal: toString only accepts int as parameter.\n\t" + ctx.getText());
                        this.existError = true;
                    }
                } else {
                    System.err.println("fatal: the number of parameters of toString(int) is wrong.\n\t" + ctx.getText());
                    this.existError = true;
                }
            }
            return ;
        }
        thisCall.parameters.parent = thisCall;
        if (thisCall.functionHead == null) {
            return;
        }
        if (thisCall.functionHead.parameterType != null) {
            if (thisCall.functionHead.parameterType.size() == thisCall.parameters.expressions.size()) {
                for (int i = 0, count = thisCall.functionHead.parameterType.size(); i < count; ++i) {
                    if (!thisCall.functionHead.parameterType.get(i).equals(thisCall.parameters.expressions.get(i).returnType)) {
                        System.err.println("fatal: the type of " + Integer.toString(i) + "-th parameter mismatched. "
                                + "\n\t expected " + thisCall.functionHead.parameterType.get(i).toString()
                                + "\n\t occurs " + thisCall.parameters.expressions.get(i).returnType.toString()
                        );
                        this.existError = true;
                    }
                }
            } else {
                System.err.println("fatal: the function call of `" + functionName
                        + "` has a wrong number of parameters.\n"
                        + "\t expected " + Integer.toString(thisCall.functionHead.parameterType.size())
                        + "\n\t occurs " + Integer.toString(thisCall.parameters.expressions.size())
                        + "\n\t\t with context: " + ctx.getText()
                );
                this.existError = true;
            }
        }
    }
    /**
     * x = y
     * x, y should be the same type.
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
            System.err.println("fatal: the left side of operator= cannot be a left-value.\n\t" + ctx.getText());
            this.existError = true;
        } else {
            if (!thisExpression.leftExpression.returnType.equals(thisExpression.rightExpression.returnType)) {
                System.err.println("fatal: the types of both sides of operator= are different.\n"
                        + "\t left side: " + thisExpression.leftExpression.returnType + "\n"
                        + "\tright side: " + thisExpression.rightExpression.returnType
                );
                this.existError = true;
            } else {
                thisExpression.returnType = thisExpression.leftExpression.returnType;
            }
        }
    }
	/**
	 * new type ([int])* ([])*
	 */
	@Override public void enterCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx) {
        AstCreationExpression creationExpression = new AstCreationExpression();
		SymbolType type = (SymbolType) this.curSymbolTable.getSymbol(ctx.typeName().getText());
		if ((ctx.expression() == null || ctx.expression().size() == 0)
                && (ctx.array() == null || ctx.array().size() == 0)) {
			creationExpression.returnType = type.type;
            creationExpression.baseType = type.type;
			creationExpression.expressionList = null;

            if (creationExpression.returnType.equals(SymbolTable.mentalInt)
                    || creationExpression.returnType.equals(SymbolTable.mentalBool)
                    || creationExpression.returnType.equals(SymbolTable.mentalString)
                    ) {
                System.err.println("fatal: new a object of basic type is unaccepted.\n\t" + ctx.getText());
                this.existError = true;
            }
		} else {
			creationExpression.returnType = new MentalArray();
            creationExpression.baseType = type.type;
            creationExpression.resultDim = ctx.expression().size() + ctx.array().size();
            creationExpression.determinedDim = ctx.expression().size();
			((MentalArray) creationExpression.returnType).arrayType = type.type;
			((MentalArray) creationExpression.returnType).arrayDim = creationExpression.resultDim;
            if (creationExpression.determinedDim == 0) {
                System.err.println("warning: this new expression does nothing.\n\t" + ctx.toStringTree(new MentalParser(null)));
            }
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
                    System.err.println("fatal: new an array with no-int size.\n\t" + ctx.expression(i).getText());
                    this.existError = true;
                } else {
                    if (childExpression instanceof AstIntLiteral) {
                        if (((AstIntLiteral) childExpression).literalContext <= 0) {
                            System.err.println("fatal: new an array with negative size.\n\t" + ctx.expression(i).getText());
                            this.existError = true;
                        }
                    }
                }
				thisExpression.expressionList.add(childExpression);
			}
		}
    }
    /**
     * x++, x--
     * x should be a left-value, and int
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
            System.err.println("fatal: try to apply suffix (inc/dec)reasement on a no-leftvalue.\n\t" + ctx.expression().getText());
            this.existError = true;
        } else {
            if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalInt)) {
                System.err.println("fatal: try to apply suffix (inc/dec)reasement on a no-digit.\n\t" + ctx.expression().getText());
                this.existError = true;
            }
        }
    }
    /**
     * ++x, --x
     * x should be left-value and int.
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
            System.err.println("fatal: try to apply a prefix inc/dec on a non-left-value.\n\t" + ctx.getText());
            this.existError = true;
        } else {
            if (!thisExpression.childExpression.returnType.equals(SymbolTable.mentalInt)) {
                System.err.println("fatal: try to apply a prefix inc/dec on a no-integer.\n\t" + ctx.getText());
                this.existError = true;
            }
        }
    }
    /**
     * +x, -x
     * x should be int.
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
            System.err.println("fatal: try to apply unary plus/minus on a no-int type.\n\t" + ctx.getText());
            this.existError = true;
        } else {
            if (childExpression instanceof AstIntLiteral) {
                if (thisExpression.op == AstUnaryAdditiveExpression.ADD) {
                    AstIntLiteral newIntLiteral = new AstIntLiteral();
                    newIntLiteral.literalContext = +((AstIntLiteral) childExpression).literalContext;
                    this.tree.replace(ctx, newIntLiteral);
                } else if (thisExpression.op == AstUnaryAdditiveExpression.SUB) {
                    AstIntLiteral newIntLiteral = new AstIntLiteral();
                    newIntLiteral.literalContext = -((AstIntLiteral) childExpression).literalContext;
                    this.tree.replace(ctx, newIntLiteral);
                }
            }
        }
    }
    /**
     * x + y, x - y, str1 + str2
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
        System.err.println("fatal: the types of additive expression cannot accept. \n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * x * y, x / y, x % y
     * x, y should be int.
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
        System.err.println("fatal: the types of multiply/divide expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * x << y, x >> y
     * x, y should be int.
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
        System.err.println("fatal: the types of bit-shift expression cannnot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * x & y
     * x, y should be int
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
        System.err.println("fatal: the types of sides of bit-and expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * x | y
     * x, y should be int.
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
        System.err.println("fatal: the types of bit-or expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * a ^ b
     * both a, b should be int.
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
        System.err.println("fatal: the types of bit-xor expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
	/**
	 * ~x
     * x should be a int
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
            System.err.println("fatal: try to apply bit-not-operator on a no-integer item.\n\t" + ctx.getText());
            this.existError = true;
        }
    }
	/**
	 * a < b, a <= b, a > b, a >= b
     *  a, b may both be int or string.
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
        this.existError = true;
    }
	/**
	 * a == b, a != b
     * a, b should be the same type.
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
        System.err.println(thisExpression.leftExpression.toPrintString());
        System.err.println(thisExpression.rightExpression.toPrintString());
        System.err.println("fatal: the types of equality expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
	/**
	 * use a variable such as "x", "y" in "x = y"
	 */
	@Override public void enterIDENTIFIER(MentalParser.IDENTIFIERContext ctx) {
        AstIdentifier identifier = new AstIdentifier();
        identifier.name = ctx.Identifier().getText();
        if (this.curSymbolTable.getSymbol(identifier.name) == null) {
            System.err.println("fatal: undefined identifier.\n\t" + ctx.Identifier());
            this.existError = true;
        } else {
            SymbolBase base = this.curSymbolTable.getSymbol(identifier.name);
            if (base instanceof SymbolVariable) {
                identifier.returnType = ((SymbolVariable) base).variableType;
                identifier.leftValue = true;
            } else if (base instanceof SymbolFunction) {
                identifier.returnType = new MentalFunction();
                ((MentalFunction) identifier.returnType).functionHead = (SymbolFunction) base;
            } else {
                System.err.println("fatal: the identifier is a type.\n\t" + identifier.name);
                this.existError = true;
            }
        }
        this.tree.put(ctx, identifier);
    }
	@Override public void exitIDENTIFIER(MentalParser.IDENTIFIERContext ctx) { }
	/**
	 * null
	 */
	@Override public void enterNULL(MentalParser.NULLContext ctx) {
		this.tree.put(ctx, new AstNullConstant());
	}
	@Override public void exitNULL(MentalParser.NULLContext ctx) { }
	/**
	 * x && y
     * x, y should be boolean.
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
        System.err.println("fatal: the types of logical-and expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
    /**
     * x || y
     * x, y should be boolean.
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
        System.err.println("fatal: the types of logical-or expression cannot accept.\n\t" + ctx.getText());
        this.existError = true;
    }
	/**
	 * x[i]
     * x should be a array, i should be a int.
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
                thisExpression.leftValue = thisExpression.primaryExpression.leftValue;
            } else {
                System.err.println("fatal: the result of position expression is not a integer.\n\t" + ctx.getText());
                this.existError = true;
            }
        } else {
            System.err.println("fatal: the result of primary expression is not a array.\n\t" + ctx.getText());
            this.existError = true;
        }
    }
	/**
	 * (expression)
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
        thisExpression.leftValue = thisExpression.childExpression.leftValue;
    }
    /**
     * int literal
     * 12212, 124213, ...
     */
    @Override public void enterINT_LITERAL(MentalParser.INT_LITERALContext ctx) {
        AstIntLiteral intLiteral = new AstIntLiteral();
        intLiteral.literalContext = Integer.parseInt(ctx.getText());
        this.tree.put(ctx, intLiteral);
    }
    @Override public void exitINT_LITERAL(MentalParser.INT_LITERALContext ctx) { }
	/**
	 * string literal
	 */
	@Override public void enterSTRING_LITERAL(MentalParser.STRING_LITERALContext ctx) {
        AstStringLiteral stringLiteral = new AstStringLiteral();
        stringLiteral.literalContext = ctx.getText();
        this.tree.put(ctx, stringLiteral);
    }
	@Override public void exitSTRING_LITERAL(MentalParser.STRING_LITERALContext ctx) { }
    /**
     * true
     */
    @Override public void enterTRUE(MentalParser.TRUEContext ctx) {
        AstBoolConstant node = new AstBoolConstant();
        node.boolConstant = true;
        this.tree.put(ctx, node);
    }
    @Override public void exitTRUE(MentalParser.TRUEContext ctx) { }
	/**
	 * false
	 */
	@Override public void enterFALSE(MentalParser.FALSEContext ctx) {
        AstBoolConstant node = new AstBoolConstant();
        node.boolConstant = false;
        this.tree.put(ctx, node);
    }
	@Override public void exitFALSE(MentalParser.FALSEContext ctx) { }
    /**
     * function call
     *     only for member access expression
     *     FUNCTION_CALL expression will process in itself.
     */
    @Override public void enterFunctionCall(MentalParser.FunctionCallContext ctx) {
        if (ctx.parent instanceof MentalParser.FUNCTION_CALLContext) {
            return;
        }
        AstFunctionCall functionCall = new AstFunctionCall();
        functionCall.functionName = ctx.functionName.getText();
        this.tree.put(ctx, functionCall);
    }
    @Override public void exitFunctionCall(MentalParser.FunctionCallContext ctx) {
        if (ctx.parent instanceof MentalParser.FUNCTION_CALLContext) {
            return;
        }
        AstFunctionCall thisCall = (AstFunctionCall) this.tree.get(ctx);
        if (ctx.expressionList() != null) {
            thisCall.parameters = (AstExpressionList) this.tree.get(ctx.expressionList());
        } else {
            thisCall.parameters = new AstExpressionList();
        }
        thisCall.parameters.parent = thisCall;
    }
    /**
	 * which will transmit to a function call.
	 */
	@Override public void enterExpressionList(MentalParser.ExpressionListContext ctx) {
        AstExpressionList expressionList = new AstExpressionList();
        this.tree.put(ctx, expressionList);
    }
	@Override public void exitExpressionList(MentalParser.ExpressionListContext ctx) {
        AstExpressionList thisList = (AstExpressionList) this.tree.get(ctx);
        for (int i = 0, count = ctx.expression().size(); i < count; ++i) {
            thisList.expressions.add((AstExpression) this.tree.get(ctx.expression(i)));
            thisList.expressions.get(i).parent = thisList;
        }
    }
}
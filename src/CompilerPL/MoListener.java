// Generated from /Users/Songyu/Projects/mo-compiler/src/CompilerPL/Mo.g4 by ANTLR 4.5.1
package CompilerPL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MoParser}.
 */
public interface MoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MoParser#originalType}.
	 * @param ctx the parse tree
	 */
	void enterOriginalType(MoParser.OriginalTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#originalType}.
	 * @param ctx the parse tree
	 */
	void exitOriginalType(MoParser.OriginalTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MoParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MoParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#paramtersList}.
	 * @param ctx the parse tree
	 */
	void enterParamtersList(MoParser.ParamtersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#paramtersList}.
	 * @param ctx the parse tree
	 */
	void exitParamtersList(MoParser.ParamtersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MoParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MoParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MoParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MoParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MoParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MoParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(MoParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(MoParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MoParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MoParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MoParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MoParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MoParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MoParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#callPrint}.
	 * @param ctx the parse tree
	 */
	void enterCallPrint(MoParser.CallPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#callPrint}.
	 * @param ctx the parse tree
	 */
	void exitCallPrint(MoParser.CallPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#callPrintln}.
	 * @param ctx the parse tree
	 */
	void enterCallPrintln(MoParser.CallPrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#callPrintln}.
	 * @param ctx the parse tree
	 */
	void exitCallPrintln(MoParser.CallPrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#callGetString}.
	 * @param ctx the parse tree
	 */
	void enterCallGetString(MoParser.CallGetStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#callGetString}.
	 * @param ctx the parse tree
	 */
	void exitCallGetString(MoParser.CallGetStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#callGetInt}.
	 * @param ctx the parse tree
	 */
	void enterCallGetInt(MoParser.CallGetIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#callGetInt}.
	 * @param ctx the parse tree
	 */
	void exitCallGetInt(MoParser.CallGetIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#callToString}.
	 * @param ctx the parse tree
	 */
	void enterCallToString(MoParser.CallToStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#callToString}.
	 * @param ctx the parse tree
	 */
	void exitCallToString(MoParser.CallToStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MoParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MoParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MoParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MoParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(MoParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(MoParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MoParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MoParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MoParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MoParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MoParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MoParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MoParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MoParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#leftValue}.
	 * @param ctx the parse tree
	 */
	void enterLeftValue(MoParser.LeftValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#leftValue}.
	 * @param ctx the parse tree
	 */
	void exitLeftValue(MoParser.LeftValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICAL_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLOGICAL_OR_EXPRESSION(MoParser.LOGICAL_OR_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICAL_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLOGICAL_OR_EXPRESSION(MoParser.LOGICAL_OR_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ASSIGN_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterASSIGN_EXPRESSION(MoParser.ASSIGN_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ASSIGN_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitASSIGN_EXPRESSION(MoParser.ASSIGN_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIT_XOR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBIT_XOR_EXPRESSION(MoParser.BIT_XOR_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIT_XOR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBIT_XOR_EXPRESSION(MoParser.BIT_XOR_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICAL_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLOGICAL_NOT_EXPRESSION(MoParser.LOGICAL_NOT_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICAL_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLOGICAL_NOT_EXPRESSION(MoParser.LOGICAL_NOT_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code REFERENCE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterREFERENCE_EXPRESSION(MoParser.REFERENCE_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code REFERENCE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitREFERENCE_EXPRESSION(MoParser.REFERENCE_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MEMBER_ACCESS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMEMBER_ACCESS_EXPRESSION(MoParser.MEMBER_ACCESS_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MEMBER_ACCESS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMEMBER_ACCESS_EXPRESSION(MoParser.MEMBER_ACCESS_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCTION_CALL}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFUNCTION_CALL(MoParser.FUNCTION_CALLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCTION_CALL}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFUNCTION_CALL(MoParser.FUNCTION_CALLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONSTANT}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCONSTANT(MoParser.CONSTANTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONSTANT}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCONSTANT(MoParser.CONSTANTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDITIVE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterADDITIVE_EXPRESSION(MoParser.ADDITIVE_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDITIVE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitADDITIVE_EXPRESSION(MoParser.ADDITIVE_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIT_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBIT_OR_EXPRESSION(MoParser.BIT_OR_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIT_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBIT_OR_EXPRESSION(MoParser.BIT_OR_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CREATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCREATION_EXPRESSION(MoParser.CREATION_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CREATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCREATION_EXPRESSION(MoParser.CREATION_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICAL_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLOGICAL_AND_EXPRESSION(MoParser.LOGICAL_AND_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICAL_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLOGICAL_AND_EXPRESSION(MoParser.LOGICAL_AND_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIT_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBIT_NOT_EXPRESSION(MoParser.BIT_NOT_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIT_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBIT_NOT_EXPRESSION(MoParser.BIT_NOT_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIT_SHIFT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBIT_SHIFT_EXPRESSION(MoParser.BIT_SHIFT_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIT_SHIFT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBIT_SHIFT_EXPRESSION(MoParser.BIT_SHIFT_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PREFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPREFIX_INC_DEC_EXPRESSION(MoParser.PREFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PREFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPREFIX_INC_DEC_EXPRESSION(MoParser.PREFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARRAY_SUBSCRIPTING_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterARRAY_SUBSCRIPTING_EXPRESSION(MoParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARRAY_SUBSCRIPTING_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitARRAY_SUBSCRIPTING_EXPRESSION(MoParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RELATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRELATION_EXPRESSION(MoParser.RELATION_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RELATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRELATION_EXPRESSION(MoParser.RELATION_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQUALITY_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEQUALITY_EXPRESSION(MoParser.EQUALITY_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQUALITY_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEQUALITY_EXPRESSION(MoParser.EQUALITY_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SUBGROUP_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSUBGROUP_EXPRESSION(MoParser.SUBGROUP_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SUBGROUP_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSUBGROUP_EXPRESSION(MoParser.SUBGROUP_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIT_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBIT_AND_EXPRESSION(MoParser.BIT_AND_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIT_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBIT_AND_EXPRESSION(MoParser.BIT_AND_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDENTIFIER}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIDENTIFIER(MoParser.IDENTIFIERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDENTIFIER}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIDENTIFIER(MoParser.IDENTIFIERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SUFFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSUFFIX_INC_DEC_EXPRESSION(MoParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SUFFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSUFFIX_INC_DEC_EXPRESSION(MoParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UNRAY_PLUS_MINUS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUNRAY_PLUS_MINUS_EXPRESSION(MoParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UNRAY_PLUS_MINUS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUNRAY_PLUS_MINUS_EXPRESSION(MoParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULTIPLY_DIVIDE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMULTIPLY_DIVIDE_EXPRESSION(MoParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULTIPLY_DIVIDE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMULTIPLY_DIVIDE_EXPRESSION(MoParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MoParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MoParser.ExpressionListContext ctx);
}
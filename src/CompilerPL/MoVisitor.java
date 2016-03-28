// Generated from /Users/Songyu/Projects/mo-compiler/src/CompilerPL/Mo.g4 by ANTLR 4.5.1
package CompilerPL;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MoParser#originalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOriginalType(MoParser.OriginalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MoParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#paramtersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamtersList(MoParser.ParamtersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MoParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MoParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MoParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(MoParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(MoParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MoParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MoParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#callPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallPrint(MoParser.CallPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#callPrintln}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallPrintln(MoParser.CallPrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#callGetString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallGetString(MoParser.CallGetStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#callGetInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallGetInt(MoParser.CallGetIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#callToString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallToString(MoParser.CallToStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MoParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MoParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(MoParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MoParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MoParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MoParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MoParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#leftValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftValue(MoParser.LeftValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_OR_EXPRESSION(MoParser.LOGICAL_OR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN_EXPRESSION(MoParser.ASSIGN_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_XOR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_XOR_EXPRESSION(MoParser.BIT_XOR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_NOT_EXPRESSION(MoParser.LOGICAL_NOT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code REFERENCE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREFERENCE_EXPRESSION(MoParser.REFERENCE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MEMBER_ACCESS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMEMBER_ACCESS_EXPRESSION(MoParser.MEMBER_ACCESS_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCTION_CALL}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCTION_CALL(MoParser.FUNCTION_CALLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONSTANT}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONSTANT(MoParser.CONSTANTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDITIVE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDITIVE_EXPRESSION(MoParser.ADDITIVE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_OR_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_OR_EXPRESSION(MoParser.BIT_OR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CREATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCREATION_EXPRESSION(MoParser.CREATION_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_AND_EXPRESSION(MoParser.LOGICAL_AND_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_NOT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_NOT_EXPRESSION(MoParser.BIT_NOT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_SHIFT_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_SHIFT_EXPRESSION(MoParser.BIT_SHIFT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PREFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPREFIX_INC_DEC_EXPRESSION(MoParser.PREFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_SUBSCRIPTING_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_SUBSCRIPTING_EXPRESSION(MoParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RELATION_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRELATION_EXPRESSION(MoParser.RELATION_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUALITY_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUALITY_EXPRESSION(MoParser.EQUALITY_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUBGROUP_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBGROUP_EXPRESSION(MoParser.SUBGROUP_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_AND_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_AND_EXPRESSION(MoParser.BIT_AND_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENTIFIER}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENTIFIER(MoParser.IDENTIFIERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUFFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUFFIX_INC_DEC_EXPRESSION(MoParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNRAY_PLUS_MINUS_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNRAY_PLUS_MINUS_EXPRESSION(MoParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULTIPLY_DIVIDE_EXPRESSION}
	 * labeled alternative in {@link MoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTIPLY_DIVIDE_EXPRESSION(MoParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by {@link MoParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MoParser.ExpressionListContext ctx);
}
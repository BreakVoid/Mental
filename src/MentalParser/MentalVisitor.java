// Generated from /Users/Songyu/Projects/Mental/src/MentalParser/Mental.g4 by ANTLR 4.5.1
package MentalParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MentalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MentalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MentalParser#originalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOriginalType(MentalParser.OriginalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MentalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#paramtersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamtersList(MentalParser.ParamtersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MentalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MentalParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MentalParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MentalParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(MentalParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(MentalParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MentalParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MentalParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MentalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#callPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallPrint(MentalParser.CallPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#callPrintln}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallPrintln(MentalParser.CallPrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#callGetString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallGetString(MentalParser.CallGetStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#callGetInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallGetInt(MentalParser.CallGetIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#callToString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallToString(MentalParser.CallToStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MentalParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MentalParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(MentalParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MentalParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MentalParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MentalParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MentalParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#leftValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftValue(MentalParser.LeftValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_OR_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_OR_EXPRESSION(MentalParser.LOGICAL_OR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN_EXPRESSION(MentalParser.ASSIGN_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_XOR_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_XOR_EXPRESSION(MentalParser.BIT_XOR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_NOT_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_NOT_EXPRESSION(MentalParser.LOGICAL_NOT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code REFERENCE_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREFERENCE_EXPRESSION(MentalParser.REFERENCE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MEMBER_ACCESS_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMEMBER_ACCESS_EXPRESSION(MentalParser.MEMBER_ACCESS_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCTION_CALL}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCTION_CALL(MentalParser.FUNCTION_CALLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONSTANT}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONSTANT(MentalParser.CONSTANTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDITIVE_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDITIVE_EXPRESSION(MentalParser.ADDITIVE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_OR_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_OR_EXPRESSION(MentalParser.BIT_OR_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CREATION_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCREATION_EXPRESSION(MentalParser.CREATION_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICAL_AND_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICAL_AND_EXPRESSION(MentalParser.LOGICAL_AND_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_NOT_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_NOT_EXPRESSION(MentalParser.BIT_NOT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_SHIFT_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_SHIFT_EXPRESSION(MentalParser.BIT_SHIFT_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PREFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPREFIX_INC_DEC_EXPRESSION(MentalParser.PREFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_SUBSCRIPTING_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_SUBSCRIPTING_EXPRESSION(MentalParser.ARRAY_SUBSCRIPTING_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RELATION_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRELATION_EXPRESSION(MentalParser.RELATION_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUALITY_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUALITY_EXPRESSION(MentalParser.EQUALITY_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUBGROUP_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBGROUP_EXPRESSION(MentalParser.SUBGROUP_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIT_AND_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIT_AND_EXPRESSION(MentalParser.BIT_AND_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENTIFIER}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENTIFIER(MentalParser.IDENTIFIERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUFFIX_INC_DEC_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUFFIX_INC_DEC_EXPRESSION(MentalParser.SUFFIX_INC_DEC_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNRAY_PLUS_MINUS_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNRAY_PLUS_MINUS_EXPRESSION(MentalParser.UNRAY_PLUS_MINUS_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULTIPLY_DIVIDE_EXPRESSION}
	 * labeled alternative in {@link MentalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTIPLY_DIVIDE_EXPRESSION(MentalParser.MULTIPLY_DIVIDE_EXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by {@link MentalParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MentalParser.ExpressionListContext ctx);
}
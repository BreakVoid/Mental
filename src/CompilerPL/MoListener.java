// Generated from /Users/Songyu/Projects/mo-compiler/src/CompilerPL/Mo.g4 by ANTLR 4.5.1
package CompilerPL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MoParser}.
 */
public interface MoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MoParser#ori_type}.
	 * @param ctx the parse tree
	 */
	void enterOri_type(MoParser.Ori_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#ori_type}.
	 * @param ctx the parse tree
	 */
	void exitOri_type(MoParser.Ori_typeContext ctx);
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
	 * Enter a parse tree produced by {@link MoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MoParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MoParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MoParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MoParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(MoParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(MoParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(MoParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(MoParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#paramters_list}.
	 * @param ctx the parse tree
	 */
	void enterParamters_list(MoParser.Paramters_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#paramters_list}.
	 * @param ctx the parse tree
	 */
	void exitParamters_list(MoParser.Paramters_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(MoParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(MoParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(MoParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(MoParser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(MoParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(MoParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(MoParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(MoParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MoParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MoParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(MoParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(MoParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(MoParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(MoParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(MoParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(MoParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(MoParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(MoParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterJump_stmt(MoParser.Jump_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitJump_stmt(MoParser.Jump_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#left_value}.
	 * @param ctx the parse tree
	 */
	void enterLeft_value(MoParser.Left_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#left_value}.
	 * @param ctx the parse tree
	 */
	void exitLeft_value(MoParser.Left_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MoParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MoParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MoParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MoParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MoParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(MoParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MoParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(MoParser.Func_callContext ctx);
}
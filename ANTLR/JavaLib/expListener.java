// Generated from exp.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link expParser}.
 */
public interface expListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link expParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(expParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(expParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(expParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(expParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(expParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(expParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(expParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(expParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#printstmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintstmt(expParser.PrintstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#printstmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintstmt(expParser.PrintstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignstmt(expParser.AssignstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignstmt(expParser.AssignstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(expParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(expParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(expParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(expParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(expParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(expParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link expParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(expParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link expParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(expParser.IntegerContext ctx);
}
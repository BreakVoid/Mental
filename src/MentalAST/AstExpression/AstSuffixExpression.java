package MentalAST.AstExpression;

import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/4/1.
 */
public class AstSuffixExpression extends AstExpression {
    public static final int PLUS_PLUS = MentalParser.INC;
    public static final int MINUS_MINUS = MentalParser.DEC;
    public AstExpression childExpression;
    public int op;
    public AstSuffixExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalInt;
        this.childExpression = new AstExpression();
    }
}

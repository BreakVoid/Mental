package MentalAST.AstExpression;

import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/2.
 */
public class AstEqualityExpression extends AstBinaryExpression {
    public static final int EQUAL = MentalParser.EQUAL;
    public static final int INEQUAL = MentalParser.INEQUAL;
    public int op;
    public AstEqualityExpression() {
        this.op = 0;
        this.returnType = SymbolTable.mentalBool;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<equality expression";
        if (this.op == EQUAL) {
            ret += "(==)>\n";
        } else {
            ret += "(!=)>\n";
        }
        ret += this.leftExpression.toPrintString(indent + 1) + '\n';
        ret += this.rightExpression.toPrintString(indent + 1);
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent);
        ret += this.leftExpression.toPrettyPrint();
        if (this.op == EQUAL) {
            ret += " == ";
        } else {
            ret += " != ";
        }
        ret += this.rightExpression.toPrettyPrint();
        return ret;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitEqualityExpression(this);
    }
}

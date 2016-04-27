package MentalAST.AstDeclaration;

import MentalAST.AstStatement.AstCompoundStatement;
import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalSymbols.SymbolFunction;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstFunctionDefinition extends AstDeclaration {
    public SymbolFunction functionHead;
    public AstCompoundStatement functionBody;
    public int firstVariableID;
    public int lastVariableID;
    public AstFunctionDefinition() {
        this.functionHead = new SymbolFunction();
        this.functionBody = new AstCompoundStatement();
        this.firstVariableID = 0;
        this.lastVariableID = 0;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<begin>function\n";
        ret += addIndent(indent + 1) + "<format>" + this.functionHead.toString().substring(10) + '\n';
        ret += addIndent(indent + 1) + "<begin function body>\n";
        ret += this.functionBody.toPrintString(indent + 2) + '\n';
        ret += addIndent(indent + 1) + "<end function body>\n";
        ret += addIndent(indent) + "<end>function";
        return ret;
    }
    @Override
    public String toPrettyPrint(int indent) {
        String ret = addIndent(indent)
                + this.functionHead.returnType.toString() + " " + this.functionHead.functionName + "(";
        if (this.functionHead.parameterName.size() > 0) {
            ret += this.functionHead.parameterType.get(0).toString() + " " + this.functionHead.parameterName.get(0);
            for (int i = 1, count = this.functionHead.parameterName.size(); i < count; ++i) {
                ret += "," + this.functionHead.parameterType.get(i).toString() + " " + this.functionHead.parameterName.get(i);
            }
        }
        ret += ") ";
        ret += this.functionBody.toPrettyPrint(indent + 1) + '\n';
        return ret;
    }
    @Override
    public String toString() {
        if (this.functionHead == null || this.functionBody == null) {
            return "";
        }
        return this.functionHead.toString() + ":" + this.functionBody.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstFunctionDefinition) {
                if (this.functionHead.equals(((AstFunctionDefinition) other).functionHead)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitFunctionDefinition(this);
    }
}

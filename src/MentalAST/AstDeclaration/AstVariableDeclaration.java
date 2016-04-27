package MentalAST.AstDeclaration;

import MentalAST.AstBaseNode;
import MentalIR.AstVisitor;
import MentalIR.IRInstruction;
import MentalParser.MentalParser;
import MentalType.MentalType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstVariableDeclaration extends AstBaseNode {
    public MentalType variableType;
    public List<AstSingleVariableDeclaration> variables;
    public AstVariableDeclaration() {
        this.variables = new LinkedList<>();
        this.variableType = null;
    }
    public AstVariableDeclaration(MentalType type, MentalParser.VariableDefinitionContext ctx) {
        this.variables = new LinkedList<>();

        for (MentalParser.SingleVariableContext varCtx : ctx.singleVariable()) {
            this.variables.add(new AstSingleVariableDeclaration(type, varCtx));
        }
    }
    @Override
    public String toPrintString(int indent) {
        if (this.variables.size() == 0) {
            return addIndent(indent) + "<empty variable definition>";
        } else {
            String ret = "";
            ret += this.variables.get(0).toPrintString(indent);
            for (int i = 1, count = this.variables.size(); i < count; ++i) {
                ret += '\n' + this.variables.get(i).toPrintString(indent);
            }
            return ret;
        }
    }
    @Override
    public String toPrettyPrint(int indent) {
        if (this.variables.size() > 0) {
            String ret = addIndent(indent) + this.variableType.toString() + " ";
            ret += this.variables.get(0).toPrettyPrint();
            for (int i = 1, count = this.variables.size(); i < count; ++i) {
                ret += ", " + this.variables.get(i).toPrettyPrint();
            }
            return ret + ";";
        }
        return ";";
    }
    @Override
    public String toString() {
        String ret = "(";
        for (AstSingleVariableDeclaration variable : variables) {
            ret += variable.toString() + ' ';
        }
        ret += ")";
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstVariableDeclaration) {
                if (this.variables.equals(((AstVariableDeclaration) other).variables)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public LinkedList<IRInstruction> visit(AstVisitor visitor) {
        return visitor.visitVariableDeclaration(this);
    }
}

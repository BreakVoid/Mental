package MentalAST;

import MentalParser.MentalParser;
import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstSingleVariableDeclaration extends AstDeclaration {
    public AstVariable variable;
    public AstExpression initializeExpression;
    public AstSingleVariableDeclaration() {
        this.variable = null;
        this.initializeExpression = null;
    }
    public AstSingleVariableDeclaration(MentalType type, MentalParser.SingleVariableContext ctx) {
        this.variable = new AstVariable();
    }
    @Override
    public String toPrintString() {
        return this.toPrintString(0);
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        ret += addIndent(indent) + "<variable>" + variable.toString();
        return ret;
    }
    @Override
    public String toString() {
        String ret = "";
        if (this.variable != null) {
            ret += this.variable.toString();
        } else {
            return ret;
        }
        if (this.initializeExpression != null) {
            ret +=  "=" + this.initializeExpression.toString();
        }
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstSingleVariableDeclaration) {
                if (this.variable.equals(((AstSingleVariableDeclaration) other).variable)) {
                    if (this.initializeExpression.equals(((AstSingleVariableDeclaration) other).initializeExpression)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

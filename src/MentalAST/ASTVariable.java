package MentalAST;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstVariable extends AstBaseNode {
    public String variableName;
    public MentalType variableType;
    public AstVariable() {
        this.variableName = null;
        this.variableType = null;
    }
    @Override
    public String toPrintString() {
        return this.toPrintString(0);
    }
    @Override
    public String toPrintString(int indent) {
        String ret = "";
        return ret;
    }
    @Override
    public String toString() {
        return "[" + this.variableName + "@" + this.variableType.toString() + "]";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstVariable) {
                if (this.variableName.equals(((AstVariable) other).variableName)) {
                    if (this.variableType.equals(((AstVariable) other).variableType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

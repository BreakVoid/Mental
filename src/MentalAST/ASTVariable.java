package MentalAST;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class ASTVariable extends ASTBaseNode {
    public String variableName;
    public MentalType variableType;
    public ASTVariable() {
        this.variableName = null;
        this.variableType = null;
    }
    @Override
    public String toString() {
        return this.variableName + "[" + this.variableType.toString() + "]";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof ASTVariable) {
                if (this.variableName.equals(((ASTVariable) other).variableName)) {
                    if (this.variableType.equals(((ASTVariable) other).variableType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package MentalSymbols;

import MentalAST.AstVariable;
import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class SymbolVariable extends SymbolBase {
    public AstVariable variable;
    public SymbolVariable() {
        this.variable = new AstVariable();
        this.variable.variableName = null;
        this.variable.variableType = null;
        this.variable.variableID = 0;
        this.stackLayer = 0;
    }
    public SymbolVariable(SymbolTable scope, MentalType type, String name) {
        this.variable = new AstVariable();
        this.stackLayer = scope.stackLayer;
        this.variable.variableType = type;
        this.variable.variableName = name;
        this.variable.variableID = 0;
    }
    public SymbolVariable(SymbolTable scope, MentalType type, String name, int id) {
        this.variable = new AstVariable();
        this.stackLayer = scope.stackLayer;
        this.variable.variableType = type;
        this.variable.variableName = name;
        this.variable.variableID = id;
    }
    @Override
    public String toString() {
        return "<variable>" + this.variable.variableName + '[' + this.variable.variableType.toString() + "],id:" + Integer.toString(this.variable.variableID);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof SymbolVariable) {
                if (this.variable.variableID == ((SymbolVariable) other).variable.variableID) {
                    return true;
                }
            }
        }
        return false;
    }
}

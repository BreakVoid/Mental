package MentalSymbols;

import MentalParser.MentalParser;
import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class SymbolVariable extends SymbolBase {
    public String variableName;
    public MentalType variableType;
    public SymbolVariable() {
        this.variableName = null;
        this.variableType = null;
        this.stackLayer = 0;
    }
    public SymbolVariable(SymbolTable scope, MentalType type, String name) {
        this.stackLayer = scope.stackLayer;
        this.variableType = type;
        this.variableName = name;
    }
    @Override
    public String toString() {
        return "<variable>" + variableName + '[' + variableType.toString() + ']';
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof SymbolVariable) {
                if (this.variableName.equals(((SymbolVariable) other).variableName)) {
                    if (this.variableType.equals(((SymbolVariable) other).variableType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

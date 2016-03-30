package MentalSymbols;

import MentalType.MentalType;

/**
 * Created by Songyu on 16/3/30.
 */
public class SymbolVariable extends SymbolBase {
    public String variableName;
    public MentalType variableType;
    public SymbolVariable() {
        variableName = null;
        variableType = null;
    }
    @Override public String toString() {
        return variableName + '[' + variableType.toString() + ']';
    }
}

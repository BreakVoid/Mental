package MentalSymbols;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolBase {
    public SymbolBase() { }
    public String toString() {
        return "SymbolBase";
    }
    public boolean equals(SymbolBase other) {
        return other != null && other instanceof SymbolBase;
    }
}

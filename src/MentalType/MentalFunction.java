package MentalType;

import MentalSymbols.SymbolFunction;

/**
 * Created by Songyu on 16/4/1.
 */
public class MentalFunction extends MentalType {
    public SymbolFunction functionHead;
    public MentalFunction() {
        this.functionHead = new SymbolFunction();
    }
    @Override
    public String toString() {
        return "function";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof MentalFunction) {
                if (this.functionHead.equals(((MentalFunction) other).functionHead)) {
                    return true;
                }
            }
        }
        return false;
    }
}

package MentalType;

import MentalParser.MentalParser;
import MentalSymbols.SymbolTable;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalArray extends MentalType {
    public int arrayDim;
    public MentalType arrayType;
    public String typeName;
    public MentalArray() {
        this.arrayDim = 0;
        this.arrayType = null;
        this.typeName = null;
    }
    public MentalArray(MentalArray other) {
        this.arrayType = other.arrayType;
        this.arrayDim = other.arrayDim;
        this.typeName = other.typeName;
    }
    public MentalArray(MentalParser.TypeContext typeCtx) {
        this.arrayType = null;
        this.arrayDim = typeCtx.array().size();
        this.typeName = typeCtx.typeName().getText();
        if (this.typeName.equals("int")) {
            this.arrayType = SymbolTable.mentalInt;
        } else if (this.typeName.equals("bool")) {
            this.arrayType = SymbolTable.mentalBool;
        } else if (this.typeName.equals("string")) {
            this.arrayType = SymbolTable.mentalString;
        } else {
            this.typeName = typeCtx.typeName().getText();
            this.arrayType = SymbolTable.mentalUnknownType;
        }
    }
    @Override
    public String toString() {
        String ret = this.arrayType.toString();
        for (int i = 0; i < this.arrayDim; ++i) {
            ret += "[]";
        }
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof MentalNull) {
                return true;
            }
            if (other instanceof MentalArray) {
                if (this.arrayType.equals(((MentalArray) other).arrayType)) {
                    if (this.arrayDim == ((MentalArray) other).arrayDim) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

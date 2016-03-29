package MentalType;

import MentalParser.MentalParser;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalArray extends MentalType {
    public int arrayDim;
    public MentalType arrayType;
    public MentalArray() {
        this.arrayDim = 0;
        this.arrayType = null;
    }
    public MentalArray(MentalParser.ArrayContext arrCtx) {
        this.arrayType = null;
        this.arrayDim = 1;
        while (arrCtx.typeName() == null) {
            arrCtx = arrCtx.array();
            ++this.arrayDim;
        }
        if (arrCtx.typeName().getText().equals("int")) {
            this.arrayType = mentalInt;
        } else if (arrCtx.typeName().getText().equals("bool")) {
            this.arrayType = mentalBool;
        } else if (arrCtx.typeName().getText().equals("string")) {
            this.arrayType = mentalString;
        } else {
            this.arrayType = mentalUnknownType;
        }
    }
    public String toString() {
        String ret = this.arrayType.toString();
        for (int i = 0; i < this.arrayDim; ++i) {
            ret += "[]";
        }
        return ret;
    }
    public boolean equals(MentalType other) {
        if (other != null) {
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

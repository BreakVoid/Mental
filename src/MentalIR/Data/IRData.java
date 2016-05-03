package MentalIR.Data;

import MentalIR.Label.IRLabelGlobalData;

/**
 * Created by Songyu on 16/4/19.
 */
public abstract class IRData {
    public int registerName;
    public int stackShift;
    public IRLabelGlobalData globalDataLabel;
    public int globalID;

    public String toRegister() {
        return "$" + Integer.toString(this.registerName);
    }
    public String toAddress() {
        // basic data class cannot call this function.
        throw new RuntimeException(this.toString());
    }
}

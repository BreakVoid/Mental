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
    public IRData() {
        this.registerName = -1;
        this.stackShift = 2147483647 >> 1;
        this.globalDataLabel = null;
        this.globalID = -1;
    }

    public String toRegister() {
        return "$" + Integer.toString(this.registerName);
    }
    public String toAddress() {
        // basic data class cannot call this function.
        throw new RuntimeException(this.toString());
    }
}

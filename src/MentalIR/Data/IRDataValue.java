package MentalIR.Data;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRDataValue extends IRData {
    public IRDataValue() {
        this.stackShift = 2147483647 >> 1;
        this.globalDataLabel = null;
        this.globalID = -1;
        this.registerName = -1;
    }
}

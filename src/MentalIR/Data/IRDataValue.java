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

    public String toAddress() {
        if (this.globalDataLabel == null) {
            return String.format("%d($fp)", -4 * this.stackShift);
        } else {
            return this.globalDataLabel.toString();
        }
    }
}

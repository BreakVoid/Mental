package MentalIR.Data;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRDataAddress extends IRData {
    public IRDataValue address;
    public IRDataAddress() {
        this.address = null;
        this.registerName = -1;
        this.stackShift = 2147483647 >> 1;
        this.globalDataLabel = null;
        this.globalID = -1;
    }
    public IRDataAddress(IRDataValue address) {
        this.address = address;
        this.registerName = -1;
        this.stackShift = 2147483647 >> 1;
        this.globalDataLabel = null;
        this.globalID = -1;
    }
    public String toAddress() {
        throw new RuntimeException("cannot apply toAddress on a address data.");
    }
}

package MentalIR.Data;

/**
 * Created by Songyu on 16/5/2.
 */
public class IRDataAddress extends IRData {
    public IRDataValue address;
    public IRDataAddress() {
        this.address = null;
    }
    public IRDataAddress(IRDataValue address) {
        this.address = address;
    }
}

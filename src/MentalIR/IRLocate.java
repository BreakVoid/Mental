package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLocate extends IRData {
    public IRData headPoint;
    public int addressShift;
    public IRLocate() {
        this.headPoint = null;
        this.addressShift = -1;
    }
}

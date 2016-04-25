package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLocate extends IRData {
    public IRData headPoint;
    public IRData shift;
    public IRLocate() {
        this.headPoint = null;
        this.shift = null;
    }
    public IRLoad flat() {
        return new IRLoad(this);
    }
}

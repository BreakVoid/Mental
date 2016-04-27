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
        this.inRegister = false;
        this.registerName = -1;
    }
    public IRLocate(IRData headPoint, IRData shift) {
        this.headPoint = headPoint;
        this.shift = shift;
    }
    public IRLoad load() {
        return new IRLoad(this);
    }
}

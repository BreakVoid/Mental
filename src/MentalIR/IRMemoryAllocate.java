package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRMemoryAllocate extends IRSystemCall {
    public IRData amount;
    public IRData res;
    public IRMemoryAllocate() {
        this.variant = 9;
        this.amount = null;
        this.res = null;
    }
    public IRMemoryAllocate(IRData amount) {
        this.variant = 9;
        this.amount = amount;
        this.res = new IRTemporary();
    }
}

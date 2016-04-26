package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRStore extends IRInstruction {
    public IRData src;
    public IRData dest;
    public IRStore() {
        this.src = this.dest = null;
    }
    public IRStore(IRData src, IRData dest) {
        this.src = src;
        this.dest = dest;
    }
}

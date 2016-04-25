package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLoad extends IRInstruction {
    public IRLocate src;
    public IRTemporary dest;
    public IRLoad() {
        this.src = null;
        this.dest = null;
    }
    public IRLoad(IRLocate locate) {
        this.src = locate;
        this.dest = new IRTemporary();
    }
}

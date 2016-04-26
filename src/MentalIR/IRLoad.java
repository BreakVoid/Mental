package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLoad extends IRInstruction {
    public IRLocate src;
    public IRTemporary dest;
    public int loadSize;
    public IRLoad() {
        this.src = null;
        this.dest = null;
        this.loadSize = 4;
    }
    public IRLoad(IRLocate locate) {
        this.loadSize = 4;
        this.src = locate;
        this.dest = new IRTemporary();
    }
    public IRLoad(IRLocate locate, int loadSize) {
        this.src = locate;
        this.dest = new IRTemporary();
        this.loadSize = loadSize;
    }
}

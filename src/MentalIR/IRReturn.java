package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRReturn extends IRJumpLabel {
    public IRData returnValue;
    public IRReturn() {
        this.returnValue = null;
    }
    public IRReturn(IRLabel gotoLabel, IRData returnValue) {
        super(gotoLabel);
        this.returnValue = returnValue;
    }
}

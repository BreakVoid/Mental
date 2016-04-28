package MentalIR;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareEqual extends IRCompare {
    public IRCompareEqual() {
        super();
    }
    public IRCompareEqual(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompareEqual(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

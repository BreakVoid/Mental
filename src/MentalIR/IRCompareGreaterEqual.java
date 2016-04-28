package MentalIR;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareGreaterEqual extends IRCompare {
    public IRCompareGreaterEqual() {
        super();
    }
    public IRCompareGreaterEqual(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompareGreaterEqual(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

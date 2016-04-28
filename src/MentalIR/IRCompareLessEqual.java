package MentalIR;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareLessEqual extends IRCompare {
    public IRCompareLessEqual() {
        super();
    }
    public IRCompareLessEqual(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompareLessEqual(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

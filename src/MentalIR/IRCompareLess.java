package MentalIR;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompareLess extends IRCompare {
    public IRCompareLess() {
        super();
    }
    public IRCompareLess(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompareLess(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

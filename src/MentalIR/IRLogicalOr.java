package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLogicalOr extends IRBinaryArithmetic {
    public IRLogicalOr() {
        super();
    }
    public IRLogicalOr(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

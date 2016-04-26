package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLogicalAnd extends IRBinaryArithmetic {
    public IRLogicalAnd() {
        super();
    }
    public IRLogicalAnd(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

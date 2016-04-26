package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitOr extends IRBinaryArithmetic {
    public IRBitOr() {
        super();
    }
    public IRBitOr(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

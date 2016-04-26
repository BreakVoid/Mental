package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitAnd extends IRBinaryArithmetic {
    public IRBitAnd() {
        super();
    }
    public IRBitAnd(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

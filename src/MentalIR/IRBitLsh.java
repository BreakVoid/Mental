package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitLsh extends IRBinaryArithmetic {
    public IRBitLsh() {
        super();
    }
    public IRBitLsh(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

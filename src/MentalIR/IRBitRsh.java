package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitRsh extends IRBinaryArithmetic {
    public IRBitRsh() {
        super();
    }
    public IRBitRsh(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

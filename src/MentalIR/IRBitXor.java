package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBitXor extends IRBinaryArithmetic {
    public IRBitXor() {
        super();
    }
    public IRBitXor(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRSub extends IRBinaryArithmetic {
    public IRSub() {
        super();
    }
    public IRSub(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

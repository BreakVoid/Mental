package MentalIR;

/**
 * Created by Songyu on 16/4/28.
 */
public class IRCompare extends IRBinaryArithmetic {
    public IRCompare() {
        super();
    }
    public IRCompare(IRData lhs, IRData rhs) {
        super(lhs, rhs);
    }
    public IRCompare(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

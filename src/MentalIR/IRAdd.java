package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRAdd extends IRBinaryArithmetic {
    public IRAdd() {
        super();
    }
    public IRAdd(IRData lhs, IRData rhs, IRData res) {
        super(lhs, rhs, res);
    }
}

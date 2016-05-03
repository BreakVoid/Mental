package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLogicalNot extends IRUnaryArithmetic {
    public IRLogicalNot() {
        super();
    }
    public IRLogicalNot(IRData child, IRData res) {
        super(child, res);
    }
}

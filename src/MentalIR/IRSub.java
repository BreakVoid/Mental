package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRSub extends IRArithmetic {
    public IRData lhs, rhs;
    public IRSub() {
        this.lhs = this.rhs = null;
    }
}

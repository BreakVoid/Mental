package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRAdd extends IRArithmetic {
    public IRData lhs, rhs;
    public IRAdd() {
        this.lhs = this.rhs = null;
    }
}

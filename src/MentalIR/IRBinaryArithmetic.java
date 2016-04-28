package MentalIR;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRBinaryArithmetic extends IRArithmetic {
    public IRData lhs, rhs;
    public IRBinaryArithmetic() {
        this.lhs = this.rhs = null;
    }
    public IRBinaryArithmetic(IRData lhs, IRData rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.res = new IRTemporary();
    }
    public IRBinaryArithmetic(IRData lhs, IRData rhs, IRData res) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.res = res;
    }
}

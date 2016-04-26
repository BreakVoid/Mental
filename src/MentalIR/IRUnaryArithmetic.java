package MentalIR;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRUnaryArithmetic extends IRArithmetic {
    public IRData child;
    public IRUnaryArithmetic() {
        super();
        this.child = null;
    }
    public IRUnaryArithmetic(IRData child, IRData res) {
        this.child = child;
        this.res = res;
    }
}

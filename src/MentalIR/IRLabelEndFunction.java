package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRLabelEndFunction extends IRLabel {
    public String functionName;
    public IRLabelEndFunction() {
        this.functionName = "";
    }
    public IRLabelEndFunction(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return "_end_func_" + functionName;
    }
}

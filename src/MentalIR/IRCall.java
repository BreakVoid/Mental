package MentalIR;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRCall extends IRInstruction {
    public LinkedList<IRData> parameters;
    public IRLabelFunction functionName;
    public IRData res;
    public IRCall() {
        this.parameters = new LinkedList<>();
        this.functionName = null;
        this.res = null;
    }
    public IRCall(IRLabelFunction functionName) {
        this.parameters = new LinkedList<>();
        this.functionName = functionName;
        this.res = new IRTemporary();
    }
}

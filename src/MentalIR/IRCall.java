package MentalIR;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRCall extends IRInstruction {
    public LinkedList<IRData> parameters;
    public IRCall() {
        this.parameters = new LinkedList<>();
    }
}

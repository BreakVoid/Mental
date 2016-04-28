package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRVariable extends IRData {
    public int variableID = 0;
    public IRLabelGlobalData globalDataLabel;
    public int stackShift;
    public IRVariable() {
        this.variableID = -1;
        this.inRegister = false;
        this.registerName = -1;
        this.stackShift = -1;
        this.globalDataLabel = null;
        this.isParameterForCall = false;
    }
    public IRVariable(int id) {
        this.variableID = id;
        this.inRegister = false;
        this.registerName = -1;
        this.stackShift = -1;
        this.globalDataLabel = null;
        this.isParameterForCall = false;
    }

    @Override
    public String toString() {
        return "m" + Integer.toString(this.variableID);
    }
}

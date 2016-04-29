package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRVariable extends IRData {
    public int variableID = 0;
    public IRLabelGlobalData globalDataLabel;
    public int stackShift;
    // 0 for normal (should be load)
    // 1 for just load (wait to used)
    // 2 for used load (the register may be rewrite)
    public int status;
    public IRVariable() {
        this.variableID = -1;
        this.inRegister = false;
        this.registerName = -1;
        this.stackShift = -1;
        this.globalDataLabel = null;
        this.isParameterForCall = false;
        this.status = 0;
    }
    public IRVariable(int id) {
        this.variableID = id;
        this.inRegister = false;
        this.registerName = -1;
        this.stackShift = -1;
        this.globalDataLabel = null;
        this.isParameterForCall = false;
        this.status = 0;
    }

    @Override
    public String toString() {
        return "m" + Integer.toString(this.variableID);
    }

    public void consume() {
        if (this.status == 1) {
            this.status = 2;
        }
    }

    public void produce() {
        this.status = 1;
    }
}

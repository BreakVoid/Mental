package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRVariable extends IRData {
    public int variableID = 0;
    public IRVariable() {
        this.variableID = -1;
    }
    public IRVariable(int id) {
        this.variableID = id;
    }

    @Override
    public String toString() {
        return "m" + Integer.toString(this.variableID);
    }
}

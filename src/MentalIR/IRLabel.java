package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRLabel extends IRData {
    public static int nextLabel = 0;
    public int labelID;
    public IRLabel() {
        this.labelID = nextLabel++;
    }

    @Override
    public String toString() {
        return "_uniform_" + Integer.toString(this.labelID);
    }
}

package MentalIR.Label;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRLabelGlobalData extends IRLabel {
    public static int nextGlobalDataLabel;
    public int status;
    public IRLabelGlobalData() {
        this.labelID = nextGlobalDataLabel++;
        this.status = 0;
    }

    @Override
    public String toString() {
        return "_static_" + Integer.toString(this.labelID);
    }

}

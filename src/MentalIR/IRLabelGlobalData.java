package MentalIR;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRLabelGlobalData extends IRLabel {
    public static int nextGlobalDataLabel;
    public IRLabelGlobalData() {
        this.labelID = nextGlobalDataLabel++;
    }

    @Override
    public String toString() {
        return "_static_" + Integer.toString(this.labelID);
    }
}

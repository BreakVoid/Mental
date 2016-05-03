package MentalIR.Label;

/**
 * Created by Songyu on 16/4/27.
 */
public class IRLabelElse extends IRLabel {
    public static int nextElseLabel = 0;
    public IRLabelElse() {
        this.labelID = nextElseLabel++;
    }

    @Override
    public String toString() {
        return "_else_" + Integer.toString(this.labelID);
    }
}

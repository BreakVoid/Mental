package MentalIR;

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

    @Override
    public void consume() {
        if (this.status == 1) {
            this.status = 2;
        }
    }

    @Override
    public void produce() {
        this.status = 1;
    }
}

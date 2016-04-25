package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRTemporary extends IRData {
    public static int globalTemporaryCount = 0;
    public int temporaryID;
    public IRTemporary() {
        this.temporaryID = globalTemporaryCount++;
    }

    @Override
    public String toString() {
        return "%" + Integer.toString(this.temporaryID);
    }
}

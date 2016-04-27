package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRTemporary extends IRData {
    public static int globalTemporaryCount = 0;
    public int temporaryID;
    public boolean valid;
    public int stackShift;
    public IRTemporary() {
        this.temporaryID = globalTemporaryCount++;
        this.inRegister = false;
        this.registerName = -1;
        this.valid = false;
    }

    @Override
    public String toString() {
        return "%" + Integer.toString(this.temporaryID);
    }
}

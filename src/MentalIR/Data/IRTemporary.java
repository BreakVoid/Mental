package MentalIR.Data;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRTemporary extends IRData {
    public static int globalTemporaryCount = 0;
    public int temporaryID;
    public boolean valid;
    public int stackShift;
    public int counter;
    public IRTemporary() {
        this.temporaryID = globalTemporaryCount++;
        this.inRegister = false;
        this.registerName = -1;
        this.valid = false;
        this.isParameterForCall = false;
        this.counter = 1;
    }

    @Override
    public String toString() {
        return "%" + Integer.toString(this.temporaryID);
    }

    public void consume() {
        if (this.valid && this.counter > 0) {
            this.counter--;
            if (this.counter == 0) {
                this.valid = false;
            }
        } else {
            System.err.println("translator: try to consume an invalid temporary.");
            throw new RuntimeException();
        }
    }

    public void produce() {
        if (!this.valid) {
            this.valid = true;
            if (this.counter == 0) {
                this.counter = 1;
            }
        }
    }

}

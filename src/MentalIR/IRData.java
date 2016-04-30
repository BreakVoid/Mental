package MentalIR;

/**
 * Created by Songyu on 16/4/19.
 */
public abstract class IRData {
    public boolean inRegister;
    public int registerName;
    public boolean isParameterForCall;
    public boolean valid;
    
    @Override
    public String toString() {
        return "data base type";
    }

    public String toRegister() {
        if (this.inRegister) {
            return String.format("$%d", this.registerName);
        } else {
            throw new RuntimeException("data is not in a register.");
        }
    }

    public String toAddress() {
        // would never be called.
        throw new RuntimeException();
    }

    public void consume() {}
    public void produce() {}
}

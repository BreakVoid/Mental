package MentalIR;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRBranch extends IRInstruction {
    public IRInstruction thenNext;
    public IRInstruction elseNext;
    public IRData condition;
    public IRBranch() {
        this.thenNext = null;
        this.elseNext = null;
        this.condition = null;
        this.nextInstruction = null;
    }
}

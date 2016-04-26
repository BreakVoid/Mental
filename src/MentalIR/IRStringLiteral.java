package MentalIR;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRStringLiteral extends IRData {
    public String context;
    public IRStringLiteral() {
        this.context = null;
    }
    public IRStringLiteral(String str) {
        this.context = str;
    }
}

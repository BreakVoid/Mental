package MentalIR;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRStringLiteral extends IRData {
    public String context;
    public IRLabelGlobalData label;
    public IRStringLiteral() {
        this.context = null;
        this.label = null;
    }
    public IRStringLiteral(String str) {
        this.context = str;
        this.label = new IRLabelGlobalData();
    }
}

package MentalIR.Data;

import MentalIR.Label.IRLabelGlobalData;

/**
 * Created by Songyu on 16/4/26.
 */
public class IRStringLiteral extends IRData {
    public String context;
    public IRLabelGlobalData label;
    // 0 for normal (should be load)
    // 1 for just load (wait to used)
    // 2 for used load (the register may be rewrite)
    public int status;
    public IRStringLiteral() {
        this.context = null;
        this.label = null;
        this.status = 0;
    }
    public IRStringLiteral(String str) {
        this.context = str;
        this.status = 0;
        this.label = new IRLabelGlobalData();
    }

    public void consume() {
        if (this.status == 1) {
            this.status = 2;
        }
    }

    public void produce() {
        this.status = 1;
    }
}

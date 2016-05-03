package MentalIR.Data;

import MentalIR.Label.IRLabelGlobalData;

/**
 * Created by Songyu on 16/5/3.
 */
public class IRDataStringLiteral extends IRDataAddress {
    public String litertal;
    public IRDataStringLiteral() {
        this.litertal = null;
    }
    public IRDataStringLiteral(String litertal) {
        this.litertal = litertal;
    }
}

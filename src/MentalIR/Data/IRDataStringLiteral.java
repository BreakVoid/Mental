package MentalIR.Data;

import MentalIR.Label.IRLabelGlobalData;

/**
 * Created by Songyu on 16/5/3.
 */
public class IRDataStringLiteral extends IRDataAddress {
    public String litertal;
    public IRDataStringLiteral() {
        this.registerName = -1;
        this.litertal = null;
        this.globalDataLabel = null;
        this.stackShift = 2147483647 >> 1;
    }
    public IRDataStringLiteral(String litertal) {
        this.registerName = -1;
        this.litertal = litertal;
        this.globalDataLabel = null;
        this.stackShift = 2147483647 >> 1;
    }

    @Override
    public String toAddress() {
        return this.globalDataLabel.toString();
    }
}

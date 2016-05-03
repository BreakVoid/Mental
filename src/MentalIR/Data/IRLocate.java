package MentalIR.Data;

import MentalIR.Label.IRLabelGlobalData;
import MentalIR.IRLoad;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRLocate extends IRData {
    public IRData headPoint;
    public IRData shift;
    public IRData realAddress;
    public IRLocate() {
        this.headPoint = null;
        this.shift = null;
        this.inRegister = false;
        this.registerName = -1;
        this.realAddress = null;
    }
    public IRLocate(IRData headPoint, IRData shift) {
        this.headPoint = headPoint;
        this.shift = shift;
    }
    public IRLoad load() {
        return new IRLoad(this);
    }

    @Override
    public String toAddress() {
        if (this.realAddress != null) {
            return String.format("0(%s)", this.realAddress.toRegister());
        } else if (this.shift instanceof IRWordLiteral && !(this.headPoint instanceof IRLabelGlobalData)) {
            return String.format("%d(%s)", ((IRWordLiteral) this.shift).context, this.headPoint.toRegister());
        } else {
            throw new RuntimeException();
        }
    }
}

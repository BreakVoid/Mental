package MentalTranslator;

import MentalIR.Data.IRData;
import MentalIR.Data.IRDataIntLiteral;
import MentalIR.Data.IRDataStringLiteral;
import MentalIR.Label.IRLabelGlobalData;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/27.
 */
public class MIPSMachine {
    public IRData[] registerData;
    public int[] loadTime;
    public int[] updateTime;
    public int globalTime;
    public MIPSMachine() {
        this.loadTime = new int [32];
        this.updateTime = new int [32];
        this.registerData = new IRData[32];
        this.globalTime = 1;
        for (int i = 0; i < 32; ++i) {
            this.registerData[i] = null;
            this.loadTime[i] = -1;
            this.updateTime[i] = -1;
        }
    }

    public int getFirstLoadRegister() {
        int res = MIPSRegister.t0;
        for (int i = MIPSRegister.t0; i < MIPSRegister.t9; ++i) {
            if (this.loadTime[i] < this.loadTime[res]) {
                res = i;
            }
        }
        return res;
    }

    public String storeFirstLoadRegister() {
        int reg = getFirstLoadRegister();
        if (this.loadTime[reg] == -1) {
//            return "#store nothing";
            return "";
        }
        if (this.loadTime[reg] == this.updateTime[reg]) {
//            return "#store nothing";
            return "";
        }
        return String.format("\tsw $%d, %s", reg, this.registerData[reg].toAddress());
    }

    public void rewriteFirstLoadRegister(IRData newData) {
        int reg = getFirstLoadRegister();
        if (this.registerData[reg] == null) {
            this.registerData[reg] = newData;
            newData.registerName = reg;
        }
        this.loadTime[reg] = this.globalTime++;
        this.updateTime[reg] = this.globalTime++;
    }

    public String replaceFirstLoadRegisterWithLoad(IRData newData) {
        int reg = getFirstLoadRegister();

        if (this.registerData[reg] != null) {
            this.registerData[reg].registerName = -1;
            this.registerData[reg] = null;
        }

        this.registerData[reg] = newData;
        newData.registerName = reg;

        this.loadTime[reg] = this.globalTime++;
        this.updateTime[reg] = this.loadTime[reg];
        if (newData instanceof IRDataIntLiteral) {
            return String.format("\tli $%d, %s", reg, ((IRDataIntLiteral) newData).literal);
        } else if (newData instanceof IRDataStringLiteral) {
            return String.format("\tla $%d, %s", reg, newData.toAddress());
        } else {
            return String.format("\tlw $%d, %s", reg, newData.toAddress());
        }
    }

    public void updateRegister(int registerName) {
        this.updateTime[registerName] = this.globalTime++;
    }

    public String storeAndCleanMachine() {
        LinkedList<String> storeInstructions = new LinkedList<>();
        for (int i = MIPSRegister.t0; i < MIPSRegister.t9; ++i) {
            if (this.registerData[i] != null) {
                if (this.registerData[i] instanceof IRDataStringLiteral) {
                    continue;
                }
                if (this.registerData[i] instanceof IRDataIntLiteral) {
                    continue;
                }
                if (this.updateTime[i] > this.loadTime[i]) {
                    storeInstructions.add(
                            String.format("\tsw $%d, %s", i, this.registerData[i].toAddress())
                    );
                }
                this.registerData[i].registerName = -1;
                this.registerData[i] = null;
            }
            this.loadTime[i] = -1;
            this.updateTime[i] = -1;
        }
        String str = "";
        for (String statement : storeInstructions) {
            if (statement.length() > 0) {
                str += statement + "\n";
            }
        }
        if (str.length() == 0) {
            str = " ";
        }
        return str.substring(0, str.length() - 1);
    }
}

package MentalTranslator;

import MentalCore.Main;
import MentalIR.*;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Songyu on 16/4/27.
 */
public class MIPSMachine {
    public boolean[] registerEmpty;
    public IRData[] registerData;
    public int[] useTime;
    public int globalTime;
    public MIPSMachine() {
        this.useTime = new int [32];
        this.globalTime = 0;
        this.registerEmpty = new boolean[32];
        this.registerData = new IRData[32];
        for (int i = 0; i < 32; ++i) {
            this.registerEmpty[i] = true;
            this.registerData[i] = null;
        }
    }
    public boolean isEmpty(int i) {
        return this.registerEmpty[i];
    }
    public boolean canBeRewrite(int i) {
        if (this.isEmpty(i)) {
            return true;
        }
        if (this.registerData[i] instanceof IRVariable) {
            if (((IRVariable) this.registerData[i]).status == 2) {
                return true;
            }
        }
        if (this.registerData[i] instanceof IRStringLiteral) {
            if (((IRStringLiteral) this.registerData[i]).status == 2) {
                return true;
            }
        }
        if (this.registerData[i] instanceof IRLabelGlobalData) {
            if (((IRLabelGlobalData) this.registerData[i]).status == 2) {
                return true;
            }
        }
        if (this.registerData[i] instanceof IRTemporary) {
            if (!((IRTemporary)this.registerData[i]).valid) {
                return true;
            }
        }
        return false;
    }
    public IRData occupied(int i) {
        return this.registerData[i];
    }

    public int getEmptyRegister() {
        int registerName = -1;
        for (int i = MIPSRegister.t0; i <= MIPSRegister.t9; ++i) {
            if (this.isEmpty(i)) {
                return i;
            } else if (this.canBeRewrite(i)) {
                if (registerName == -1) {
                    registerName = i;
                } else {
                    if (this.useTime[i] < this.useTime[registerName]) {
                        registerName = i;
                    }
                }
            }
        }
        return registerName;
    }

    public void use(int registerName, IRData data) {
        if (data != null) {
            if (this.registerData[registerName] != null) {
                this.erase(registerName);
            }
            this.registerEmpty[registerName] = false;
            this.registerData[registerName] = data;
            this.useTime[registerName] = this.globalTime++;
        } else {
            throw new RuntimeException("use the register with null data.");
        }
    }

    public void erase(int registerName) {
        if (!this.canBeRewrite(registerName)) {
            System.err.println(this.registerData[registerName]);
            throw new RuntimeException("the data will be used after. (register: " + Integer.toString(registerName) + ")");
        }
        if (this.registerData[registerName] != null) {
            if (this.registerData[registerName] instanceof IRVariable) {
                ((IRVariable) this.registerData[registerName]).status = 0;
            }
            if (this.registerData[registerName] instanceof IRStringLiteral) {
                ((IRStringLiteral) this.registerData[registerName]).status = 0;
            }
            if (this.registerData[registerName] instanceof IRLabelGlobalData) {
                ((IRLabelGlobalData) this.registerData[registerName]).status = 0;
            }
            this.registerData[registerName].inRegister = false;
            this.registerData[registerName].registerName = -1;
        }
        this.registerEmpty[registerName] = true;
        this.registerData[registerName] = null;
        this.useTime[registerName] = 0;
    }

    public String registerUse() {
        String s = "";
        for (int i = 0; i < 32; ++i) {
            if (this.isEmpty(i)) {
                s += "-";
            } else if (this.canBeRewrite(i)) {
                s += "A";
            } else {
                s += "U";
            }
        }
        return s;
    }

    public void clear() {
        for (int i = 0; i < 32; ++i) {
            this.erase(i);
        }
    }
}
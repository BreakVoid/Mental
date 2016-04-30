package MentalTranslator;

import MentalCore.Main;
import MentalIR.IRData;
import MentalIR.IRStringLiteral;
import MentalIR.IRTemporary;
import MentalIR.IRVariable;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Songyu on 16/4/27.
 */
public class MIPSMachine {
    public boolean[] registerEmpty;
    public IRData[] registerData;
    public MIPSMachine() {
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
        if (this.registerData[i] instanceof IRTemporary) {
            if (!this.registerData[i].valid) {
                return true;
            }
        }
        return false;
    }
    public IRData occupied(int i) {
        return this.registerData[i];
    }
    public int getEmptyRegisterT() {
        if (isEmpty(MIPSRegister.t0)) {
            return MIPSRegister.t0;
        } else if (isEmpty(MIPSRegister.t1)) {
            return MIPSRegister.t1;
        } else if (isEmpty(MIPSRegister.t2)) {
            return MIPSRegister.t2;
        } else if (isEmpty(MIPSRegister.t3)) {
            return MIPSRegister.t3;
        } else if (isEmpty(MIPSRegister.t4)) {
            return MIPSRegister.t4;
        } else if (isEmpty(MIPSRegister.t5)) {
            return MIPSRegister.t5;
        } else if (isEmpty(MIPSRegister.t6)) {
            return MIPSRegister.t6;
        } else if (isEmpty(MIPSRegister.t7)) {
            return MIPSRegister.t7;
        } else if (isEmpty(MIPSRegister.t8)) {
            return MIPSRegister.t8;
        } else if (isEmpty(MIPSRegister.t9)) {
            return MIPSRegister.t9;
        }
        LinkedList<Integer> choices = new LinkedList<>();
        if (canBeRewrite(MIPSRegister.t0)) {
            choices.add(MIPSRegister.t0);
        }
        if (canBeRewrite(MIPSRegister.t1)) {
            choices.add(MIPSRegister.t1);
        }
        if (canBeRewrite(MIPSRegister.t2)) {
            choices.add(MIPSRegister.t2);
        }
        if (canBeRewrite(MIPSRegister.t3)) {
            choices.add(MIPSRegister.t3);
        }
        if (canBeRewrite(MIPSRegister.t4)) {
            choices.add(MIPSRegister.t4);
        }
        if (canBeRewrite(MIPSRegister.t5)) {
            choices.add(MIPSRegister.t5);
        }
        if (canBeRewrite(MIPSRegister.t6)) {
            choices.add(MIPSRegister.t6);
        }
        if (canBeRewrite(MIPSRegister.t7)) {
            choices.add(MIPSRegister.t7);
        }
        if (canBeRewrite(MIPSRegister.t8)) {
            choices.add(MIPSRegister.t8);
        }
        if (canBeRewrite(MIPSRegister.t9)) {
            choices.add(MIPSRegister.t9);
        }
        if (choices.size() == 0) {
            return -111;
        }
        return -choices.get(Main.globalRandom.nextInt(choices.size()));
    }

    public int getEmptyRegisterS() {
        if (isEmpty(MIPSRegister.s0)) {
            return MIPSRegister.s0;
        } else if (isEmpty(MIPSRegister.s1)) {
            return MIPSRegister.s1;
        } else if (isEmpty(MIPSRegister.s2)) {
            return MIPSRegister.s2;
        } else if (isEmpty(MIPSRegister.s3)) {
            return MIPSRegister.s3;
        } else if (isEmpty(MIPSRegister.s4)) {
            return MIPSRegister.s4;
        } else if (isEmpty(MIPSRegister.s5)) {
            return MIPSRegister.s5;
        } else if (isEmpty(MIPSRegister.s6)) {
            return MIPSRegister.s6;
        } else if (isEmpty(MIPSRegister.s7)) {
            return MIPSRegister.s7;
        }
        LinkedList<Integer> choices = new LinkedList<>();
        if (canBeRewrite(MIPSRegister.s0)) {
            choices.add(MIPSRegister.s0);
        }
        if (canBeRewrite(MIPSRegister.s1)) {
            choices.add(MIPSRegister.s1);
        }
        if (canBeRewrite(MIPSRegister.s2)) {
            choices.add(MIPSRegister.s2);
        }
        if (canBeRewrite(MIPSRegister.s3)) {
            choices.add(MIPSRegister.s3);
        }
        if (canBeRewrite(MIPSRegister.s4)) {
            choices.add(MIPSRegister.s4);
        }
        if (canBeRewrite(MIPSRegister.s5)) {
            choices.add(MIPSRegister.s5);
        }
        if (canBeRewrite(MIPSRegister.s6)) {
            choices.add(MIPSRegister.s6);
        }
        if (canBeRewrite(MIPSRegister.s7)) {
            choices.add(MIPSRegister.s7);
        }
        if (choices.size() == 0) {
            return -111;
        }
        return -choices.get(Main.globalRandom.nextInt(choices.size()));
    }

    public int getEmptyRegister() {
        int res = this.getEmptyRegisterT();
        if (res > 0) {
            return res;
        } else {
            int sRes = this.getEmptyRegisterS();
            if (sRes > 0) {
                return sRes;
            } else {
                if (res != -111 && sRes != -111) {
                    if (Main.globalRandom.nextBoolean()) {
                        return -res;
                    } else {
                        return -sRes;
                    }
                } else if (res == -111 && sRes != -111) {
                    return -sRes;
                } else if (res != -111) {
                    return -res;
                } else {
                    return -1;
                }
            }
        }
    }

    public void use(int registerName, IRData data) {
        this.registerEmpty[registerName] = false;
        if (this.registerData[registerName] != null) {
            this.erase(registerName);
        }
        this.registerData[registerName] = data;
    }

    public void erase(int registerName) {
        this.registerEmpty[registerName] = true;
        if (this.registerData[registerName] != null) {
            if (this.registerData[registerName] instanceof IRVariable) {
                ((IRVariable) this.registerData[registerName]).status = 0;
            }
            this.registerData[registerName].inRegister = false;
        }
        this.registerData[registerName] = null;
    }

    public String registerUse() {
        String s = "";
        for (int i = 0; i < 32; ++i) {
            if (this.isEmpty(i)) {
                s += "0";
            } else if (this.canBeRewrite(i)) {
                s += "A";
            } else {
                s += "U";
            }
        }
        return s;
    }
}

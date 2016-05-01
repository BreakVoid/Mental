package MentalIR;

import MentalTranslator.MIPSMachine;
import MentalTranslator.MIPSRegister;
import sun.security.pkcs11.wrapper.CK_ECDH1_DERIVE_PARAMS;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Songyu on 16/4/25.
 */
public class IRCall extends IRInstruction {
    public LinkedList<IRData> parameters;
    public IRLabelFunction functionName;
    public IRData res;
    public IRCall() {
        this.parameters = new LinkedList<>();
        this.functionName = null;
        this.res = null;
    }
    public IRCall(IRLabelFunction functionName) {
        this.parameters = new LinkedList<>();
        this.functionName = functionName;
        this.res = new IRTemporary();
    }

    @Override
    public String toMips(MIPSMachine mipsMachine) {
        LinkedList<String> mipsInstructions = new LinkedList<>();
        LinkedList<Integer> storedRegister = new LinkedList<>();
        if (this.label != null) {
            mipsInstructions.add(this.label + ":");
        }
        for (int i = 8; i < 26; ++i) {
            if (!mipsMachine.isEmpty(i)) {
                if (mipsMachine.canBeRewrite(i)) {
                    mipsMachine.erase(i);
                } else {
                    mipsInstructions.add(
                            String.format("\tsw $%d, %d($sp)", i, 4 * (31 - i))
                    );
                    storedRegister.add(i);
                }
            }
        }
        for (int i = 0, count = this.parameters.size(); i < count; ++i) {
            IRData thisParameter = this.parameters.get(i);
            if (!thisParameter.inRegister) {
                thisParameter.registerName = mipsMachine.getEmptyRegister();
                if (thisParameter.registerName == -1) {
                    throw new RuntimeException("no enough register");
                }
                thisParameter.inRegister = true;
                thisParameter.produce();

                if (thisParameter instanceof IRVariable) {
                    mipsInstructions.add(
                            String.format("\tlw %s, %s", thisParameter.toRegister(), thisParameter.toAddress())
                    );
                } else if (thisParameter instanceof IRStringLiteral) {
                    mipsInstructions.add(
                            String.format("\tla %s, %s", thisParameter.toRegister(), thisParameter.toAddress())
                    );
                } else if (thisParameter instanceof IRWordLiteral) {
                    mipsInstructions.add(
                            String.format("\tli %s, %d", thisParameter.toRegister(), ((IRWordLiteral) thisParameter).context)
                    );
                }
            }

            mipsInstructions.add(
                    String.format("\tsw %s, %d($sp)", thisParameter.toRegister(), -4 * (i + 1))
            );
            thisParameter.consume();
        }
        mipsInstructions.add(
                String.format("jal %s", this.functionName.toString())
        );

        this.res.registerName = mipsMachine.getEmptyRegister();
        if (this.res.registerName == -1) {
            throw new RuntimeException("no enough register.");
        }
        this.res.inRegister = true;
        this.res.produce();

        mipsInstructions.add(
                String.format("\tmove %s, $v0", this.res.toRegister())
        );

        for (int i : storedRegister) {
            mipsInstructions.add(
                    String.format("\tlw $%d, %d($sp)", i, 4 * (31 - i))
            );
        }

        String str = "";
        for (String statement : mipsInstructions) {
            str += statement + '\n';
        }
        return str.substring(0, str.length() - 1);
    }
}

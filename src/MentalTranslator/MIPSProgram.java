package MentalTranslator;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/4/30.
 */
public class MIPSProgram {
    public MIPSStaticData staticData;
    public MIPSGlobalInitialize globalInitialize;
    public LinkedList<MIPSFunctions> functions;
    public LinkedList<String> beginMainLabel;
    public LinkedList<String> endMainLabel;
    public MIPSProgram() {
        this.staticData = new MIPSStaticData();
        this.globalInitialize = new MIPSGlobalInitialize();
        this.functions = new LinkedList<>();

        this.beginMainLabel = new LinkedList<>();
        beginMainLabel.add("\t.text");
        beginMainLabel.add("main:");

        this.endMainLabel = new LinkedList<>();
        this.endMainLabel.add("\tadd $fp, $zero, $sp");
        this.endMainLabel.add("\tjal _func_main");
        this.endMainLabel.add("\tmove $a0, $v0");
        this.endMainLabel.add("\tli $v0, 17");
        this.endMainLabel.add("\tsyscall");
    }
    public String toString() {
        String program = "";
        for (String statement : this.staticData.mipsStatements) {
            program += statement + "\n";
        }
        for (String statement : this.beginMainLabel) {
            program += statement + "\n";
        }
        for (String statement : this.globalInitialize.mipsStatement) {
            program += statement + "\n";
        }
        for (String statement : this.endMainLabel) {
            program += statement + "\n";
        }

        for (MIPSFunctions function : this.functions) {
            for (String statement: function.mipsStatement) {
                program += statement + "\n";
            }
            program += "\n";
        }

        return program;
    }
}

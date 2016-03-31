package MentalAST;

import MentalSymbols.SymbolType;
import MentalType.MentalClass;
import MentalType.MentalType;

import java.util.Map;

/**
 * Created by Songyu on 16/3/30.
 */
public class AstClassDeclaration extends AstDeclaration {
    public SymbolType classDetail;
    public AstClassDeclaration() {
        this.classDetail = null;
    }
    @Override
    public String toPrintString() {
        return this.toPrintString(0);
    }
    public String toPrintString(int indent) {
        MentalClass classBody = (MentalClass) this.classDetail.type;
        String ret = addIndent(indent) + "<begin>class:" + classBody.className + '\n';

        for (Map.Entry<String, MentalType> entry : classBody.classComponents.entrySet()) {
            ret += addIndent(indent + 1) + "[" + entry.getKey() + "@" + entry.getValue().toString() + "]\n";
        }
        ret += addIndent(indent) + "<end>class";
        return ret;
    }
    @Override
    public String toString() {
        return "<class>" + this.classDetail.type.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof AstClassDeclaration) {
                if (this.classDetail.equals(((AstClassDeclaration) other).classDetail)) {
                    return true;
                }
            }
        }
        return false;
    }
}

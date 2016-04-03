package MentalAST.AstExpression;

import MentalType.MentalType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Songyu on 16/3/31.
 */
public class AstCreationExpression extends AstExpression {
    public MentalType baseType;
    public List<AstExpression> expressionList;
    public int resultDim;
    public int determinedDim;
    public AstCreationExpression() {
        this.expressionList = new LinkedList<>();
        this.resultDim = 0;
        this.determinedDim = 0;
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<creation expression>:" + this.returnType.toString();
        if (this.expressionList == null || this.expressionList.size() == 0) {
            return ret;
        } else {
            ret += "\n" + addIndent(indent + 1) + "<dimension:1>\n"
                    + this.expressionList.get(0).toPrintString(indent + 2);
            for (int i = 1, count = this.expressionList.size(); i < count; ++i) {
                ret += "\n" + addIndent(indent + 1) + "<dimension:" + Integer.toString(i + 1) + ">\n"
                        + this.expressionList.get(i).toPrintString(indent + 2);
            }
            if (this.resultDim > this.determinedDim) {
                ret += "\n" + addIndent(indent + 1) + "<number of undetermined dimensions>:"
                        + Integer.toString(this.resultDim - this.determinedDim);
            }
            return ret;
        }
    }
}

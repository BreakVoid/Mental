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
    public AstCreationExpression() {
        this.expressionList = new LinkedList<>();
    }
    @Override
    public String toPrintString(int indent) {
        String ret = addIndent(indent) + "<creation expression>:" + this.returnType.toString();
        if (this.expressionList.size() == 0) {
            return ret;
        } else {
            ret += addIndent(indent + 1) + "<dimension:1>\n"
                    + this.expressionList.get(0).toPrintString(indent + 2);
            for (int i = 1, count = this.expressionList.size(); i < count; ++i) {
                ret += addIndent(indent + 1) + "<dimension:" + Integer.toString(i + 1) + ">\n"
                        + this.expressionList.get(i).toPrintString(indent + 2);
            }
            return ret;
        }
    }
}

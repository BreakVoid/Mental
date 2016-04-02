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
}

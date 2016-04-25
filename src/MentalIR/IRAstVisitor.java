package MentalIR;
import MentalAST.*;
import MentalAST.AstExpression.AstAdditiveExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Songyu on 16/4/19.
 */
public class IRAstVisitor {
    public List<IRInstruction> labelLocations;
    public int lastLabel;
    public IRAstVisitor() {
        this.labelLocations = new ArrayList<>();
        this.lastLabel = 0;
    }
    public void visitBase(AstBaseNode node) {

    }
    public void visitAddtiveExpression(AstAdditiveExpression node) {

    }
}

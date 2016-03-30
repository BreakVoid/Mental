package MentalSymbols;

import MentalParser.MentalParser;
import MentalType.MentalType;
import MentalType.MentalArray;

import java.util.LinkedList;

/**
 * Created by Songyu on 16/3/30.
 */
public class SymbolVariableList {
    public LinkedList<SymbolVariable> variables;
    public SymbolVariableList() {
        variables = new LinkedList<>();
    }
    public SymbolVariableList(SymbolTable scope, MentalParser.VariableDefinitionContext varDefCtx) {
        variables = new LinkedList<>();
        // Get the type
        // find the type from current scope
        SymbolBase baseType = scope.table.get(varDefCtx.type().typeName().getText());
        if (baseType == null || !(baseType instanceof SymbolType)) {
            System.out.println("fatal: no such a type " + varDefCtx.type().typeName().getText());
            System.exit(-1);
        }
        MentalType type;
        if (varDefCtx.type().array().size() != 0) {
            // type is array.
            type = new MentalArray(varDefCtx.type());
            if (((MentalArray) type).arrayType.equals(MentalType.mentalUnknownType)) {
                ((MentalArray) type).arrayType = ((SymbolType) baseType).type;
            }
        } else {
            type = ((SymbolType) baseType).type;
        }
        for (int j = 0, idCount = varDefCtx.singleVariable().size(); j < idCount; ++j) {
            String id = varDefCtx.singleVariable(j).Identifier().getText();
            this.variables.add(new SymbolVariable(scope, type, id));
        }
    }
}

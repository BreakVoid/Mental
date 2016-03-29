package MentalSymbols;

import MentalParser.MentalParser;
import MentalType.MentalType;
import MentalType.MentalArray;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolFunction extends SymbolBase {
    public MentalType returnType;
    public HashMap<String, MentalType> paramterList;
    public String functionName;
    public SymbolFunction() {
        returnType = MentalType.mentalUnknownType;
        paramterList = new HashMap<>();
        functionName = null;
    }
    // Constructor a function symbol from a given scope and FunctionDefinitionContext.
    public SymbolFunction(SymbolTable scope, MentalParser.FunctionDefinitionContext funcDefCtx) {
        // Set the name of the function.
        this.functionName = funcDefCtx.functionName.getText();
        // Determine the type of return value of the function.
        if (funcDefCtx.type() == null) {
            this.returnType = MentalType.mentalVoid;
        } else {
            if (funcDefCtx.type().typeName() != null) {
                SymbolBase base = scope.table.get(funcDefCtx.type().typeName().getText());
                if (base != null && base instanceof SymbolType) {
                    this.returnType = ((SymbolType) base).type;
                } else {
                    System.out.println("fatal: no such a type" + funcDefCtx.type().typeName().getText());
                    System.exit(-1);
                }
            } else {
                this.returnType = new MentalArray(funcDefCtx.type().array());
                if (((MentalArray) this.returnType).arrayType == MentalType.mentalUnknownType) {
                    MentalParser.ArrayContext arrCtx = funcDefCtx.type().array();
                    while (arrCtx.typeName() == null) {
                        arrCtx = arrCtx.array();
                    }
                    SymbolBase base = scope.table.get(arrCtx.typeName().getText());
                    if (base != null && base instanceof SymbolType) {
                        ((MentalArray) this.returnType).arrayType = ((SymbolType) base).type;
                    } else {
                        System.out.println("fatal: no such a type" + arrCtx.typeName().getText());
                        System.exit(-1);
                    }
                }
            }
        }
        // Process the paramters of the function.
        for (int i = 0, limit = funcDefCtx.paramtersList().parameter().size(); i < limit; ++i) {
            MentalParser.ParameterContext parameter = funcDefCtx.paramtersList().parameter(i);

        }
    }
}

package MentalSymbols;

import MentalParser.MentalParser;
import MentalType.MentalType;
import MentalType.MentalArray;

import java.util.ArrayList;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolFunction extends SymbolBase {
    public MentalType returnType;
    public ArrayList<String> parameterName;
    public ArrayList<MentalType> parameterType;
    public String functionName;
    public SymbolFunction() {
        returnType = SymbolTable.mentalUnknownType;
        parameterName = new ArrayList<>();
        parameterType = new ArrayList<>();
        functionName = "";
    }
    public SymbolFunction(SymbolFunction other) {
        this.returnType = other.returnType;
        this.parameterName = other.parameterName;
        this.parameterType = other.parameterType;
        this.functionName = other.functionName;
    }
    // Constructor a function symbol from a given scope and FunctionDefinitionContext.
    public boolean setFunction(SymbolTable scope, MentalParser.FunctionDefinitionContext funcDefCtx) {
        boolean existError = false;
        this.stackLayer = SymbolTable.maxLayer;
        // Set the name of the function.
        this.functionName = funcDefCtx.functionName.getText();
        this.parameterName = new ArrayList<>();
        this.parameterType = new ArrayList<>();

        // Determine the type of return value of the function.
        if (funcDefCtx.type() == null) {
            this.returnType = SymbolTable.mentalVoid;
        } else {
            SymbolBase baseType = scope.getSymbol(funcDefCtx.type().typeName().getText());
            if (baseType == null || !(baseType instanceof SymbolType)) {
                System.err.println("fatal: no such a type " + funcDefCtx.type().typeName().getText());
                existError = true;
                System.exit(1);
            }
            if (funcDefCtx.type().array().size() != 0) {
                this.returnType = new MentalArray(funcDefCtx.type());
                if (((MentalArray) this.returnType).arrayType.equals(SymbolTable.mentalUnknownType)) {
                    ((MentalArray) this.returnType).arrayType = ((SymbolType) baseType).type;
                }
            } else {
                this.returnType = ((SymbolType) baseType).type;
            }
        }

        // Process the parameters of the function.
        if (funcDefCtx.parametersList() != null) {
            for (int i = 0, limit = funcDefCtx.parametersList().parameter().size(); i < limit; ++i) {
                // for each parameter

                MentalParser.ParameterContext parameterCtx = funcDefCtx.parametersList().parameter(i);

                // Get TypeContext
                MentalParser.TypeContext typeCtx = parameterCtx.type();
                MentalType type = null;

                // Get the name of parameter.
                String name = parameterCtx.Identifier().getText();

                // Process the type of a single variable.
                SymbolBase baseType = scope.getSymbol(typeCtx.typeName().getText());
                if (baseType == null || !(baseType instanceof SymbolType)) {
                    System.err.println("fatal: no such a type " + typeCtx.typeName().getText());
                    existError = true;
                    System.exit(1);
                }
                if (typeCtx.array().size() != 0) {
                    type = new MentalArray(typeCtx);
                    if (((MentalArray) type).arrayType.equals(SymbolTable.mentalUnknownType)) {
                        ((MentalArray) type).arrayType = ((SymbolType) baseType).type;
                    }
                } else {
                    type = ((SymbolType) baseType).type;
                }

                // Get the type and name put to list.
                parameterName.add(name);
                parameterType.add(type);
            }
        }
        return existError;
    }
    @Override
    public String toString() {
        String ret = "<function>" + this.returnType.toString() + " " + this.functionName + '(';
        if (parameterName.size() > 0) {
            for (int i = 0, count = parameterName.size() - 1; i < count; ++i) {
                ret += parameterType.get(i).toString() + ',';
            }
            ret += parameterType.get(parameterType.size() - 1).toString();
        }
        ret += ')';
        return ret;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof SymbolFunction) {
                if (this.functionName.equals(((SymbolFunction) other).functionName)) {
                    if (this.returnType.equals(((SymbolFunction) other).returnType)) {
                        if (this.parameterType.equals(((SymbolFunction) other).parameterType)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

package MentalSymbols;

import MentalParser.MentalParser;
import MentalType.*;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */

public class SymbolType extends SymbolBase {
    public MentalType type;
    public SymbolType() {
        this.type = new MentalType();
    }
    public SymbolType(MentalType type) {
        this.type = type;
    }
    public SymbolType(SymbolType other) {
        this.type = other.type;
    }
    public SymbolType(SymbolTable scope, MentalParser.ClassDeclarationContext classDeclCtx) {
        HashMap<String, MentalType> classComponents = new HashMap<String, MentalType>();
        this.type = new MentalClass(classComponents);
        // Get className
        ((MentalClass)this.type).className = classDeclCtx.className().getText();
        // Process class components
        for (int i = 0, varCount = classDeclCtx.variableDefinition().size(); i < varCount; ++i) {
            // for each variable definition
            // get each definition
            MentalParser.VariableDefinitionContext varDefCtx = classDeclCtx.variableDefinition(i);
            // try to get base type from scope
            SymbolBase baseType = scope.table.get(varDefCtx.type().typeName().getText());
            // if baseType is not a type then halt
            if (!(varDefCtx.type().typeName().getText().equals(classDeclCtx.className().getText()))) {
                if (baseType == null || !(baseType instanceof SymbolType)) {
                    System.out.println("fatal: declarate a variable with bad type.");
                    System.exit(-1);
                }
            }
            MentalType type;
            if (varDefCtx.type().array().size() != 0) {
                // if the type is an array.
                type = new MentalArray(varDefCtx.type());
                // find the base type of the array.
                if (varDefCtx.type().typeName().getText().equals(classDeclCtx.className().getText())) {
                    // if it is a type of itself.
                    ((MentalArray) type).arrayType = this.type;
                } else {
                    ((MentalArray) type).arrayType = ((SymbolType) baseType).type;
                }
            } else {
                if (varDefCtx.type().typeName().getText().equals(classDeclCtx.className().getText())) {
                    // the type is itself.
                    type = this.type;
                } else {
                    type = ((SymbolType) baseType).type;
                }
            }
            // Process each variable with the type.
            for (int j = 0, idCount = varDefCtx.singleVariable().size(); j < idCount; ++j) {
                String id = varDefCtx.singleVariable(j).Identifier().getText();
                classComponents.put(id, type);
            }
        }
    }
    @Override
    public String toString() {
        return this.type.toString();
    }
    @Override
    public boolean equals(SymbolBase other) {
        if (other != null) {
            if (other instanceof SymbolType) {
                if (this.type.equals(((SymbolType) other).type)) {
                    return true;
                }
            }
        }
        return false;
    }
}


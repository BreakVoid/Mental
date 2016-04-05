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
        this.type = new MentalClass();
    }
    public SymbolType(SymbolType other) {
        this.type = other.type;
    }
    public void setType(MentalType type) {
        this.type = type;
    }
    public boolean setType(SymbolTable scope, MentalParser.ClassDeclarationContext classDeclCtx) {
        boolean existError = false;
        this.stackLayer = SymbolTable.maxLayer;
        HashMap<String, MentalType> classComponents = new HashMap<String, MentalType>();
        ((MentalClass) this.type).setClassComponents(classComponents);
        // Get className
        ((MentalClass) this.type).className = classDeclCtx.className().getText();
        // Process class components
        for (int i = 0, varCount = classDeclCtx.variableDefinition().size(); i < varCount; ++i) {
            // for each variable definition
            // get each definition
            MentalParser.VariableDefinitionContext varDefCtx = classDeclCtx.variableDefinition(i);

            // try to get base type from scope
            SymbolBase baseType = scope.getSymbol(varDefCtx.type().typeName().getText());

            // if baseType is not a type then halt
            if (!(varDefCtx.type().typeName().getText().equals(classDeclCtx.className().getText()))) {
                if (baseType == null || !(baseType instanceof SymbolType)) {
                    System.err.println("fatal: declarate a variable with bad type.");
                    existError = true;
                    System.exit(1);
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
                if (classComponents.get(id) == null) {
                    classComponents.put(id, type);
                } else {
                    // exit if redefinition occurs.
                    System.err.println("fatal: redefine a member " + id + " in class " + ((MentalClass) this.type).className);
                    existError = true;
                }
            }
        }
        return existError;
    }
    @Override
    public String toString() {
        return "<type>" + this.type.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
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


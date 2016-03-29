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
    public SymbolType(SymbolTable scope, MentalParser.ClassDeclarationContext classDeclCtx) {
        HashMap<String, MentalType> classComponents = new HashMap<String, MentalType>();
        this.type = new MentalClass(classComponents);
        ((MentalClass)this.type).className = classDeclCtx.className().getText();
        for (int i = 0, varCount = classDeclCtx.variableDefinition().size(); i < varCount; ++i) {
            MentalParser.VariableDefinitionContext varDefCtx = classDeclCtx.variableDefinition(i);
            if (varDefCtx.type().typeName() != null) {
                SymbolBase base = scope.table.get(varDefCtx.type().typeName().getText());
                if ((base != null && base instanceof SymbolType) ||
                        (varDefCtx.type().typeName().getText().equals(classDeclCtx.className().getText()))) {
                    MentalType type;
                    if (base != null && base instanceof SymbolType) {
                        type = ((SymbolType) base).type;
                    } else {
                        type = this.type;
                    }
                    for (int j = 0, idCount = varDefCtx.Identifier().size(); j < idCount; ++j) {
                        String id = varDefCtx.Identifier(j).getText();
                        classComponents.put(id, type);
                    }
                } else {
                    System.out.println("fatal: declarate a variable with bad type.");
                    System.exit(-1);
                }
            } else {
                MentalArray type = new MentalArray(varDefCtx.type().array());
                if (type.arrayType == MentalType.mentalUnknownType) {
                    MentalParser.ArrayContext arrCtx = varDefCtx.type().array();
                    while (arrCtx.typeName() == null) {
                        arrCtx = arrCtx.array();
                    }
                    SymbolBase base = scope.table.get(arrCtx.typeName().getText());
                    if ((base != null && base instanceof SymbolType) ||
                            (arrCtx.typeName().getText().equals(classDeclCtx.className().getText()))) {
                        if (base != null && base instanceof SymbolType) {
                            type.arrayType = ((SymbolType) base).type;
                        } else {
                            type.arrayType = this.type;
                        }
                    } else {
                        System.out.println("fatal: declarate a variable with bad type.");
                        System.exit(-1);
                    }
                }
                for (int j = 0, idCount = varDefCtx.Identifier().size(); j < idCount; ++j) {
                    String id = varDefCtx.Identifier(j).getText();
                    classComponents.put(id, type);
                }
            }
        }
    }
    public MentalType getType() {
        return this.type;
    }
}


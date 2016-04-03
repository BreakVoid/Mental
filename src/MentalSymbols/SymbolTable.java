package MentalSymbols;

import MentalType.MentalType;
import MentalType.MentalInt;
import MentalType.MentalString;
import MentalType.MentalVoid;
import MentalType.MentalBool;
import MentalType.MentalNull;
import MentalType.MentalUnknownType;

import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolTable {
    public static final MentalInt mentalInt = new MentalInt();
    public static final MentalString mentalString = new MentalString();
    public static final MentalBool mentalBool = new MentalBool();
    public static final MentalVoid mentalVoid = new MentalVoid();
    public static final MentalNull mentalNull = new MentalNull();
    public static final MentalUnknownType mentalUnknownType = new MentalUnknownType();

    private HashMap<String, SymbolBase> table;
    public int stackLayer;
    public SymbolTable() {
        this.stackLayer = 0;
        this.table = new HashMap<>();
        SymbolType symbolInt = new SymbolType();

        symbolInt.setType(mentalInt);
        symbolInt.stackLayer = 65535;
        this.table.put("int", symbolInt);

        SymbolType symbolString = new SymbolType();
        symbolString.setType(mentalString);
        symbolString.stackLayer = 65535;
        this.table.put("string", symbolString);

        SymbolType symbolBool = new SymbolType();
        symbolBool.setType(mentalBool);
        symbolBool.stackLayer = 65535;
        this.table.put("bool", symbolBool);

        SymbolType symbolVoid = new SymbolType();
        symbolVoid.setType(mentalVoid);
        symbolVoid.stackLayer = 65535;
        this.table.put("void", symbolVoid);
    }
    public SymbolTable(SymbolTable other) {
        this.stackLayer = other.stackLayer;
        this.table = new HashMap<>(other.table);
    }
    public void add(String id, SymbolBase symbol) {
        if (this.table.get(id) != null) {
            if (this.table.get(id).stackLayer < symbol.stackLayer) {
                this.table.replace(id, symbol);
            } else {
                System.err.println("fatal: redefine a identifier <" + id + "> in the same scope.");
                System.exit(-1);
            }
        } else {
            this.table.put(id, symbol);
        }
    }
    public HashMap<String, SymbolBase> getTable() {
        return this.table;
    }
    public SymbolBase getSymbol(String id) {
        return this.table.get(id);
    }
}

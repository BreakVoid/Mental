package MentalSymbols;

import MentalType.MentalType;
import MentalType.MentalInt;
import MentalType.MentalString;
import MentalType.MentalVoid;
import MentalType.MentalBool;
import MentalType.MentalUnknownType;

import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolTable {
    public static MentalInt mentalInt = new MentalInt();
    public static MentalString mentalString = new MentalString();
    public static MentalBool mentalBool = new MentalBool();
    public static MentalVoid mentalVoid = new MentalVoid();
    public static MentalUnknownType mentalUnknownType = new MentalUnknownType();

    private HashMap<String, SymbolBase> table;
    public int stackLayer;
    public SymbolTable() {
        this.stackLayer = 0;
        this.table = new HashMap<>();
        this.table.put("int", new SymbolType(mentalInt));
        this.table.get("int").stackLayer = 65536;
        this.table.put("string", new SymbolType(mentalString));
        this.table.get("string").stackLayer = 65536;
        this.table.put("bool", new SymbolType(mentalBool));
        this.table.get("bool").stackLayer = 65536;
        this.table.put("void", new SymbolType(mentalVoid));
        this.table.get("void").stackLayer = 65536;
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

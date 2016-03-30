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
public class SymbolTable extends Object {
    public static MentalInt mentalInt = new MentalInt();
    public static MentalString mentalString = new MentalString();
    public static MentalBool mentalBool = new MentalBool();
    public static MentalVoid mentalVoid = new MentalVoid();
    public static MentalUnknownType mentalUnknownType = new MentalUnknownType();

    public HashMap<String, SymbolBase> table;
    public int stackLayer;
    public SymbolTable() {
        this.stackLayer = 0;
        this.table = new HashMap<>();
        this.table.put("int", new SymbolType(mentalInt));
        this.table.put("string", new SymbolType(mentalString));
        this.table.put("bool", new SymbolType(mentalBool));
        this.table.put("void", new SymbolType(mentalVoid));
    }
    public SymbolTable(SymbolTable other) {
        this.stackLayer = other.stackLayer;
        this.table = new HashMap<>(other.table);
    }
    public void add(String id, SymbolBase symbol) {
        this.table.put(id, symbol);
    }
}

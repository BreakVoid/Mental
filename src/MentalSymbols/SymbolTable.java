package MentalSymbols;

import MentalType.MentalType;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class SymbolTable {
    public HashMap<String, SymbolBase> table;
    public SymbolTable() {
        this.table = new HashMap<>();
        this.table.put("int", new SymbolType(MentalType.mentalInt));
        this.table.put("string", new SymbolType(MentalType.mentalString));
        this.table.put("bool", new SymbolType(MentalType.mentalBool));
        this.table.put("void", new SymbolType(MentalType.mentalVoid));
    }
    public void add(String id, SymbolBase symbol) {
        this.table.put(id, symbol);
    }
}

package MentalType;

import MentalParser.MentalParser;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalType {
    public static MentalInt mentalInt = new MentalInt();
    public static MentalString mentalString = new MentalString();
    public static MentalBool mentalBool = new MentalBool();
    public static MentalVoid mentalVoid = new MentalVoid();
    public static MentalUnknownType mentalUnknownType = new MentalUnknownType();
    public MentalType() { }
    public String toString() {
        return "TypeBase";
    }
    public boolean equals(MentalType other) {
        return other != null;
    }
}


package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalString extends MentalType {
    public String toString() {
        return "string";
    }
    public boolean equals(MentalType other) {
        return other != null && other instanceof MentalString;
    }
}

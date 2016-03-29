package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalVoid extends MentalType {
    public String toString() {
        return "void";
    }
    public boolean equals(MentalType other) {
        return other != null && other instanceof MentalVoid;
    }
}

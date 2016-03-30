package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalVoid extends MentalType {
    @Override
    public String toString() {
        return "void";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof MentalVoid;
    }
}

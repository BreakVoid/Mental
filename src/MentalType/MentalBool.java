package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalBool extends MentalType {
    public String toString() {
        return "bool";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof MentalBool;
    }
}

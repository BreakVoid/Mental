package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalUnknownType extends MentalType {
    @Override
    public String toString() {
        return "unknown";
    }
    @Override
    public boolean equals(MentalType other) {
        return other != null && other instanceof MentalUnknownType;
    }
}

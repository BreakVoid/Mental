package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalInt extends MentalType{
    @Override
    public String toString() {
        return "int";
    }
    @Override
    public boolean equals(MentalType other) {
        return other != null && other instanceof MentalInt;
    }
}

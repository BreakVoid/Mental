package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalType {
    public MentalType() { }
    @Override
    public String toString() {
        return "TypeBase";
    }
    @Override
    public boolean equals(Object other) {
        return other != null && other instanceof MentalType;
    }
}


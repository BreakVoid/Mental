package MentalType;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalString extends MentalType {
    @Override
    public String toString() {
        return "string";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof MentalString) {
                return true;
            }
        }
        return false;
    }
}

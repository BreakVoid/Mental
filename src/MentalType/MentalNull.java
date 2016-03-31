package MentalType;

/**
 * Created by Songyu on 16/3/31.
 */
public class MentalNull extends MentalType {
    @Override
    public String toString() {
        return "null-pointer";
    }
    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof MentalNull || other instanceof MentalArray || other instanceof MentalClass) {
                return true;
            }
        }
        return false;
    }
}

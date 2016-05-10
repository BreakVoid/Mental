package MentalType;

/**
 * Created by Songyu on 16/4/25.
 */
public class MentalClassMember {
    public int memberID;
    public MentalType memberType;
    public MentalClassMember() {
        this.memberID = -1;
        this.memberType = null;
    }
    public MentalClassMember(int id, MentalType type) {
        this.memberID = id;
        this.memberType = type;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MentalClassMember) {
            if (((MentalClassMember) other).memberID == this.memberID) {
                if (((MentalClassMember) other).memberType.equals(this.memberType)) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "<member_id:" + Integer.toString(this.memberID) + ", type " + this.memberType.toString() + ">";
    }
}

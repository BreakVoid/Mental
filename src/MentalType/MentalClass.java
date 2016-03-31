package MentalType;

import java.util.HashMap;

/**
 * Created by Songyu on 16/3/29.
 */
public class MentalClass extends MentalType {
    public String className;
    public HashMap<String, MentalType> classComponents;
    public MentalClass() {
        this.classComponents = new HashMap<>();
        this.className = "";
    }
    public MentalClass(MentalClass other) {
        this.className = other.className;
        this.classComponents = new HashMap<>(other.classComponents);
    }
    public MentalClass(HashMap<String, MentalType> types) {
        this.classComponents = types;
        this.className = "";
    }
    @Override
    public String toString() {
        return this.className;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            if (other instanceof MentalNull) {
                return true;
            }
            if (other instanceof MentalClass) {
                if (this.className.equals(((MentalClass) other).className)) {
                    if (this.classComponents.equals(((MentalClass) other).classComponents)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

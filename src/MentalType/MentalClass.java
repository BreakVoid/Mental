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
    public MentalClass(HashMap<String, MentalType> types) {
        this.classComponents = types;
        this.className = "";
    }
    public String toString() {
        return this.className;
    }
    public boolean equals(MentalType other) {
        if (other != null) {
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

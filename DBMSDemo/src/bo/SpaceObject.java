package bo;

import java.util.Vector;

public class SpaceObject {
    private String oID;
    private String starName;
    private float magnitude;
    private String cID;
    
    public SpaceObject(String oID, String starName, float magnitude, String cID) {
        this.oID = oID;
        this.starName = starName;
        this.magnitude = magnitude;
        this.cID = cID;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(oID);
        v.add(starName);
        v.add(magnitude);
        v.add(cID);
        return v;
    }

    public String getoID() {
        return oID;
    }

    public String getStarName() {
        return starName;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public String getcID() {
        return cID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }
    
    
}

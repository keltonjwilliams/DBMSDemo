package bo;

import java.util.Vector;

public class CelestialObject {
    private String oID;
    private String oType;
    private String designation;
    
    public CelestialObject(String oID, String oType, String designation) {
        this.oID = oID;
        this.oType = oType;
        this.designation = designation;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(oID);
        v.add(oType);
        v.add(designation);
        return v;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public void setoType(String oType) {
        this.oType = oType;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getoID() {
        return oID;
    }

    public String getoType() {
        return oType;
    }

    public String getDesignation() {
        return designation;
    }
}

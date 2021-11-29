package bo;

import java.util.Vector;

public class CelestialObject {
    private int oID;
    private int oType;
    private String designation;
    private float magnitude;
    
    public CelestialObject(int oID, int oType, String designation, float magnitude) {
        this.oID = oID;
        this.oType = oType;
        this.designation = designation;
        this.magnitude = magnitude;
    }
    
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(oID);
        vector.add(oType);
        vector.add(designation);
        vector.add(magnitude);
        return vector; 
    }
    
    public int getID(){
        return this.oID;
    }
    
    public int getType(){
        return this.oType;
    }
    
    public String getDesignation(){
        return this.designation;
    }
    
    public float getMagnitude(){
        return this.magnitude;
    }
}

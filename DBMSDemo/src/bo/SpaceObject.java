package bo;

import java.util.Vector;

public class SpaceObject {
    private int oID;
    private String name;
    private double magnitude;
    private int cID;
    
    public SpaceObject(int oID, String starName, float magnitude, int cID) {
        this.oID = oID;
        this.name = starName;
        this.magnitude = magnitude;
        this.cID = cID;
    }
    
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(oID);
        vector.add(name);
        vector.add(magnitude);
        vector.add(cID);
        return vector; 
    }
    
    public int getID(){
        return this.oID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getMagnitude(){
        return this.magnitude;
    }
    
    public int getCID(){
        return this.cID;
    }
}

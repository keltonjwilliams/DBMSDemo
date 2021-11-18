package bo;

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
}

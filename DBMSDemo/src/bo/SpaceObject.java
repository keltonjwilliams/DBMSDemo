package bo;

public class SpaceObject {
    private String spectralType;
    private int oID;
    private int starName;
    private float magnitude;
    private int cID;
    
    public SpaceObject(String spectralType, int oID, int starName, float magnitude, int cID) {
        this.spectralType = spectralType;
        this.oID = oID;
        this.starName = starName;
        this.magnitude = magnitude;
        this.cID = cID;
    }
}

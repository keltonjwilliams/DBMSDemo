package bo;

import java.util.Vector;

public class Star {
    private int oID;
    private double temperature;
    private int MSID;
    
    public Star(int oID, double temperature, int MSID) {
        this.oID = oID;
        this.temperature = temperature;
        this.MSID = MSID;
    }
    
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(oID);
        vector.add(temperature);
        vector.add(MSID);
        return vector; 
    }
    
    public int getoID() {
        return oID;
    }
    
    public void setoID(int oID) {
        this.oID = oID;
    }
    
    public double gettemperature() {
        return temperature;
    }
    
    public void settemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public int getMSID() {
        return MSID;
    }
    
    public void setMSID(int MSID) {
        this.MSID = MSID;
    }
}

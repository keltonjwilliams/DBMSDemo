package bo;

import java.util.Vector;

public class Star {
    private String oID;
    private int temperature;
    private String MSID;
    
    public Star(String oID, int temperature, String MSID) {
        this.oID = oID;
        this.temperature = temperature;
        this.MSID = MSID;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(oID);
        v.add(temperature);
        v.add(MSID);
        return v;
    }
    
    public String getoID() {
        return oID;
    }
    
    public void setoID(String oID) {
        this.oID = oID;
    }
    
    public int gettemperature() {
        return temperature;
    }
    
    public void settemperature(int temperature) {
        this.temperature = temperature;
    }
    
    public String getMSID() {
        return MSID;
    }
    
    public void setMSID(String MSID) {
        this.MSID = MSID;
    }
}

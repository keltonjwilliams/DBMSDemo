package bo;

import java.util.Vector;

public class MainSeq {
    private String MSID;
    private double lyDistance;
    private String spectralType;
    
    public MainSeq(String MSID, double lyDistance, String spectralType) {
        this.MSID = MSID;
        this.lyDistance = lyDistance;
        this.spectralType = spectralType;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(MSID);
        v.add(lyDistance);
        v.add(spectralType);
        return v;
    }

    public String getMSID() {
        return MSID;
    }

    public double getLyDistance() {
        return lyDistance;
    }

    public String getSpectralType() {
        return spectralType;
    }

    public void setMSID(String MSID) {
        this.MSID = MSID;
    }

    public void setLyDistance(double lyDistance) {
        this.lyDistance = lyDistance;
    }

    public void setSpectralType(String spectralType) {
        this.spectralType = spectralType;
    }
    
    
}

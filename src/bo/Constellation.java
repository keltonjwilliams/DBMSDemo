package bo;

import java.util.Vector;

public class Constellation {

    private String cID;
    private String cName;
    private String area;
    private String symbol;

    public Constellation(String cID, String cName, String area, String symbol) {
        this.cID = cID;
        this.cName = cName;
        this.area = area;
        this.symbol = symbol;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(cID);
        v.add(cName);
        v.add(area);
        v.add(symbol);
        return v;
    }
    
    public String getcID() {
        return cID;
    }
    
    public void setcID(String cID) {
        this.cID = cID;
    }
    
    public String getcName() {
        return cName;
    }
    
    public void setcName(String cName) {
        this.cName = cName;
    }
    
    public String getarea() {
        return area;
    }
    
    public void setarea(String area) {
        this.area = area;
    }
    
    public String getsymbol() {
        return symbol;
    }
    
    public void setsymbol(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return getcName();
    }
}

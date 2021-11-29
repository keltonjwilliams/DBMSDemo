package bo;

import java.util.Vector;

public class Constellation {

    private String cName;
    private int starCount;
    private int cID;
    private int area;
    private String symbol;
    private String starList;

    public Constellation(String cName, int starCount, int cID, int area, String symbol, String starList) {
        this.cName = cName;
        this.starCount = starCount;
        this.cID = cID;
        this.area = area;
        this.symbol = symbol;
        this.starList = starList;
    }
    
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(cID);
        vector.add(cName);
        vector.add(area);
        vector.add(symbol);
        return vector; 
    }
    
    public int getID(){
        return this.cID;
    }
    
    public String getName(){
        return this.cName;
    }
    
    public int getArea(){
        return this.area;
    }
    
    public String getSymbol(){
        return this.symbol;
    }
}

package bo;

import java.util.Vector;

public class MainSeq {
    private int MSID;
    private double age;
    private String spectralType;
    
    public MainSeq(int MSID, double age, String spectralType) {
        this.MSID = MSID;
        this.age = age;
        this.spectralType = spectralType;
    }
    
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(MSID);
        vector.add(age);
        vector.add(spectralType);
        return vector; 
    }
    
    public int getID(){
        return this.MSID;
    }
    
    public double getAge(){
        return this.age;
    }
    
    public String getSpectralType(){
        return this.spectralType;
    }
}

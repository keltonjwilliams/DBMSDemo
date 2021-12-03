/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.Vector;

public class Season {
    
    private String seasonType;
    private String cID;

    public Season(String seasonType, String cID) {
        this.seasonType = seasonType;
        this.cID = cID;
    }
    
    public Vector getRow() {
        Vector v = new Vector();
        v.add(seasonType);
        v.add(cID);
        return v;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public String getcID() {
        return cID;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }
}

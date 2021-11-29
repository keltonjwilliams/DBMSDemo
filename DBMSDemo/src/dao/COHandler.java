/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.CelestialObject;
import java.util.ArrayList;
import java.util.List;
import util.SQLUtil;

/**
 *
 * @author upadhyaya
 */
public class COHandler {
    private SQLUtil sqlUtil;
    
    public COHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public int deleteCO(int oID){
        String cmdTemplate = "delete from CelestialObject where oID = %d;";
        String cmd = String.format(cmdTemplate, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateCO(int coID, int oType, String designation, float magnitude){
        String cmdTemplate = "update CelestialObject set oType=%d, designation='%s', magnitude=%f where oID = %d;";
        String cmd = String.format(cmdTemplate, oType, designation, magnitude, coID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<CelestialObject> loadCelestialObjects(String keyword){
        List<CelestialObject> cObjects = new ArrayList<>();
        
        return cObjects;
    }
}

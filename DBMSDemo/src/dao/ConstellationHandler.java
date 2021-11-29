/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.CelestialObject;
import bo.Constellation;
import java.util.ArrayList;
import java.util.List;
import util.SQLUtil;

/**
 *
 * @author upadhyaya
 */
public class ConstellationHandler {
    private SQLUtil sqlUtil;
    
    public ConstellationHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public int deleteConstellation(int cID){
        String cmdTemplate = "delete from Constellation where cID = %d;";
        String cmd = String.format(cmdTemplate, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateConstellation(int cID, String cName, int area, String symbol){
        String cmdTemplate = "update Constellation set cName='%s', area=%d, symbol='%s' where cID = %d;";
        String cmd = String.format(cmdTemplate, cName, area, symbol, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Constellation> loadConstellation(String keyword){
        List<Constellation> cObjects = new ArrayList<>();
        
        return cObjects;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.SpaceObject;
import java.util.ArrayList;
import java.util.List;
import util.SQLUtil;

/**
 *
 * @author upadhyaya
 */
public class SpaceObjectHandler {
    private SQLUtil sqlUtil;
    
    public SpaceObjectHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public int deleteSpaceObject(int oID){
        String cmdTemplate = "delete from SpaceObject where oID = %d;";
        String cmd = String.format(cmdTemplate, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateSpaceObject(int oID, String cName, double magnitude, int cID){
        String cmdTemplate = "update SpaceObject set name='%s', magnitude=%f, cID=%d where oID = %d;";
        String cmd = String.format(cmdTemplate, cName, magnitude, cID, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<SpaceObject> loadSpaceObject(String keyword){
        List<SpaceObject> cObjects = new ArrayList<>();
        
        return cObjects;
    }
}

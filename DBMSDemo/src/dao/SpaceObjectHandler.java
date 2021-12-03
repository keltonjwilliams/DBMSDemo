/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.SpaceObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public int addSpaceObject(String oID, String starName, float magnitude, String cID) {
        String cmdTemplate = "insert into SpaceObject(oID, starName, magnitude, cID) values('%s','%s','%f','%s')";
        String cmd = String.format(cmdTemplate, oID, starName, magnitude, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteSpaceObject(String oID){
        String cmdTemplate = "delete from SpaceObject where oID = '%s';";
        String cmd = String.format(cmdTemplate, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateSpaceObject(String oID, String starName, float magnitude, String cID){
        String cmdTemplate = "update SpaceObject set starName='%s', magnitude='%f', cID='%s' where oID = '%s';";
        String cmd = String.format(cmdTemplate, starName, magnitude, cID, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<SpaceObject> loadSpaceObject(String keyword){
        List<SpaceObject> so = new ArrayList<>();
        String cmdTemplate = "select oID, starName, magnitude, cID from SpaceObject where oID like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String oID = rs.getString("oID");
                String starName = rs.getString("starName");
                float magnitude = rs.getFloat("magnitude");
                String cID = rs.getString("cID");
                SpaceObject constellation = new SpaceObject(oID, starName, magnitude, cID);
                so.add(constellation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpaceObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
}

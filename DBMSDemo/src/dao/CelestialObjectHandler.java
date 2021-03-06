/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.CelestialObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SQLUtil;

/**
 *
 * @author kelto
 */
public class CelestialObjectHandler {
    private SQLUtil sqlUtil;
    
    public CelestialObjectHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public List<CelestialObject> getCelestialObjects() {
        List<CelestialObject> result = new ArrayList<>();
        String cmd = "select spaceobject.oID, oType, Designation from CelestialObject left join SpaceObject on CelestialObject.oID = SpaceObject.oID;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String oID = rs.getString("oID");
                String oType = rs.getString("oType");
                String designation = rs.getString("designation");
                CelestialObject c = new CelestialObject(oID, oType, designation);
                result.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstellationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int addCelestialObject(String oID, String oType, String designation) {
        String cmdTemplate = "insert into CelestialObject(oID, oType, designation) values('%s','%s','%s');";
        String cmd = String.format(cmdTemplate, oID, oType, designation);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteCelestialObject(String oID){
        String cmdTemplate = "delete from CelestialObject where oID = '%s';";
        String cmd = String.format(cmdTemplate, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateCelestialObject(String oID, String oType, String designation){
        String cmdTemplate = "update CelestialObject set oType='%s', designation='%s' where oID = '%s';";
        String cmd = String.format(cmdTemplate, oType, designation, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<CelestialObject> loadCelestialObjects(String keyword) {
        List<CelestialObject> co = new ArrayList<>();
        String cmdTemplate = "select oID, oType, designation from CelestialObject where oID like '%s';";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String oID = rs.getString("oID");
                String oType = rs.getString("oType");
                String designation = rs.getString("designation");
                CelestialObject c = new CelestialObject(oID, oType, designation);
                co.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CelestialObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return co;
    }
}

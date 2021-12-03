/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Star;
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
public class StarHandler {
    private SQLUtil sqlUtil;
    
    public StarHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public List<Star> getStar() {
        List<Star> result = new ArrayList<>();
        String cmd = "select oID, temperature, MSID from Star;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String oID = rs.getString("oID");
                int temperature = Integer.parseInt(rs.getString("temperature"));
                String MSID = rs.getString("MSID");
                Star s = new Star(oID, temperature, MSID);
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstellationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int addStar(String oID, int temperature, String MSID) {
        String cmdTemplate = "insert into Star(oID, temperature, MSID) values('%s','%d','%s');";
        String cmd = String.format(cmdTemplate, oID, temperature, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteStar(String MSID){
        String cmdTemplate = "delete from Star where oID = '%s';";
        String cmd = String.format(cmdTemplate, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateStar(String oID, int temperature, String MSID){
        String cmdTemplate = "update Star set temperature='%d', MSID='%s' where oID = '%s';";
        String cmd = String.format(cmdTemplate, temperature, MSID, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Star> loadStar(String keyword){
        List<Star> r = new ArrayList<>();
        String cmdTemplate = "select oID, temperature, MSID from Star where oID like '%s';";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String oID = rs.getString("oID");
                int temperature = rs.getInt("temperature");
                String MSID = rs.getString("MSID");
                Star s = new Star(oID, temperature, MSID);
                r.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CelestialObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}

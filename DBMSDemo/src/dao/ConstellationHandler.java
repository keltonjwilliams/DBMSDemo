/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Constellation;
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
public class ConstellationHandler {
    private SQLUtil sqlUtil;
    
    public ConstellationHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public List<Constellation> getConstellations() {
        List<Constellation> result = new ArrayList<>();
        String cmd = "select cID, cName, area, symbol from Constellations;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String cID = rs.getString("cID");
                String cName = rs.getString("cName");
                String area = rs.getString("area");
                String symbol = rs.getString("symbol");
                Constellation c = new Constellation(cID, cName, area, symbol);
                result.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstellationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int addConstellation(String cID, String cName, String area, String symbol) {
        String cmdTemplate = "insert into Constellations(cID, cName, area, symbol) values('%s','%s','%s','%s');";
        String cmd = String.format(cmdTemplate, cID, cName, area, symbol);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteConstellation(String cID){
        String cmdTemplate = "delete from Constellations where cID = '%s';";
        String cmd = String.format(cmdTemplate, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateConstellation(String cID, String cName, String area, String symbol){
        String cmdTemplate = "update Constellations set cName='%s', area='%s', symbol='%s' where cID = '%s';";
        String cmd = String.format(cmdTemplate, cName, area, symbol, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Constellation> loadConstellation(String keyword){
        List<Constellation> c = new ArrayList<>();
        String cmdTemplate = "select cID, cName, area, symbol from Constellations where cID like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String cID = rs.getString("cID");
                String cName = rs.getString("cName");
                String area = rs.getString("area");
                String symbol = rs.getString("symbol");
                Constellation constellation = new Constellation(cID, cName, area, symbol);
                c.add(constellation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CelestialObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}

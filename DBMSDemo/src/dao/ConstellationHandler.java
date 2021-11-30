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
}

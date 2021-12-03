package dao;


import bo.Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SQLUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kelto
 */
public class StaffHandler {
    private SQLUtil sqlUtil;
    
    public StaffHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public Staff login(String username, String password) {
        Staff stf = null;
        try {
            String cmd = String.format("select sID, sName from Staff where username = '%s' and password = '%s'", username, password);
            ResultSet rs = sqlUtil.executeQuery(cmd);
            if (rs.next()) {
                int sID = rs.getInt("sID");
                String sName = rs.getString("sName");
                stf = new Staff(sID, sName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stf;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.MainSeq;
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
public class MainSeqHandler {
    private SQLUtil sqlUtil;
    
    public MainSeqHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public List<MainSeq> getMainSeq() {
        List<MainSeq> result = new ArrayList<>();
        String cmd = "select MSID, lyDistance, spectralType from MainSeq;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String MSID = rs.getString("MSID");
                double lyDistance = Float.parseFloat(rs.getString("lyDistance"));
                String spectralType = rs.getString("spectralType");
                MainSeq ms = new MainSeq(MSID, lyDistance, spectralType);
                result.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstellationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int addMainSeq(String MSID, double lyDistance, String spectralType) {
        String cmdTemplate = "insert into MainSeq(MSID, lyDistance, spectralType) values('%s','%d','%s')";
        String cmd = String.format(cmdTemplate, MSID, lyDistance, spectralType);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteMainSeq(String MSID){
        String cmdTemplate = "delete from MainSeq where MSID = %s;";
        String cmd = String.format(cmdTemplate, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateMainSeq(String MSID, double lyDistance, String spectralType){
        String cmdTemplate = "update MainSeq set lyDistance='%f', spectralType='%s' where MSID = '%s';";
        String cmd = String.format(cmdTemplate, lyDistance, spectralType, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<MainSeq> loadMainSeq(String keyword){
        List<MainSeq> r = new ArrayList<>();
        String cmdTemplate = "select MSID, lyDistance, spectralType from MainSeq where MSID like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String MSID = rs.getString("MSID");
                double lyDistance = Float.parseFloat(rs.getString("lyDistance"));
                String spectralType = rs.getString("spectralType");
                MainSeq ms = new MainSeq(MSID, lyDistance, spectralType);
                r.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CelestialObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}

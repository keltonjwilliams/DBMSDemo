/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Season;
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
public class SeasonHandler {
    private SQLUtil sqlUtil;
    
    public SeasonHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public List<Season> getSeasons() {
        List<Season> result = new ArrayList<>();
        String cmd = "select seasonType, cID from Seasons;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String seasonType = rs.getString("seasonType");
                String cID = rs.getString("cID");
                Season s = new Season(seasonType, cID);
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstellationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int addSeason(String seasonType, String cID) {
        String cmdTemplate = "insert into Seasons(seasonType, cID) values('%s','%s')";
        String cmd = String.format(cmdTemplate, seasonType, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int deleteSeason(String cID){
        String cmdTemplate = "delete from Seasons where cID = '%s';";
        String cmd = String.format(cmdTemplate, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateSeason(String seasonType, String cID){
        String cmdTemplate = "update Seasons set seasonType='%s' where cID = '%s';";
        String cmd = String.format(cmdTemplate, seasonType, cID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Season> loadSeason(String keyword){
        List<Season> sh = new ArrayList<>();
        String cmdTemplate = "select seasonType, cID from Seasons where cID like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                String seasonType = rs.getString("seasonType");
                String cID = rs.getString("cID");
                Season s = new Season(seasonType, cID);
                sh.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CelestialObjectHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sh;
    }
}

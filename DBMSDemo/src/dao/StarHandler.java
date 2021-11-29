/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Star;
import java.util.ArrayList;
import java.util.List;
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
    
    public int deleteStar(int MSID){
        String cmdTemplate = "delete from Star where oID = %d;";
        String cmd = String.format(cmdTemplate, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateStar(int oID, double temperature, int MSID){
        String cmdTemplate = "update Star set temperature=%f, MSID=%d where oID = %d;";
        String cmd = String.format(cmdTemplate, temperature, MSID, oID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Star> loadStar(String keyword){
        List<Star> cObjects = new ArrayList<>();
        
        return cObjects;
    }
}

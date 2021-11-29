/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.MainSeq;
import java.util.ArrayList;
import java.util.List;
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
    
    public int deleteMainSeq(int MSID){
        String cmdTemplate = "delete from MainSeq where MSID = %d;";
        String cmd = String.format(cmdTemplate, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateMainSeq(int MSID, double age, String spectralType){
        String cmdTemplate = "update MainSeq set age=%f, spectralType='%s' where MSID = %d;";
        String cmd = String.format(cmdTemplate, age, spectralType, MSID);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<MainSeq> loadMainSeq(String keyword){
        List<MainSeq> cObjects = new ArrayList<>();
        
        return cObjects;
    }
}

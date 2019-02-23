package main.java.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import main.java.dto.FullSinfor;

public class AllType2FullSInfor {

    
    public FullSinfor Map2FullSInfor(Map map){
        FullSinfor fullSinfor = new FullSinfor();
        HashMap hashmap = (HashMap) map;
        fullSinfor.setName((String)hashmap.get("name"));
        fullSinfor.setPolitical((String)(String)hashmap.get("political"));
        fullSinfor.setSex((String)hashmap.get("sex"));
        fullSinfor.setProvince((String)hashmap.get("province"));
        fullSinfor.setExamineeNum((String)hashmap.get("examineeNum"));
        fullSinfor.setAddress((String)hashmap.get("address"));
        fullSinfor.setIdentityNum((String)hashmap.get("identityNum"));
        fullSinfor.setPhone((String)hashmap.get("phone"));
        fullSinfor.setAcceptPerson((String)hashmap.get("acceptPerson"));
        return fullSinfor;
    }
    
    
    
    public FullSinfor ResultSet2FullSInfor(ResultSet  set) throws SQLException{
        ResultSet rs = set;
        FullSinfor fullSinfor = new FullSinfor();
        fullSinfor.setS_id(Integer.parseInt(rs.getString("s_id")));
        fullSinfor.setName(rs.getString("name"));
        fullSinfor.setPolitical(rs.getString("political"));
        fullSinfor.setSex(rs.getString("sex"));
        fullSinfor.setProvince(rs.getString("province"));
        fullSinfor.setExamineeNum(rs.getString("examineeNum"));
        fullSinfor.setAddress(rs.getString("address"));
        fullSinfor.setIdentityNum(rs.getString("identityNum"));
        fullSinfor.setPhone(rs.getString("phone"));
        fullSinfor.setAcceptPerson(rs.getString("acceptPerson"));
        fullSinfor.setGrades(rs.getString("grades"));
        return fullSinfor;
        
    }
}

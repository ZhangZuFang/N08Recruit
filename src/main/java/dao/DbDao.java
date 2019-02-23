package main.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.dto.FullSinfor;

public interface DbDao {

    String isExit(String sql);

    ArrayList getBS_infor(String d_id, String p_id);

    FullSinfor getSInfoById(int id);

    List getDepartments();

    int getDepartmentIdByName(String sql01);

    List getProName(int depatrId);

    Map getProAndDepartByS_id(String s_idString);

    Map getProvinceNames();

    List getFactNoFromSinfor( Map map);

    void factNum2planProvinceNo(List list);

    List  getPlan_FactNoAndProvinceName();

    String loginForPass(String name, String paw);

}

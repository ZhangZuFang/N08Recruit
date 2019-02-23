package main.java.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.dto.DepartDto;
import main.java.dto.FullSinfor;

import org.springframework.web.multipart.MultipartFile;

public interface SqlInterface {



    String isExit(String sql);

    ArrayList getBS_infor(String d_id,String p_id);


    int ReaderExcel2Db(MultipartFile file) throws ClassNotFoundException, SQLException, IOException;

    FullSinfor getSInfoById(int id);

    List getDepartments();

    int getDepartmentIdByName(String departName);

    List getProName(int depatrId);

    Map getProAndDepartByS_id(String s_id);

    Map getProvinceNames();

    List getFactNoFromSinfor(Map map);

    void factNum2planProvinceNo(List list);

    List getPlan_FactNoAndProvinceName();

    String loginForPass(String name, String paw);
    

}

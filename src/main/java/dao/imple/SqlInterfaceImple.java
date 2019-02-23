package main.java.dao.imple;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.dao.SqlInterface;
import main.java.dto.DepartDto;
import main.java.dto.FullSinfor;
import main.java.util.DataUtil;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class SqlInterfaceImple implements SqlInterface {

    DbDaoImple daoImple = new DbDaoImple();

    @Override
    public String isExit(String sql) {
        String id = daoImple.isExit(sql);
        return id;
    }

    @Override
    public ArrayList getBS_infor(String d_id, String p_id) {
        ArrayList arrayList = daoImple.getBS_infor(d_id, p_id);
        return arrayList;
    }

    /*
     * 把excel中的数据存入Db
     */
    @Override
    public int ReaderExcel2Db(MultipartFile file) throws ClassNotFoundException, SQLException, IOException {
        if (file.getOriginalFilename().equalsIgnoreCase("student.xls")) {
            int judge = daoImple.insertData("s_infor", file);
            return judge;
        } else if (file.getOriginalFilename().equalsIgnoreCase("professional.xls")) {
            System.out.println("------+++++++++-------------"+file.getOriginalFilename());
            int judge = daoImple.insertData("professional", file);
            return judge;
        } else {
            int judge = daoImple.insertData("department", file);
            return judge;
        }
    }

    @Override
    public FullSinfor getSInfoById(int id) {
        FullSinfor fullSinfor = daoImple.getSInfoById(id);
        return null;
    }

    @Override
    public List getDepartments() {
        List list = daoImple.getDepartments();
        return list;
    }

    @Override
    public int getDepartmentIdByName(String departName) {
        int DepartmentId = daoImple.getDepartmentIdByName(departName);
        return DepartmentId;
    }

    @Override
    public List getProName(int depatrId) {
        List list = daoImple.getProName(depatrId);
        return list;
    }

    @Override
    public Map getProAndDepartByS_id(String s_idString) {
        Map map = daoImple.getProAndDepartByS_id(s_idString);
        return map;
    }
    @Override
    public Map getProvinceNames() {
          Map  map = daoImple.getProvinceNames();
        return map;
    }
    
    
    @Override
    public List getFactNoFromSinfor( Map map) {
         List list  = daoImple.getFactNoFromSinfor( map);
        return list;
    }
    
    @Override
    public void factNum2planProvinceNo(List list) {
        daoImple.factNum2planProvinceNo( list);
        
    }

    
    @Override
    public List getPlan_FactNoAndProvinceName() {
         List list=  daoImple.getPlan_FactNoAndProvinceName();
        return list;
    }
    
    @Override
    public String loginForPass(String name, String paw) {
          String yesOrNo = daoImple.loginForPass(name,paw);
        return yesOrNo;
    }

}

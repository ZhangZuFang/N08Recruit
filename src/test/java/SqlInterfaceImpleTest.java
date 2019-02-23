package test.java;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.dao.imple.DbDaoImple;
import main.java.dao.imple.SqlInterfaceImple;
import main.java.dto.FullSinfor;
import main.java.util.DataUtil;
import net.sf.json.JSONArray;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;


// this test for mysql db  
public class SqlInterfaceImpleTest {

    /*
     * 这里的代码是测试来自网页的数据与后台数据库交互的情况 1、页面的数据跟着请过来，以单个数据类型、json、xml
     * 2、以json或是xml形式传递过来的数据要进行转换
     */

    // 這個方法直接調用dbDaoImple，里面成员变量的初始化通过对配置文件的读取得到
    SqlInterfaceImple imple = new SqlInterfaceImple();

    @Test
    public void testLogin() {
        String uName = "admin";
        String pword = "1234";
        String sql = "select id from t_user  where userName='" + uName + "'  and  passWord =" + pword;
        DbDaoImple dbDaoImple = new DbDaoImple();
        String id = dbDaoImple.isExit(sql);
        assertEquals("1", id);
    }

    // 这个测试通过SqlInterfaceImple调用dbDaoImple，那么就需要注入dbDaoImple
    // 以这个测试为开始了
    // 这个测试是判断用户是否存在
    @Test
    public void testLogin01() {
        String uName = "shan";
        String pword = "123456";
        String sql = "select id from t_user  where userName='" + uName + "'  and  passWord =" + pword;
        // String sql = "select id from s_infor  where s_major='S'";

        String id = imple.isExit(sql);
        assertEquals("1", id);

    }

    // // 从”教育局“数据库得到报考该校s信息，然后通过所报专业进行分类
    // @Test
    // public void getBInfor() {
    // String major = "网络工程";
    // // String major = "S";
    // String sql = "select * from s_infor where s_major ='" + major + "'";
    // ArrayList ls = imple.getBS_infor(sql);
    // assertEquals(ls.size(), 1);
    // }

    // 在controller中得到的应该是excel文件的输入流
    /*
     * @Test public void ReaderExcel2DbTest() throws FileNotFoundException,
     * ClassNotFoundException, SQLException { DbDaoImple dbDaoImple = new
     * DbDaoImple(); InputStream is = new
     * FileInputStream("D://studentInfor.xls"); dbDaoImple.insertData("s_infor",
     * is);// tbname，为要插入的数据表名 }
     */

    @Test
    public void showAllInfo() {

        // String d_id ="8" ,p_id ="29";
        String d_id = null, p_id = null;
        // 返回的结果，list里面放的是“对象”，一个对象是一查询结果/记录
        ArrayList list = imple.getBS_infor(d_id, p_id);
        for (int i = 0; i < list.size(); i++) {
            FullSinfor fullSinfor = (FullSinfor) list.get(i);
            JSONArray jsonArray = JSONArray.fromObject(fullSinfor);
            System.out.println(jsonArray);
        }
    }

    /*
     * 打印“通知书”--单张打印
     */
    @Test
    public void InformTemplate() {
        int id = 17;
        FullSinfor fullSinfor = imple.getSInfoById(id);

    }

    @Test
    public void getProfessionalByDepartId() {
        String departName = "外语系";
        int departId = imple.getDepartmentIdByName(departName);
        System.out.println(departId);
        List list = imple.getProName(departId);
        System.out.println(list);
    }

    @Test
    public void getProvinces() {
        Map map = imple.getProvinceNames();
        System.out.println(map);
    }

    @Test
    public void getFactNoFromSinfor() {
        Map map = new HashMap();
        map.put("province0", "安徽省");
        map.put("province1", "浙江省");
        map.put("province2", "山东省");
        map.put("province3", "江苏省");
        map.put("province4", "海南省");
        map.put("province5", "内蒙古");
        List list = imple.getFactNoFromSinfor(map);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    @Test
    public void factNum2planProvinceNo() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("安徽省", 11);
        map.put("浙江省", 10);
        map.put("山东省", 1);
        map.put("江苏省", 8);
        map.put("海南省", 11);
        map.put("内蒙古", 5);
        list.add(map);
        imple.factNum2planProvinceNo(list);
    }

    @Test
    public void planNoAndfactNo() {
        List rowsList = imple.getPlan_FactNoAndProvinceName();
        JSONArray jsonArray = JSONArray.fromObject(rowsList);
        System.out.println(jsonArray);
        System.out.println(rowsList);
    }

        @Test
        public void login() {
            String name = "admin";
            String paw = "admin";
            SqlInterfaceImple imple = new SqlInterfaceImple();
            String validate = imple.loginForPass(name, paw);
            System.out.println(validate);
        }

}

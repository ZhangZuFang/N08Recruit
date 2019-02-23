package main.java.dao.imple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.multipart.MultipartFile;

import main.java.dao.DbDao;
import main.java.dto.FullSinfor;
import main.java.dto.ProfessionalDto;
import main.java.util.AllType2FullSInfor;
import main.java.util.DataUtil;
import main.java.util.ExcelReader;

public class DbDaoImple implements DbDao {

    DataUtil dataUtil = new DataUtil();

    JdbcTemplate jdbcTemplate = dataUtil.getJdbcTemplate();

    @Override
    public String isExit(String sql) {
        int id = jdbcTemplate.queryForInt(sql);
        String ID = String.valueOf(id);
        return ID;
    }

    @Override
    public ArrayList getBS_infor(String d_id, String p_id) {
        System.out.println(d_id + p_id);
        if (d_id == null || p_id == null) {
            String sql = "select * from  s_infor";
            Collection collection = jdbcTemplate.query(sql, new FullSinforMapper());
            return (ArrayList) collection;
        } else {
            int D_id = Integer.parseInt(d_id);
            int P_id = Integer.parseInt(p_id);
            String sql = "select * from  s_infor where d_id=? and p_id=?";
            Object[] args = { D_id, P_id };
            Collection collection = jdbcTemplate.query(sql, args, new FullSinforMapper());
            return (ArrayList) collection;
        }
    }

    private static final class FullSinforMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            AllType2FullSInfor allType2FullSInfor = new AllType2FullSInfor();
            FullSinfor fullSinfor = allType2FullSInfor.ResultSet2FullSInfor(rs);
            return fullSinfor;
        }
    }

    public int insertData(String tbName, MultipartFile file) throws ClassNotFoundException, SQLException {

        DataUtil dataUtil = new DataUtil();
        Connection conn = dataUtil.getConn();

        try {
            // casilin:插入数据，先从excel中读取数据
            // InputStream is = new FileInputStream("D://studentInfor.xls");
            ExcelReader excelReader = new ExcelReader();
            String[] colName = excelReader.readExcelTitle(file.getInputStream());

            // 开始建立插入的sql语句,每一次插入的开头都是不变的,都是字段名
            StringBuffer sqlBegin = new StringBuffer("insert into " + tbName + "(");
            // 获取字段名，并添加入sql语句中
            for (int i = 0; i < colName.length; i++) {
                sqlBegin.append(colName[i]);
                if (i != colName.length - 1) {
                    sqlBegin.append(",");
                }
            }
            sqlBegin.append(") values(");
            file.getInputStream().close();

            // 下面读取字段内容
            POIFSFileSystem fs;
            HSSFWorkbook wb;
            HSSFSheet sheet;
            HSSFRow row;

            InputStream is = file.getInputStream();
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(0);

            // 得到总行数
            int rowNum = sheet.getLastRowNum();
            row = sheet.getRow(0);
            int colNum = row.getPhysicalNumberOfCells();
            // 正文内容应该从第二行开始,第一行为表头的标题
            String sql = new String(sqlBegin);
            String temp;
            for (int i = 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                int j = 0;
                while (j < colNum) {
                    temp = excelReader.getStringCellValue(row.getCell((short) j)).trim();

                    // 日期的特殊处理
                    if (colName[j].indexOf("date") != -1) {
                        if (temp != "") {
                            temp = temp.substring(0, temp.length() - 2);
                            // excel是以1990年为基数的，而java中的date是以1970年为基数的。所以要扣除差
                            // 25569天
                            Date d = new Date((Long.valueOf(temp) - 25569) * 24 * 3600 * 1000);
                            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                            temp = "'" + formater.format(d) + "'";
                        }

                    }
                    if (temp == "") {
                        temp = null;
                    }
                    sql = sql + temp;
                    if (j != colNum - 1) {
                        sql = sql + ",";
                    }
                    j++;
                }
                sql = sql + ")";
                System.out.println("------------------------sql语句----------------------------");
                System.out.println(sql.toString());
                PreparedStatement ps = conn.prepareStatement(sql.toString());
                ps.execute();
                ps.close();
                sql = "";
                sql = sqlBegin.toString();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        // 如果操作成功则返回1
        return 1;
    }

    @Override
    public FullSinfor getSInfoById(int id) {
        String sql = "select * from s_infor where id = " + id;
        // queryForList()返回的list，数据类型是Map
        List list = jdbcTemplate.queryForList(sql);
        // 通常不直接用Map类，下面以HashMap为例
        HashMap hashmap = (HashMap) list.get(0);
        AllType2FullSInfor allType2FullSInfor = new AllType2FullSInfor();
        FullSinfor fullSinfor = allType2FullSInfor.Map2FullSInfor(hashmap);
        System.out.println(fullSinfor.toString());
        return fullSinfor;
    }

    @Override
    public List getDepartments() {
        String sql = "select * from department ";
        List list = jdbcTemplate.queryForList(sql);
        return list;

    }

    @Override
    public int getDepartmentIdByName(String departName) {

        String sql = "select id from department where  departName =  " + "'" + departName + "'";
        int departId = jdbcTemplate.queryForInt(sql);
        return departId;

    }

    @Override
    public List getProName(int departId) {
        String sql = "select  p_id  ,  proName   from professional  where d_id=" + departId;
        System.out.println(sql);
        Collection collection = jdbcTemplate.query(sql, new ProfessionalMapper());
        return (ArrayList) collection;
    }

    private static final class ProfessionalMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProfessionalDto professionalDto = new ProfessionalDto();
            professionalDto.setProName(rs.getString("proName"));
            professionalDto.setP_id(Integer.parseInt(rs.getString("p_id")));
            return professionalDto;
        }
    }

    @Override
    public Map getProAndDepartByS_id(String s_idString) {
        Map<String, String> responseMap = new HashMap<String, String>();
        // 通过s_id得到p_id、d_id
        int s_id = Integer.parseInt(s_idString);
        String sql01 = "select  name ,p_id,d_id from s_infor where s_id =" + s_id;
        List list = jdbcTemplate.queryForList(sql01);
        System.out.println("输出p_id  :" + ((Map) list.get(0)).get("p_id"));
        System.out.println("输出d_id  : " + ((Map) list.get(0)).get("d_id"));

        // 得到p_id，并通过p_id查询“专业”
        Integer integerP_id = (Integer) ((Map) list.get(0)).get("p_id");
        int intP_id = integerP_id.intValue();
        String sql02 = "select proName from  professional where p_id = " + intP_id;
        Map<String, Object> map02 = jdbcTemplate.queryForMap(sql02);
        String proName = (String) map02.get("proName");
        System.out.println("专业 :" + proName);

        // 得到d_id,通过d_id查询“院系”
        Integer integerD_id = (Integer) ((Map) list.get(0)).get("d_id");
        int intD_id = integerD_id.intValue();
        String sql03 = "select departName from department where departId=" + intD_id;
        Map<String, Object> map03 = jdbcTemplate.queryForMap(sql03);
        String departName = (String) map03.get("departName");
        System.out.println("院系：" + departName);

        responseMap.put("departName", departName);
        responseMap.put("proName", proName);
        responseMap.put("name", (String) ((Map) list.get(0)).get("name"));

        // ---嗯！是的--------------------------------这种分几次查询耗费与数据库连接资源
        return responseMap;
    }

    @Override
    public Map getProvinceNames() {
        String sql = "select  province from  planProvinceNo  ";
        List list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size() + "  个省份");
        Map map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            String value = (String) ((Map) list.get(i)).get("province");
            map.put("province" + i, value);
        }

        return map;
    }

    @Override
    public List getFactNoFromSinfor(Map map) {
        List list = new ArrayList();
        Map map01 = new HashMap();
        for (int i = 0; i < map.size(); i++) {
            String province = (String) map.get("province" + i);
            String sql = " select count(province) from s_infor where province=" + "'" + province + "'";
            int Num = jdbcTemplate.queryForInt(sql);
            System.out.println(province + "招收到人数 :" + Num);
            map01.put(province, Num);
            list.add(map01);
        }
        return list;
    }

    @Override
    public void factNum2planProvinceNo(List list) {
        Map map = (Map) list.get(0);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String province = (String) iterator.next();
            int factNo = (Integer) map.get(province);
            System.out.println(province + " : " + factNo);
            jdbcTemplate.update("update planProvinceNo  set  factNo = ? where  province  = ?", new Object[] { factNo,
                    province });
        }

    }

    @Override
    public List getPlan_FactNoAndProvinceName() {
        List rows = jdbcTemplate.queryForList("SELECT  province ,planNo ,factNo,province_id  from   planprovinceno");
        return rows;

    }

    @Override
    public String loginForPass(String name, String paw) {
        String sql = "select * from  account ";
        Map map = jdbcTemplate.queryForMap(sql);
        String userName = (String) map.get("u_name");
        String passWord = (String) map.get("u_pwd");
        if (name.equals(userName) && paw.equals(passWord)) {
            return "yes";
        }
        return "no";
    }
}

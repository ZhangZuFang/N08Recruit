package main.java.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import main.java.dao.imple.SqlInterfaceImple;

/**
 * 
 * 项目名称：N06Recruit 类名称：ViewController 类描述： 创建人：Administrator 创建时间：2015年4月25日
 * 下午5:18:04 修改人：Administrator 修改时间：2015年4月25日 下午5:18:04 修改备注：
 * 
 * @version
 * 
 */

@SuppressWarnings("deprecation")
@Controller
public class ViewController {

	@Autowired
    SqlInterfaceImple sqlImple;

    /*
     * 
     * @RequestMapping("/login.do") 
     * public ModelAndView Login(HttpServletRequest request, HttpServletResponse response) throws Exception 
     * { 
     *     ModelAndView ma  = new ModelAndView("jsp/login.jsp");
     *      return ma; 
     * }
     */

	/*该请求返回静态页面*/
    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginSubmit.do")
    public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mav01 = new ModelAndView("index");
        ModelAndView mav02 = new ModelAndView("login");
        String name = request.getParameter("username");
        String paw = request.getParameter("pwd");
        if (name != null && paw != null) {
            String yesOrNo = sqlImple.loginForPass(name, paw);
            // 在session中设置属性，保存用户姓名和密码，确定当前用户的身份，为了判断是否已经登陆，退出时清空session
            session.setAttribute("user", name);
            session.setAttribute("passWord", paw);
            if (yesOrNo.equals("yes")) {
                return mav01;
            } else {
                return mav02;
            }
        } else {
            return mav02;
        }
    }

    @RequestMapping("/A.do")
    public String ARequest() {
        return "MajorPNum";
    }

    /*
     * 查询对应专业的所有学员
     * 
     * @RequestMapping("/SMNumber.do") public void BSinfor(HttpServletRequest
     * request, HttpServletResponse response) throws Exception {
     * System.out.println("1111111"); String Sname =
     * request.getParameter("Mtype"); String sql = "select  *  from s_infor ";
     * List list = sqlImple.getBS_infor(sql); FullSinfor fullSinfor =
     * (FullSinfor) list.get(0); JSONArray jsonArray =
     * JSONArray.fromObject(fullSinfor); // System.out.println(jsonArray);
     * response.getWriter().print(jsonArray); }
     */

    @RequestMapping("/import.do")
    public ModelAndView sFullInfo() {
        System.out.println("点击了“导入”");
        return new ModelAndView("import");
    }

    @RequestMapping(value = "/excelSave.do", method = RequestMethod.POST)
    public ModelAndView readerExcel2Db(@RequestParam("filename")
    MultipartFile file, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("import");
        System.out.println(file.getName());
        System.out.println("判斷是否爲空" + file.isEmpty());
        System.out.println("得到原文件名" + file.getOriginalFilename());
        System.out.println("得到輸入流" + file.getInputStream());
        int judge = sqlImple.ReaderExcel2Db(file);
        // 這裏做一個判斷，返回是1的話表示上傳導入數據庫成功
        // 返回爲0，表示上傳失敗，界面根據這個值判斷，輸出提示信息
        mav.addObject("judgeNumber", judge);
        return mav;
    }

    /* 显示导入的所有学员信息 */
    @RequestMapping("/allStudents.do")
    public ModelAndView allStudentsPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("allStudents");
        return mav;
    }

    // @RequestMapping("/searchAllStudent.do")
    // public @ResponseBody JqGridData
    // searchAllStudent(HttpServletRequest request, HttpServletResponse
    // response) {
    //
    // JqGridData jqGridData = new JqGridData();
    // String sql = "select * from  s_infor";
    // ArrayList list = sqlImple.getBS_infor(sql);
    // jqGridData.setGridModel(list);
    //
    // return jqGridData;
    // }

    @RequestMapping("/searchAllStudent.do")
    public @ResponseBody
    Map searchSInfor(HttpServletRequest request, HttpServletResponse response) {
        String d_idString = request.getParameter("d_id");
        String p_idString = request.getParameter("p_id");
        ArrayList dataRows = sqlImple.getBS_infor(d_idString, p_idString);

        Map map = new HashMap();
        map.put("dataRows", dataRows);
        return map;
    }

    @RequestMapping("/queryStudent.do")
    public ModelAndView PrintInform() {
        List departList = sqlImple.getDepartments();
        ModelAndView mav = new ModelAndView("queryStudent");
        mav.addObject("departList", departList);
        return mav;
}

    @RequestMapping("/searchProfessional.do")
    public void searchProfessional(HttpServletRequest request, HttpServletResponse response) {
        // 通过院系id在表(professional)中得到对应的“专业”
        System.out.println("11111");
        String departId = request.getParameter("departId");
        int depart_id = Integer.parseInt(departId);
        List list = sqlImple.getProName(depart_id);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        // 这个里面的异常就用try-catch处理了，再向外抛就不现实了
        try {
            // 这个响应的编码和响应到的jsp的编码要一致
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            System.out.println("表示响应的输出流有错误");
            e.printStackTrace();
        }
    }

    @RequestMapping("/printByS_id.do")
    public void printByS_id(HttpServletRequest request, HttpServletResponse response) {
        String s_idString = request.getParameter("s_id");
        System.out.println("异步请求传递到Controller的将s_id : " + s_idString);
        Map contentMap = sqlImple.getProAndDepartByS_id(s_idString);
        System.out.println("在Controller中得到" + contentMap.get("proName"));

        HWPFDocument document = ViewController.replaceDoc("D:\\template.doc", contentMap);
        if (document != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                // 把"document"写入“字符数组输出流”中
                document.write(byteArrayOutputStream);
                OutputStream outputStream = new FileOutputStream("D:\\template.doc");
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.close();
            } catch (IOException e) {
            }
        }

    }

    // 把得到"专业和院系信息添加到模板"
    public static HWPFDocument replaceDoc(String templatePath, Map<String, String> contentMap) {
        try {
            // 读取模板
            FileInputStream tempFileInputStream = new FileInputStream(new File(templatePath));
            HWPFDocument document = new HWPFDocument(tempFileInputStream);
            // 读取文本内容
            Range bodyRange = document.getRange();
            // 替换内容
            for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            	// with a replaceText compiler error , so ignore it firstly 
            	// reset up the 毕业论文项目  2018-1-1 
               /* bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());*/
            }
            return document;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/ataAnalyse.do")
    public ModelAndView ataAnalyse(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav01 = new ModelAndView("dataAnalyse");
        ModelAndView mav02 = new ModelAndView("demo");
        // 查询招生省份，从表“planProvinceNo”中得到
        Map map = sqlImple.getProvinceNames();
        // 在表“s_infor”中取得各省实际招生人数
        List list01 = sqlImple.getFactNoFromSinfor(map);
        // 把实际招收的每个省的人数放到planProvinceNo表对应的的“factNo”字段下
        sqlImple.factNum2planProvinceNo(list01);
        // 从planProvinceNo表中取得“planNo”和“factNo”
        List list02 = sqlImple.getPlan_FactNoAndProvinceName();
        System.out.println(list02);
        if (request.getParameter("planNo") == null) {
            mav01.addObject("inforFromPlanProvincNo", list02);
            return mav01;
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++"+request.getParameter("planNo"));
            System.out.println(request.getParameter("factNo"));
            return mav02;
        }
    }

    @RequestMapping("/quit.do")
    public ModelAndView quit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("passWord");
        return mav;
    }
    
    @RequestMapping("/modifyPwd.do")
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView  mav =new ModelAndView("modifyPwd");
        return mav;
    }
    
/*11-------------------------------------------------------------------------------------------------------11*/
    @RequestMapping("/dataAnalyse.do")
    public ModelAndView dataAnalyse(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav01 = new ModelAndView("dataAnalyse");
        ModelAndView mav02 = new ModelAndView("demo");
        // 查询招生省份，从表“planProvinceNo”中得到
        Map map = sqlImple.getProvinceNames();
        // 在表“s_infor”中取得各省实际招生人数
        List list01 = sqlImple.getFactNoFromSinfor(map);
        // 把实际招收的每个省的人数放到planProvinceNo表对应的的“factNo”字段下
        sqlImple.factNum2planProvinceNo(list01);
        // 从planProvinceNo表中取得“planNo”和“factNo”
        List list02 = sqlImple.getPlan_FactNoAndProvinceName();
        System.out.println(list02);
        if (request.getParameter("planNo") == null) {
            mav01.addObject("inforFromPlanProvincNo", list02);
            return mav01;
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++"+request.getParameter("planNo"));
            System.out.println(request.getParameter("factNo"));
            return mav02;
        }
    }

    @RequestMapping("/downPhoto.do")
    public  void   getPhoto(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-------------------------1111111111111111111111----------------------------");
        /*Map<String, Object> resultMap = new HashMap<String, Object>();
        String url = "D:\\apache\\doucheng\\picfiles\\current\\30780766-f897-44f5-9bc1-a28e174319e5\\1434102459511.png";
        File photoFile = new File(url);
        byte fileArray[] = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(photoFile);
            fileArray = IOUtils.toByteArray(fileInputStream);
        } catch (FileNotFoundException e) {
            resultMap.put("message", "获取图片失败");
            e.printStackTrace();
        } catch (IOException e) {
            resultMap.put("message", "处理指定图片产生IO异常，图片不存在");
        } finally {
            this.returnAjaxRequestMap(response, resultMap);
        }
        MediaType IMAGE_PNG = new MediaType("image", "png"); // content-type的值也是对象，其实就是image/png
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(IMAGE_PNG);*/
        
       // ResponseEntity<byte[]> responseEntity =new ResponseEntity<byte[]>(fileArray, headers, HttpStatus.OK);
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print("dedeed");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }

    /**
     * 
     * 异步返回map
     * 
     * @param 参数
     * @return 返回
     * @Exception
     * @since
     */
    protected void returnAjaxRequestMap(HttpServletResponse response, Map<String, Object> map) {
        try {
            response.getWriter().println(JSONObject.fromObject(map).toString());
        } catch (IOException e) {
            return;
        }
    }

    /**
     * 异步请求 status返回状态 returnMessage 返回携带信息
     * 
     * @param response
     * @param status
     * @param errorMessage
     */
    protected void returnAjaxRequestMessage(HttpServletResponse response, String status, String returnMessage) {
        try {
            Map<String, String> map3 = new HashMap();
            map3.put("status", status);
            map3.put("message", returnMessage);
            response.getWriter().println(JSONObject.fromObject(map3).toString());
        } catch (IOException e) {
            return;
        }
    }

    
    
}

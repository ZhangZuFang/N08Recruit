package test.java;


import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.java.util.xmlUtils.XmlValidate;

import org.h2.tools.Server;
import org.junit.After;
import org.junit.Test;

import test.java.h2.H2Utils;

public class H2Test {

	private final String sqlFileListsXml = "sqlFileLists.xml";
	 Connection conn = null;
	 Statement state  = null;
	 ResultSet resultSet = null;
	 BufferedReader reader = null;  
	 Server server =null;
	
	 H2Utils h2 = new H2Utils();
	 XmlValidate xmlValidate = new XmlValidate();
    
	 
	 @After
	 public void shutDown(){
		 if(server!=null){
			 server.shutdown();
		 }
		 
	 }
	
/*	@Test
	public void setUpTest(){
		Server server =h2.setUpH2();
		String status = server.getStatus();
		System.out.println(" h2 server status :" +status );
	}*/
	
	@Test
	public void initDBDataTest(){
		 server =h2.setUpH2();
		String status = server.getStatus();
		if(status.contains("running")){
			conn = h2.getconn();
		}
		
		try {
			state = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// init db with the sql file
		// 获得配置sql的xml文件路径
		String filePath = XmlValidateTest.class.getResource(sqlFileListsXml).getPath();
		
		//读取xml中指定元素的内容
		List<String> spcElementList = xmlValidate.readSpecElementsValue(filePath, "sqlfile");
		
		//获取sql文件所在package的path
		String sqlFilePath = XmlValidateTest.class.getResource("sqlfile").getPath();
		
		//依次init sql file中的数据
		for(int i = 0 ; i<spcElementList.size();i++){
			StringBuffer buffer = new StringBuffer();
			String sqlFile = spcElementList.get(i);
			buffer.append(sqlFilePath+File.separator);
			buffer.append(sqlFile);
			
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(buffer.toString()), "UTF-8"));
				String sql;
				while((sql=reader.readLine())!=null){
					state.addBatch(sql);
				}
				state.executeBatch();
				
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}
		
		String testSql = "select name from s_infor where s_id = '100' ";
		try {
			resultSet = state.executeQuery(testSql);
			while(resultSet.next()){
				
				String name = resultSet.getString("name");
				assertEquals("张无忌",name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

package main.java.listener;

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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

import main.java.util.xmlUtils.XmlValidate;
import test.java.XmlValidateTest;
import test.java.h2.H2Utils;

public class H2InitListener implements ServletContextListener {
	
	
	
	
	public H2InitListener() {
		
	} 
	
	private final String sqlFileListsXml = "sqlFileLists.xml";
	 Connection conn = null;
	 Statement state  = null;
	 ResultSet resultSet = null;
	 BufferedReader reader = null;  
	 Server server =null;
	
	 H2Utils h2 = new H2Utils();
	 XmlValidate xmlValidate = new XmlValidate();
   

	@Override
	public void contextInitialized(ServletContextEvent sce) {

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
		

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 h2.destoryH2(server);

	}

}

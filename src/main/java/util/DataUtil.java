package main.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import test.java.h2.H2Utils;

public class DataUtil {
	
	H2Utils h2utils = new H2Utils();
    
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource   dataSource= new  DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/recruit?useUnicode=true&amp&characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("root@000");
        
        // create datasource contain h2
      /*  dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");*/
        return dataSource;
    }
    
    public  JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate  = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }

    public Connection getConn() throws SQLException, ClassNotFoundException{
        /*String driver = "com.mysql.jdbc.Driver";  
        String  url = "jdbc:mysql://127.0.0.1:3306/recruit?useUnicode=true&characterEncoding=utf8";
        Connection conn;  
            Class.forName(driver);  
        conn = DriverManager.getConnection(url,"root", "fds");  */
    	
    	//this is hard code , change to datasource manager
    	
        return  h2utils.getconn();
    }
}

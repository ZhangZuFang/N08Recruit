package test.java.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.h2.tools.Server;

public class H2Utils {

	private Server server;
	private int portNum;

	public Server setUpH2() {
		try {
		server = this.server.createWebServer().start();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return server;
	}

	public void destoryH2(Server server) {
		// not know whether this method used is ok ?
		if(server.isRunning(true)) {
			server.stop();
		}
		
	}

	public Connection getconn() {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
	
	public void closeConn(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}

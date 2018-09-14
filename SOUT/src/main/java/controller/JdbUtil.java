package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbUtil {
	private static String connectionDriverClass="com.mysql.cj.jdbc.Driver";
	private static String connectionUrl="jdbc:mysql://localhost/java?Timezone=true&serverTimezone=UTC";
	private static String connectionUsername="root";
	private static String connectionPassword="";
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(JdbUtil.conn != null) {
			return JdbUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					JdbUtil.connectionUrl,
					JdbUtil.connectionUsername,
					JdbUtil.connectionPassword);
			
		}
	}
}

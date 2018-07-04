package tel.get.dbconnect;

import java.sql.*;

public class DbConnection {
	private static Connection conn = null;

	public static Connection getInstance() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jqgrid?useUnicode=true&characterEncoding=utf8";
				conn = DriverManager.getConnection(url, "root", "1234");
				System.out.println("DB  연결 성공");
			} catch (Exception e) {
				System.out.println("DB 연결 실패" + e);
			}
		}
		return conn;
	}
}
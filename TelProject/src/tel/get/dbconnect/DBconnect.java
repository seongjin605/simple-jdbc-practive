package tel.get.dbconnect;

import java.sql.*;

public class DBconnect {
	private static Connection conn = null;

	public static Connection getInstance() {
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				conn = DriverManager.getConnection(url, "scott", "tiger");
				System.out.println("DB ���� ����");
			} catch (Exception e) {
				System.out.println("DB ���� ����" + e);
			}
		}
		return conn;
	}
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost;databaseName=BookStore;encrypt=true;trustServerCertificate=true;";
			con = DriverManager.getConnection(url, "sa", "luc123");

			String query = "select * from Author";

			Statement myStatement = null;
			myStatement = con.createStatement();
			ResultSet result = myStatement.executeQuery(query);

			while (result.next()) {
				System.out.println(" Author ID: " + result.getString("idAuthor"));
				System.out.println("Author Name: " + result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
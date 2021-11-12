package unisa.studenti.it.Entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBMCinema {
	public static String url = "jdbc:mysql://127.0.0.1:3306/progetto"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static Connection conn=null;
	public static Connection getConn() {
		return conn;
	}
	public static void setConn(Connection conn) {
		DBMCinema.conn = conn;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		DBMCinema.url = url;
	}
	public static Connection connectionDBM(String username,String pwd) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,pwd);
		if(conn!=null) {
		System.out.println("Connessione Stabilita.\n");
		}
		}
		catch(Exception e){
		System.out.println("Connessione fallita");
		}
	return conn;
	}


	

}

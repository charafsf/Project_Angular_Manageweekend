package m2.ila.test.mysql_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.io.*;
import java.net.*;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class App {

	public static String sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
		String result = "";
		InetAddress geek = InetAddress.getByName(ipAddress);
		System.out.println("Sending Ping Request to " + ipAddress);
		if (geek.isReachable(5000)) {
			System.out.println("Host is reachable");
			result = geek.getHostAddress();
		} else {
			System.out.println("Sorry ! We can't reach to this host");
		}
		return result;
	}

	public static boolean jdbcConnection(String DATABASE_IP,String username,String password,String DATABASE_NAME) {
		boolean result = true;
		System.out.println(DATABASE_IP);
		try {
			Thread.sleep(3000);
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			String url = "jdbc:mysql://"
					+ DATABASE_IP + ":3306/"+DATABASE_NAME+"?useSSL=false&allowPublicKeyRetrieval=true";
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
					+ DATABASE_IP + ":3306/"+DATABASE_NAME+"?useSSL=false&allowPublicKeyRetrieval=true", username,password);
		} catch (SQLException ex) {
			result = false;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InterruptedException e) {
			result = false;
			e.printStackTrace();
		} catch (Exception ex) {
			result = false;
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
		}
		return result;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Map<String, String> env = System.getenv();
		String DATABASE_HOST = env.get("DATABASE_HOST");
		String username = env.get("SPRING_DATASOURCE_USERNAME");
		String password = env.get("SPRING_DATASOURCE_USERNAME");
		String DATABASE_NAME = env.get("DATABASE_NAME");
		String BOUCLE = env.get("BOUCLE");
		if(DATABASE_HOST == null || DATABASE_HOST == "") {
			DATABASE_HOST = "mysql";
		}
		boolean bool = false;
		System.out.println(BOUCLE);
		if(BOUCLE != null && BOUCLE.equals("infini")) {
			System.out.println("infini");
			bool = true;
		}
		boolean isConnected = false;
		while (!isConnected || bool) {
			isConnected = true;
			if(jdbcConnection(DATABASE_HOST,username,password,DATABASE_NAME)) {
				System.out.println("Database is ready with "+DATABASE_HOST);
			}
			else {
				isConnected = false;
			}
		}
	}
}
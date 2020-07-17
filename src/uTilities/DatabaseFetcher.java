
 /* dbUrl=jdbc:mysql://localhost:3306/world
 * username=root
 * password=Test@123
 * */

package uTilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseFetcher {
	
	public ResultSet testDB(String url, String username, String password, String sqlQuery){
		
		ResultSet resultSet = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection(url,username, password);
				System.out.println("Connection established");
				
				Statement st = con.createStatement();

//			ResultSet result = st.executeQuery("SELECT * FROM price WHERE BOOK_MRP>300;");//sqlQuery
				
				if(sqlQuery.contains(" * ")) {
					resultSet = st.executeQuery(sqlQuery);
				}
				else {
					st.executeUpdate(sqlQuery);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultSet;
	}	
}

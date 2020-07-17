
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
	
	public ResultSet executeDbQuery(String url, String username, String password, String sqlQuery, boolean isSelectQuery){
		
		ResultSet resultSet = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection(url,username, password);
//				System.out.println("Connection established");
				
				Statement st = con.createStatement();

//			ResultSet result = st.executeQuery("SELECT * FROM price WHERE BOOK_MRP>300;");//sqlQuery
				
				if(isSelectQuery) {
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
			System.out.println("SQL operation done.");
			return resultSet;
	}
	
	public void updateDeleteDb(String url, String username, String password, String sqlQuery) {
		
		boolean isSelectQuery = false;
		executeDbQuery(url, username, password, sqlQuery,isSelectQuery);
	}
	
	public ResultSet selectFromDb(String url, String username, String password, String sqlQuery) {
		
		boolean isSelectQuery = true;
		return executeDbQuery(url, username, password, sqlQuery,isSelectQuery);
	}
}

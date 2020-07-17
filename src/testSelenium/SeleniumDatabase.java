package testSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uTilities.DatabaseFetcher;
import uTilities.PropertyReaderClass;

public class SeleniumDatabase {

	public void testDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Test@123");
			System.out.println("Connection established");

			Statement st = con.createStatement();

			ResultSet result = st.executeQuery("SELECT * FROM price WHERE BOOK_MRP>300;");
			System.out.print("tutorial_id\tBOOK_price\tcity\t\tsubmission_date\t\tBOOK_MRP\n");

			while (result.next()) {
				String tutorial_id = result.getString("tutorial_id");
				int BOOK_price = Integer.parseInt(result.getString("BOOK_price"));
				String city = result.getString("City");
				String submission_date = result.getString("submission_date");
				int BOOK_MRP = Integer.parseInt(result.getString("BOOK_MRP"));
				System.out.print(tutorial_id + "\t\t" + BOOK_price + "\t\t" + city + "\t\t" + submission_date + "\t\t"
						+ BOOK_MRP + "\n");
			}
			con.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SeleniumDatabase sdb = new SeleniumDatabase();
		sdb.testDB();
		DatabaseFetcher df = new DatabaseFetcher();
		PropertyReaderClass pr = new PropertyReaderClass();
		String sqlQuery = "SELECT * FROM PRICE";
		System.out.println(pr.propReader("dbUrl") + pr.propReader("username") + pr.propReader("password"));
		System.out.println(df.testDB(pr.propReader("dbUrl"), pr.propReader("username"), pr.propReader("password"), sqlQuery));
	}

}

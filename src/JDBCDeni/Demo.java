package JDBCDeni;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		
		/*
		 * steps in JDBC(old version)
			1. Import Packages
			2. Load Driver
			3. Register Driver
			(new version)
			4. Create Connection
			5. Create Statement
			6. Execute Statement
			7. Close
		 * 
		 * */
		
		
		
		try {
			
			String uname= "postgres";
			String password= "admin123";
			String url = "jdbc:postgresql://localhost:5432/myDb";
//			String query = "select * from todos";
//			String query = "insert into todos values(19,'demo',true)";
			
//			Class.forName("org.postgresql.Driver"); <---this is optional()
			Connection con = DriverManager.getConnection(url,uname,password);
			System.out.println("connection established");
			//using prepared statement
			String query = "insert into todos values(?,?,?)";
//			String query = "delete from todos where id = ?";
			int id = 100;
			String todo = "demo2";
			boolean isDone = false;
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, todo);
			ps.setBoolean(3, isDone);
			ps.execute();
//			Statement st = con.createStatement();
//			 st.execute(query);
			 
			 
//			boolean res =
//			System.out.println(res);
			/*this is only for fetching data*/
//			ResultSet rs = st.executeQuery(query);
			
//			while(rs.next()) {
//				System.out.print("ID: " + rs.getInt("id"));
//				System.out.print(" TODO: " +rs.getString("todo"));
//				System.out.println(" Done: " +rs.getBoolean("isdone"));
//			}
			
			
			con.close();
			System.out.println("connection Closed");
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		
	}
}	

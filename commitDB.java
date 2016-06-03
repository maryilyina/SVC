import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class commitDB {
	public static String[] getHistory(int user_id, int curr_tree_node, int dir_id){
		String sMakeSelect = "";
		sMakeSelect = "SELECT id, date,user_id FROM commit WHERE user_id = '" + user_id + "ORDER BY id DESc LIMIT" +commitNum + ";";
		
		Connection conn = null;
	    Statement stmt = null;
	    try {
			Class.forName("org.sqlite.JDBC");
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:commit.db");
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sMakeSelect);
				while (rs.next()) {
					String[] data;
					data = new String[count];
					for (int i = 0; i < count; i++) {
						data[i] = rs.getString(i+1);
						System.out.println(data[i]);
					}
				}
				stmt.close();
			    conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;		
	}
}

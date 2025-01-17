import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sqlite.SQLiteException;

public class PreparedStatementQuery {
	
	
	public static void main(String[] args) {

		PreparedStatement preparedStatement;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection
				      ("jdbc:sqlite:javabook.db");
		
			/*
			 * if we don't want transactions to 
			 * automatically propagate
				connection.setAutoCommit(false);
			 */
			
			System.out.println("Database connected"); 
			String queryString = "select firstName, mi, lastName from Student where lastName = 'Smith'";
			/*
			String queryString = "select * from Student where lastName = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, "Smith");
			*/
			ResultSet rset = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int numColumns = rsmd.getColumnCount();
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			Set<String> columns = new HashSet<String>();
			for (int i=1;i<=numColumns;i++) {
				System.out.println("column " + i + ": " +rsmd.getColumnName(i));
				m.put(rsmd.getColumnName(i), new Integer(i));
				columns.add(rsmd.getColumnName(i));
			}
			
			System.out.println("Results:");
			while (rset.next() ) {
				String result = "";
				for (String col : columns) {
					result += rset.getString(col);
					result += " ";
				}
				System.out.println(result);
				continue;/*
		        String  firstName= rset.getString("firstName");
		        String mi = rset.getString("mi");
		        String lastName = rset.getString("lastName");
		        System.out.println(firstName + " " + mi + " " + lastName);
		*/		
			}
			
			String sql1 = "UPDATE Student SET LastName = 'Stevens' WHERE lastName = 'Stevensen'";
			String sql2 = "UPDATE Student SET LastName = 'Haddad' WHERE lastName = 'Smith'";
			// put errors in sql2 to in order to show who rollback works
			Statement stmt = connection.createStatement();
			stmt.execute(sql1);
			
			/* if autocommit is off:
			try { 
				stmt.execute(sql2);
			} catch (SQLiteException e) {
				connection.rollback();
			}
			connection.commit();
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
	}

}

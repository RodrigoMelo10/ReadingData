import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Country;

public class JDBCExample {

	/**
	 * @param args
	 */
	public static void main( String args[] )
	{   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Country> countries = new ArrayList<Country>();
		String name = null;
		String code = null;
		try{
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
			String user = "cctstudent";
			String password = "Pass1234!";
			String query = "SELECT * FROM country";
			
			String queryByCode = "SELECT * FROM country where country.name ="+ code;
			//String query = "INSERT INTO user( first_name, second_name) values ('Stivie' , 'Wonder');";
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			Statement stmt = conn.createStatement() ;

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;
			//stmt.executeUpdate(query);
			
			// Loop through the result set
			
			
			while(rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name") );
				country.setContinent(rs.getString("Continent"));
				country.setSurfaceArea(rs.getFloat("SurfaceArea"));
				country.setHeadOfState(rs.getString("HeadOfState"));
				countries.add(country);
				
				for (Country c : countries) {
					System.out.println(c.toString());
				}
				
				//System.out.println( rs.getString("Code") + "\t" + rs.getString("Name") + 
					//	"\t" + rs.getString("Continent") + "\t"+ rs.getFloat("SurfaceArea")+ "\t" + rs.getString("HeadOfState")) ;
			}
			
			
			System.out.print("Type the Country Name: ");
			name = br.readLine();
			String queryByName = "SELECT * FROM country WHERE Name LIKE "+ "'"+name+"'";
			System.out.print(queryByName);
			
			// Execute the query
			rs = stmt.executeQuery(queryByName) ;
			
			
			countries = new ArrayList<>();
			while(rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name") );
				country.setContinent(rs.getString("Continent"));
				country.setSurfaceArea(rs.getFloat("SurfaceArea"));
				country.setHeadOfState(rs.getString("HeadOfState"));
				countries.add(country);
				
				for (Country c : countries) {
					System.out.println("=====================================================");
					System.out.println("");
					System.out.println(c.toString());
				}
				
				//System.out.println( rs.getString("Code") + "\t" + rs.getString("Name") + 
					//	"\t" + rs.getString("Continent") + "\t"+ rs.getFloat("SurfaceArea")+ "\t" + rs.getString("HeadOfState")) ;
			}
			// Close the result set, statement and the connection
			//rs.close() ;
			stmt.close() ;
			conn.close() ;
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
	}
}
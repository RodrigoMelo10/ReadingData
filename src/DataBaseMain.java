import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dao.CountryDAO;
import dao.CountryDAO;
import dao.MySQLCoutryDAO;

public class DataBaseMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main( String args[] ) throws IOException {   
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    List<CountryDAO> countryDAOs = new ArrayList<CountryDAO>();
	 
	    // NOW THE CLIENT DOES NOT HAVE ANYTHING TO DO
        // THE THE DATABASE CLASS. 
        // THE CLIENT WILL ONLY TALK TO THE CUSTOMERD
        // IN TERMS OF CUSTOMER
        // IN OTHER WORDS, THE PASSING OF DATA IS GOING 
        // TO BE CUSTOMERS OBJECTS
        CountryDAO db = new MySQLCoutryDAO();
        
		String name = null;
		String code = null;
		boolean mainLoop = true;
	    int choice;
	    //creating menu
	    while(mainLoop){
	        System.out.println("Database Main Menu\n");
	        System.out.print("1.) Retrieve all records stored in the database table \n");
	        System.out.print("2.) Retrieve records by country name.\n");
	        System.out.print("3.) Retrieve records by country code.\n");
	        System.out.print("4.) Add new records into the database.\n");
	        System.out.print("5.) Exit\n");
	        System.out.print("\nEnter Your Menu Choice: ");

	        choice = Integer.parseInt(br.readLine());

	    switch(choice){
	    case 1:
	        countryDAOs = db.getCountries();
	        for (CountryDAO countryDAO : countryDAOs) {
                System.out.println(countryDAO.toString());
            }
	        break;
	    case 2: 
	        System.out.println("\nType the Country name: ");
	        name = br.readLine();
	        
	        countryDAOs = db.searchFromCountryName(name);
            
            for (CountryDAO countryDAO : countryDAOs) {
                System.out.println(countryDAO.toString());
            }
            countryDAOs = new ArrayList<CountryDAO>(); 
	        break;
	    case 3:
	        System.out.println("\nType the Country code: ");
	        code = br.readLine();
	        
	        countryDAOs = db.searchFromCountryCode(code);
            
            for (CountryDAO countryDAO : countryDAOs) {
                System.out.println(countryDAO.toString());
            }
            countryDAOs = new ArrayList<CountryDAO>();
	        break;
	    case 4: 
	        //Definitions
	        CountryDAO c = new CountryDAO();
	        System.out.println("Enter The Coutry Name: ");
	        c.setName(br.readLine());
	        
	        System.out.println("Enter The Coutry Code: ");
            c.setCode(br.readLine());
            
            System.out.println("Enter The Coutry Continent: ");
            c.setContinent(br.readLine());
	        
          //  System.out.println("Enter The Coutry State: ");
           // c.setHeadOfState(br.readLine());
            
            System.out.println("Enter The Coutry Suface Area: ");
            c.setSurfaceArea(Float.parseFloat(br.readLine()));
            
            System.out.println("Enter The Coutry Head Of State: ");
            c.setHeadOfState(br.readLine());
            
            db.saveCountry(c);
            
            System.out.println("Country inserted sucessifully!!");
	        break;
	    case 5: 
	        System.out.println("Exiting...");
	        System.exit(0);
	         break;
	    default :
	             break;

	    }
	    }
	}
	
//	private static void insertCountryIntoDatabase(Country country) {
//	    try{
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver").newInstance() ;
//            String queryByName = "INSERT INTO country(Name,Code,Continent,SurfaceArea,HeadOfState) values (?,?,?,?,?) ";
//            Connection conn = DriverManager.getConnection(dbServer, user, password) ;
//
//            // Get a statement from the connection
//            java.sql.PreparedStatement stmt = conn.prepareStatement(queryByName) ;
//
//            // SETTING THE PARAMETERS 
//            stmt.setString(1, country.getName());
//            stmt.setString(2, country.getCode());
//            stmt.setString(3, country.getContinent());
//            stmt.setFloat(4, country.getSurfaceArea());
//            stmt.setString(5, country.getHeadOfState());
//            
//            // Execute the query
//            boolean execute = stmt.execute();
//            
//            // Close the result set, statement and the connection
//            stmt.close() ;
//            conn.close() ;
//        }
//        catch( SQLException se ){
//            System.out.println( "SQL Exception:" ) ;
//
//            // Loop through the SQL Exceptions
//            while( se != null ){
//                System.out.println( "State  : " + se.getSQLState()  ) ;
//                System.out.println( "Message: " + se.getMessage()   ) ;
//                System.out.println( "Error  : " + se.getErrorCode() ) ;
//
//                se = se.getNextException() ;
//            }
//        }
//        catch( Exception e ){
//            System.out.println( e ) ;
//        }
//	}
	
//	private static List<Country> searchFromCountryName(String name) {
//        List<Country> countries = new ArrayList<Country>();
//        try{
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver").newInstance() ;
//            String queryByName = "SELECT * FROM country WHERE Name LIKE "+ "'"+name+"'";
//            Connection conn = DriverManager.getConnection(dbServer, user, password) ;
//
//            // Get a statement from the connection
//            Statement stmt = conn.createStatement() ;
//
//            // Execute the query
//            ResultSet rs = stmt.executeQuery(queryByName) ;
//            //stmt.executeUpdate(query);
//            
//            // Loop through the result set
//            while(rs.next()) {
//                Country country = new Country();
//                country.setCode(rs.getString("Code"));
//                country.setName(rs.getString("Name") );
//                country.setContinent(rs.getString("Continent"));
//                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
//                country.setHeadOfState(rs.getString("HeadOfState"));
//                countries.add(country);
//            }
//            
//            // Close the result set, statement and the connection
//            stmt.close() ;
//            conn.close() ;
//        }
//        catch( SQLException se ){
//            System.out.println( "SQL Exception:" ) ;
//
//            // Loop through the SQL Exceptions
//            while( se != null ){
//                System.out.println( "State  : " + se.getSQLState()  ) ;
//                System.out.println( "Message: " + se.getMessage()   ) ;
//                System.out.println( "Error  : " + se.getErrorCode() ) ;
//
//                se = se.getNextException() ;
//            }
//        }
//        catch( Exception e ){
//            System.out.println( e ) ;
//        }
//        return countries;
//    }
//	
	
//	private static List<Country> searchFromCountryCode(String code) {
//        List<Country> countries = new ArrayList<Country>();
//        try{
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver").newInstance() ;
//            
//            String queryByCode = "SELECT * FROM country WHERE Name LIKE "+ "'"+code+"'";
//            Connection conn = DriverManager.getConnection(dbServer, user, password) ;
//
//            // Get a statement from the connection
//            Statement stmt = conn.createStatement() ;
//
//            // Execute the query
//            ResultSet rs = stmt.executeQuery(queryByCode) ;
//            //stmt.executeUpdate(query);
//            
//            // Loop through the result set
//            while(rs.next()) {
//                Country country = new Country();
//                country.setCode(rs.getString("Code"));
//                country.setName(rs.getString("Name") );
//                country.setContinent(rs.getString("Continent"));
//                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
//                country.setHeadOfState(rs.getString("HeadOfState"));
//                countries.add(country);
//            }
//            
//            // Close the result set, statement and the connection
//            stmt.close() ;
//            conn.close() ;
//        }
//        catch( SQLException se ){
//            System.out.println( "SQL Exception:" ) ;
//
//            // Loop through the SQL Exceptions
//            while( se != null ){
//                System.out.println( "State  : " + se.getSQLState()  ) ;
//                System.out.println( "Message: " + se.getMessage()   ) ;
//                System.out.println( "Error  : " + se.getErrorCode() ) ;
//
//                se = se.getNextException() ;
//            }
//        }
//        catch( Exception e ){
//            System.out.println( e ) ;
//        }
//        return countries;
//    }
	
//	private static List<Country> readDataFromDatabase() {
//	    List<Country> countries = new ArrayList<Country>();
//	    try{
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver").newInstance() ;
//            String query = "SELECT * FROM country";
//            Connection conn = DriverManager.getConnection(dbServer, user, password) ;
//
//            // Get a statement from the connection
//            Statement stmt = conn.createStatement() ;
//
//            // Execute the query
//            ResultSet rs = stmt.executeQuery(query) ;
//            //stmt.executeUpdate(query);
//            
//            // Loop through the result set
//            while(rs.next()) {
//                Country country = new Country();
//                country.setCode(rs.getString("Code"));
//                country.setName(rs.getString("Name") );
//                country.setContinent(rs.getString("Continent"));
//                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
//                country.setHeadOfState(rs.getString("HeadOfState"));
//                countries.add(country);
//            }
//            
//            // Close the result set, statement and the connection
//            stmt.close() ;
//            conn.close() ;
//        }
//        catch( SQLException se ){
//            System.out.println( "SQL Exception:" ) ;
//
//            // Loop through the SQL Exceptions
//            while( se != null ){
//                System.out.println( "State  : " + se.getSQLState()  ) ;
//                System.out.println( "Message: " + se.getMessage()   ) ;
//                System.out.println( "Error  : " + se.getErrorCode() ) ;
//
//                se = se.getNextException() ;
//            }
//        }
//        catch( Exception e ){
//            System.out.println( e ) ;
//        }
//	    return countries;
//	}
}
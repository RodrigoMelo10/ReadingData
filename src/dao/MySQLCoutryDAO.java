package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Continent;
import model.Country;

public class MySQLCoutryDAO implements CountryDAO {

	// METHOD 1: GET ALL CUSTOMERS
	@Override
	public ArrayList<Country> getCountries() {
		
		// CREATE THE ARRAYLIST TO PUT ALL THE CUSTOMERS
		// THAT ARE GOING TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();
		
		// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
		String query = "SELECT * FROM country where not continent = ''";
		
		// ACCESSING THE DATABASE
		DataSource db = new DataSource();
		
		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);
		
		// LOOP OVER THE RESULT SET
		try {
		    while(rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name") );
                country.setContinent(rs.getString("Continent").replace(" ", "_"));
                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                countries.add(country);
            }
			
			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE CUSTOMERS
		return countries;
	}

	@Override
    public List<Country> searchFromCountryName(String name) {
        
        // CREATING THE OBJECT THAT WE'RE GOING TO RETURN
        List<Country> countries = new ArrayList<Country>();
        
        // THIS METHOD IS IN CHAGE OF CREATING THE QUERY
        String queryByName = "SELECT * FROM country WHERE Name LIKE "+ "'"+name+"'";
        
        // ACCESSING THE DATABASE
        DataSource db = new DataSource();
        
        // QUERYING THE DATABASE
        ResultSet rs = db.select(queryByName) ;
        
        // WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE 
        // OF CUSTOMER
        try {
            while(rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name") );
                country.setContinent(rs.getString("Continent").replace(" ", "_"));
                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                countries.add(country);
            }
            
            // CLOSING THE CONNECTION TO THE DATABASE
            db.closing();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // RETURN THE CUSTOMER 
        return countries;
    }
	
	@Override
	public List<Country> searchFromCountryCode(String code) {
		
		// CREATING THE OBJECT THAT WE'RE GOING TO RETURN
	    List<Country> countries = new ArrayList<Country>();
		
		// THIS METHOD IS IN CHAGE OF CREATING THE QUERY
	    String queryByCode = "SELECT * FROM country WHERE code LIKE "+ "'"+code+"'";
		
		// ACCESSING THE DATABASE
		DataSource db = new DataSource();
		
		// QUERYING THE DATABASE
        ResultSet rs = db.select(queryByCode) ;
		
		// WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE 
		// OF CUSTOMER
		try {
		    while(rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name") );
                country.setContinent(rs.getString("Continent").replace(" ", "_"));
                country.setSurfaceArea(rs.getFloat("SurfaceArea"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                countries.add(country);
            }
			
			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// RETURN THE CUSTOMER 
		return countries;
	}

	@Override
	public boolean saveCountry(Country coutry) {
		
		// ACCESSING THE DATABASE
		DataSource db = new DataSource();
		
		// FROM THE OBJECT, GETTING THE DATA
        String	 name = coutry.getName();
        Continent continent = coutry.getContinent();
        String code = coutry.getCode();
        float surfaceArea = coutry.getSurfaceArea();
        String headOfState = coutry.getHeadOfState();
		
		// THIS METHOD IS IN CHARGE OF CREATING THE QUERY
		//String query = "insert into country (Name,Code,Continent,SurfaceArea,HeadOfState)  values ('" + name + "', " + code + ", '" + continent + ",'  " +surfaceArea+"' "+headOfState+" ' )";
        String query = "insert into country (Name,Code,Continent,SurfaceArea,HeadOfState)  values ('" + name + "', '"+ code + "', '" + continent + "', '" +surfaceArea+"', '"+headOfState+"');";
		// REQUESTION TO SAVE THE DATA
		boolean result = db.save(query);
		
		// CLOSING THE DATABASE
		db.closing();
		
		return result;
	}

}

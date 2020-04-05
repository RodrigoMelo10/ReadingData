package dao;
import java.util.ArrayList;
import java.util.List;

import model.Country;

public interface CountryDAO {

	public ArrayList<Country> getCountries();
	public boolean saveCountry(Country country);
	public List<Country> searchFromCountryName(String name);
	public List<Country> searchFromCountryCode(String code);
	
}
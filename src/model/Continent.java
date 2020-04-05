package model;


//Creating 	ENUM for continent class
public enum Continent {
	
	Europe("Europe"), Asia("Asia"), Antarctica("Antarctica"), South_America("South America"), North_America("North America"), Oceania("Oceania"), Africa("Africa");
	
	// DO NOT CHANGE DE VALUE
	private final String continent;

	private Continent(String continent) {
		this.continent = continent;
	}
//RETURNING VALUE
	@Override
	public String toString() {
		return this.continent;
	}
	
	
}



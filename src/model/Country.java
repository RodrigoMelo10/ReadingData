

package model;
//CREATING THE VARIABLES TO BE USED FOR COUNTRY CLASS
public class Country {
	private String	 Name;
	private Continent Continent;
	private String Code;
	private float SurfaceArea;
	private String HeadOfState;
	//PASSING THE ARGUMENTS VARIABLES
	public Country(String name, String continent, String code, Float surfaceArea, String headOfState) {
		super();
		this.Name = name;
		this.Continent = Continent.valueOf(continent);
		this.Code = code;
		this.SurfaceArea = surfaceArea;
		this.HeadOfState = headOfState;
	}

	public Country() {
		super();
		
	}
//DEFINIG GETTERS AND SETTERS
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Continent getContinent() {
		return Continent;
	}

	public void setContinent(String cont) {
		Continent = Continent.valueOf(cont);
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public float getSurfaceArea() {
		return SurfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		SurfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}
//CREATING SETHEADOFSTATE METHOD WITH STRING HEADOFSTATE AS PARAMETER
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
//RETURNING VALUES
	@Override
	public String toString() {
		return "Country [Name=" + Name + ", Continent=" + Continent + ", Code=" + Code + ", SurfaceArea=" + SurfaceArea
				+ ", HeadOfState=" + HeadOfState + "]";
	}
	
}

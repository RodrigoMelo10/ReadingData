package model;

public class Country {
	private String Name;
	private String Continent;
	private String Code;
	private Float SurfaceArea;
	private String HeadOfState;
	
	public Country(String name, String continent, String code, Float surfaceArea, String headOfState) {
		super();
		Name = name;
		Continent = continent;
		Code = code;
		SurfaceArea = surfaceArea;
		HeadOfState = headOfState;
	}

	public Country() {
		super();
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String continent) {
		Continent = continent;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public Float getSurfaceArea() {
		return SurfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		SurfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}

	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}

	@Override
	public String toString() {
		return "Country [Name=" + Name + ", Continent=" + Continent + ", Code=" + Code + ", SurfaceArea=" + SurfaceArea
				+ ", HeadOfState=" + HeadOfState + "]";
	}
	
}

package LogicProblemEinstein;

public class HouseProperties
{
	public String houseNumber, color,smoke,pet,drink,nationality;

	public HouseProperties(String houseNumber)
	{
		this.houseNumber = houseNumber;
		
		this.color = "";
		this.smoke = "";
		this.pet = "";
		this.drink = "";
		this.nationality = "";
		
	}
//	public void clear(String houseNumber)
//	{
//		this.houseNumber = houseNumber;
//		this.color = "";
//		this.nationality = "";
//		this.pet = "";
//		this.smoke = "";
//		this.drink = "";
//	}
	
	public String toString()
	{
		return houseNumber + ": " + nationality + " " + color + " " + smoke + " " + drink + " " + pet;
	}
}

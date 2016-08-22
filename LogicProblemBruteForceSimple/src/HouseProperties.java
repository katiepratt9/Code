
public class HouseProperties
{
	public String occupant, color, number;

	public void clear(String occupantName)
	{
		this.occupant = occupantName;
		this.color = "";
		this.number = "";
	}
	
	public String toString()
	{
		return occupant + ": " + number + " " + color;
	}
}

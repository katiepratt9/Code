package BattleShipSimple;

import java.util.ArrayList;

public class SimpleDotCom
{
	int numOfHits = 0;
private ArrayList<String> locationCells;
	public void setLocationCells(ArrayList<String> locs)
	{
		locationCells = locs;
	}

	public String checkYourself(String userInput)
	{
		// make a varible to hold the result to return. Put "miss" in as the
		// default
		String result = "miss";
		// repeat with each cell in the locationCell Array
		int index = locationCells.indexOf(userInput);
			// compare the user to this element(cell) in the array
			if (index >=0)
			{
				locationCells.remove(index);
				if (locationCells.isEmpty())
				{
					result = "kill";
				}else{
					result = "hit";
			}
		}
		return result;
	}

}

package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinHouseNationalityLogicPuzzleProperty implements LogicPuzzleProperty
{
private final ArrayList<String> nationality = new ArrayList<>();
	
	public EinsteinHouseNationalityLogicPuzzleProperty()
	{
		nationality.add("German");
		nationality.add("Swede");
		nationality.add("Norwegian");
		nationality.add("English");
		nationality.add("Dane");
	}
	
	@Override
	public String getPropertyName()
	{
		return "HouseNationality";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return nationality;
	}
}

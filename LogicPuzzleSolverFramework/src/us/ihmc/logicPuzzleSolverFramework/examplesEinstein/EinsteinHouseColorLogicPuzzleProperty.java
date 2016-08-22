package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinHouseColorLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> colors = new ArrayList<>();

	public EinsteinHouseColorLogicPuzzleProperty()
	{
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Yellow");
		colors.add("White");
	}

	@Override
	public String getPropertyName()
	{
		return "HouseColor";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return colors;
	}
}

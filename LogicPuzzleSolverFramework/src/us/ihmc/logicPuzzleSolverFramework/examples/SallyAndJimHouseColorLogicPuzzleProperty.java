package us.ihmc.logicPuzzleSolverFramework.examples;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class SallyAndJimHouseColorLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> colors = new ArrayList<>();
	
	public SallyAndJimHouseColorLogicPuzzleProperty()
	{
		colors.add("Red");
		colors.add("Green");
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

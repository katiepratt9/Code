package us.ihmc.logicPuzzleSolverFramework.examples;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class SallyAndJimPersonNameLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> names = new ArrayList<>();
	
	public SallyAndJimPersonNameLogicPuzzleProperty()
	{
		names.add("Sally");
		names.add("Jim");
	}
	
	@Override
	public String getPropertyName()
	{
		return "PersonName";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return names;
	}

}

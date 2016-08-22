package us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class FourNeighborsNameLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> names = new ArrayList<>();

	public FourNeighborsNameLogicPuzzleProperty()
	{
		names.add("Alice");
		names.add("Bob");
		names.add("Cathy");
		names.add("Dave");
	}
	
	@Override
	public String getPropertyName()
	{
		return "Name";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return names ;
	}

}

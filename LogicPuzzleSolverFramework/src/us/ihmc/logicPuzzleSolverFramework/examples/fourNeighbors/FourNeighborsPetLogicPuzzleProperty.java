package us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class FourNeighborsPetLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> pets = new ArrayList<>();

	public FourNeighborsPetLogicPuzzleProperty()
	{
		pets.add("Ant");
		pets.add("Bobcat");
		pets.add("Cat");
		pets.add("Dog");
	}
	
	@Override
	public String getPropertyName()
	{
		return "Pet";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return pets ;
	}

}

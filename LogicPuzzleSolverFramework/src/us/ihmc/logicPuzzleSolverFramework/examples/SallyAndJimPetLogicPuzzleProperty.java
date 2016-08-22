package us.ihmc.logicPuzzleSolverFramework.examples;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class SallyAndJimPetLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> pets = new ArrayList<>();
	
	public SallyAndJimPetLogicPuzzleProperty()
	{
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
		return pets;
	}

}

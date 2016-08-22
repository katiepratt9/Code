package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinHousePetLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> pets = new ArrayList<>();

	public EinsteinHousePetLogicPuzzleProperty()
	{
		pets.add("Dogs");
		pets.add("Horses");
		pets.add("Cats");
		pets.add("Fish");
		pets.add("Birds");
	}

	@Override
	public String getPropertyName()
	{
		return "Housepet";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return pets;
	}
}

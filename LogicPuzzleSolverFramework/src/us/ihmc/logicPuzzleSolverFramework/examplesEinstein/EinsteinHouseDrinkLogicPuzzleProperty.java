package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinHouseDrinkLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> drink = new ArrayList<>();

	public EinsteinHouseDrinkLogicPuzzleProperty()
	{
		drink.add("Beir");
		drink.add("Water");
		drink.add("Milk");
		drink.add("Tea");
		drink.add("Coffee");
	}

	@Override
	public String getPropertyName()
	{
		return "HouseDrink";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return drink;
	}
}

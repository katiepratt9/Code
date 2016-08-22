package logicPuzzleExampleFromOnline;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class OnlinePriceLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> prices = new ArrayList<>();

	public OnlinePriceLogicPuzzleProperty()
	{
		prices.add("$250");
		prices.add("$325");
		prices.add("$400");
		prices.add("$475");
	}

	@Override
	public String getPropertyName()
	{
		return "price";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return prices;
	}
}


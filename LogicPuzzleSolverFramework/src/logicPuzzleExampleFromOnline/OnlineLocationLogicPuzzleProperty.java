package logicPuzzleExampleFromOnline;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class OnlineLocationLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> locations = new ArrayList<>();

	public OnlineLocationLogicPuzzleProperty()
	{
		locations.add("ColbertRun");
		locations.add("DimmotWoods");
		locations.add("GillisPark");
		locations.add("Heffen Lane");
	}

	@Override
	public String getPropertyName()
	{
		return "location";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return locations;
	}
}

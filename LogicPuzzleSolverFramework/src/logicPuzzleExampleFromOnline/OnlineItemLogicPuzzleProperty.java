package logicPuzzleExampleFromOnline;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class OnlineItemLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> items = new ArrayList<>();

	public OnlineItemLogicPuzzleProperty()
	{
		items.add("Cannonball");
		items.add("DiamondRing");
		items.add("Earring");
		items.add("Wristwatch");
	}

	@Override
	public String getPropertyName()
	{
		return "item";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return items;
	}
}

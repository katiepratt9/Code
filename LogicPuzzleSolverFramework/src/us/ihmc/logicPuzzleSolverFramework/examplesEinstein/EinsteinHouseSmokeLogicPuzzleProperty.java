package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinHouseSmokeLogicPuzzleProperty implements LogicPuzzleProperty
{
	private final ArrayList<String> smokes = new ArrayList<>();

	public EinsteinHouseSmokeLogicPuzzleProperty()
	{
		smokes.add("Prince");
		smokes.add("Dunhill");
		smokes.add("Blend");
		smokes.add("BlueMaster");
		smokes.add("PallMall");
	}

	@Override
	public String getPropertyName()
	{
		return "Housesmoke";
	}

	@Override
	public ArrayList<String> getPropertyValues()
	{
		return smokes;
	}
}

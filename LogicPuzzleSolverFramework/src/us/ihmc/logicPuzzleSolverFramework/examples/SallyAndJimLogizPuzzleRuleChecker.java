package us.ihmc.logicPuzzleSolverFramework.examples;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleElement;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class SallyAndJimLogizPuzzleRuleChecker extends LogicPuzzleRuleChecker
{
	public SallyAndJimHouseColorLogicPuzzleProperty colorProperty;
	public SallyAndJimPersonNameLogicPuzzleProperty nameProperty;

	@Override
	public boolean rulesHold(LogicPuzzleState logicPuzzleState)
	{
		ArrayList<LogicPuzzleElement> logicPuzzleElements = logicPuzzleState.getLogicPuzzleElements();

		for (int houseNumber = 0; houseNumber < logicPuzzleElements.size(); houseNumber++)
		{
			LogicPuzzleElement logicPuzzleElement = logicPuzzleElements.get(houseNumber);

			if (!checkPropertiesMustBeSame(logicPuzzleElement, colorProperty, "Green", nameProperty, "Jim"))
				return false;
			if (!checkElementNumberMatchesProperty(logicPuzzleElement, houseNumber, 1, colorProperty, "Red"))
				return false;

		}
		return true;
	}

	public void setColorProperty(SallyAndJimHouseColorLogicPuzzleProperty colorProperty)
	{
		this.colorProperty = colorProperty;
	}

	public void setNameProperty(SallyAndJimPersonNameLogicPuzzleProperty nameProperty)
	{
		this.nameProperty = nameProperty;
	}
}

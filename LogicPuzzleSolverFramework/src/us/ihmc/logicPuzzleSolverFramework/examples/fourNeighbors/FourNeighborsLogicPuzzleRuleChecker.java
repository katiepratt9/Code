package us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleElement;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class FourNeighborsLogicPuzzleRuleChecker extends LogicPuzzleRuleChecker
{
	private LogicPuzzleProperty nameProperty;
	private LogicPuzzleProperty petProperty;

	public void setNameProperty(FourNeighborsNameLogicPuzzleProperty nameProperty)
	{
		this.nameProperty = nameProperty;
	}

	public void setPetProperty(FourNeighborsPetLogicPuzzleProperty petProperty)
	{
		this.petProperty = petProperty;
	}

	@Override
	public boolean rulesHold(LogicPuzzleState logicPuzzleState)
	{
		ArrayList<LogicPuzzleElement> logicPuzzleElements = logicPuzzleState.getLogicPuzzleElements();

		for (int i = 0; i < logicPuzzleElements.size(); i++)
		{
			LogicPuzzleElement leftLogicPuzzleElement = null;
			LogicPuzzleElement middleLogicPuzzleElement = logicPuzzleElements.get(i);
			LogicPuzzleElement rightLogicPuzzleElement = null;

			if (i > 0) leftLogicPuzzleElement = logicPuzzleElements.get(i - 1);
			if (i < logicPuzzleElements.size() - 1) rightLogicPuzzleElement = logicPuzzleElements.get(i+1);
			
			if (!this.checkElementNumberMatchesProperty(middleLogicPuzzleElement, i, 0, nameProperty, "Alice"))
				return false;
			
			if (!this.checkNeighborsHaveProperties(leftLogicPuzzleElement, middleLogicPuzzleElement, rightLogicPuzzleElement, petProperty, "Bobcat", petProperty, "Ant"))
				return false;
			
			if (!this.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, nameProperty, "Cathy", middleLogicPuzzleElement, nameProperty, "Dave"))
				return false;

			if (!this.checkNeighborsHaveProperties(leftLogicPuzzleElement, middleLogicPuzzleElement, rightLogicPuzzleElement, petProperty, "Dog", nameProperty, "Cathy"))
				return false;
			
			if (!this.checkPropertiesMustBeSame(middleLogicPuzzleElement, nameProperty, "Cathy", petProperty, "Cat"))
				return false;
			
			if (!this.checkNeighborsHaveProperties(leftLogicPuzzleElement, middleLogicPuzzleElement, rightLogicPuzzleElement, petProperty, "Bobcat", nameProperty, "Alice"))
				return false;
		}

		return true;
	}

}

package us.ihmc.logicPuzzleSolverFramework;

public abstract class LogicPuzzleRuleChecker
{
	public abstract boolean rulesHold(LogicPuzzleState logicPuzzleState);

	public boolean checkNeighborsHaveProperties(LogicPuzzleElement leftLogicPuzzleElement,
			LogicPuzzleElement middleLogicPuzzleElement, LogicPuzzleElement rightLogicPuzzleElement,
			LogicPuzzleProperty propertyOne, String valueOne, LogicPuzzleProperty propertyTwo, String valueTwo)
	{
		String leftPropertyValueOne = "X";
		String leftPropertyValueTwo = "X";

		String middlePropertyValueOne = middleLogicPuzzleElement.getPropertyValue(propertyOne);
		String middlePropertyValueTwo = middleLogicPuzzleElement.getPropertyValue(propertyTwo);

		String rightPropertyValueOne = "X";
		String rightPropertyValueTwo = "X";
		
		if (leftLogicPuzzleElement != null)
		{
			leftPropertyValueOne = leftLogicPuzzleElement.getPropertyValue(propertyOne);
			leftPropertyValueTwo = leftLogicPuzzleElement.getPropertyValue(propertyTwo);
		}
		
		if (rightLogicPuzzleElement != null)
		{
			rightPropertyValueOne = rightLogicPuzzleElement.getPropertyValue(propertyOne);
			rightPropertyValueTwo = rightLogicPuzzleElement.getPropertyValue(propertyTwo);
		}
		

		if (leftLogicPuzzleElement == null && middlePropertyValueOne.equals(valueOne) && propertyCannotEqual(rightPropertyValueTwo, valueTwo))
			return false;
		if (leftLogicPuzzleElement == null && middlePropertyValueTwo.equals(valueTwo) && propertyCannotEqual(rightPropertyValueOne, valueOne))
			return false;
		

		if (rightLogicPuzzleElement == null && middlePropertyValueOne.equals(valueOne) && propertyCannotEqual(leftPropertyValueTwo, valueTwo))
			return false;
		if (rightLogicPuzzleElement == null && middlePropertyValueTwo.equals(valueTwo) && propertyCannotEqual(leftPropertyValueOne, valueOne))
			return false;
		
		if (leftPropertyValueOne.equals(valueOne) && leftPropertyValueTwo.equals(valueTwo))
			return false;
		
		if (middlePropertyValueOne.equals(valueOne) && middlePropertyValueTwo.equals(valueTwo))
			return false;
		
		if (rightPropertyValueOne.equals(valueOne) && rightPropertyValueTwo.equals(valueTwo))
			return false;

		if (leftPropertyValueOne.equals(valueOne) && rightPropertyValueTwo.equals(valueTwo))
			return false;
		if (leftPropertyValueTwo.equals(valueTwo) && rightPropertyValueOne.equals(valueOne))
			return false;
		
		if (middlePropertyValueOne.equals(valueOne) && propertyCannotEqual(leftPropertyValueTwo, valueTwo)
				&& propertyCannotEqual(rightPropertyValueTwo, valueTwo))
			return false;
		
		if (middlePropertyValueTwo.equals(valueTwo) && propertyCannotEqual(leftPropertyValueOne, valueOne)
				&& propertyCannotEqual(rightPropertyValueOne, valueOne))
			return false;

		return true;
	}
	
	private boolean propertyCannotEqual(String propertyValue, String whatItMightEqual)
	{
		if (propertyValue.equals("")) return false;
		if (whatItMightEqual.equals("")) return false;
		return !propertyValue.equals(whatItMightEqual);
	}
	
	private boolean propertyMightEqual(String propertyValue, String whatItMightEqual)
	{
		if (propertyValue.equals("")) return true;
		if (whatItMightEqual.equals("")) return true;
		return propertyValue.equals(whatItMightEqual);
	}

	public boolean checkNeighborsHavePropertiesInOrder(LogicPuzzleElement leftLogicPuzzleElement,
			LogicPuzzleProperty leftProperty, String mustBeLeft, LogicPuzzleElement rightLogicPuzzleElement,
			LogicPuzzleProperty rightProperty, String mustBeRight)
	{
		if (leftLogicPuzzleElement == null)
		{
			if (rightLogicPuzzleElement.getPropertyValue(rightProperty).equals(mustBeRight))
				return false;
		}

		if (rightLogicPuzzleElement == null)
		{
			if (leftLogicPuzzleElement.getPropertyValue(leftProperty).equals(mustBeLeft))
				return false;
		}

		if (leftLogicPuzzleElement == null)
			return true;
		if (rightLogicPuzzleElement == null)
			return true;

		if (leftProperty.equals(""))
			return true;
		if (rightProperty.equals(""))
			return true;

		String leftPropertyValue = leftLogicPuzzleElement.getPropertyValue(leftProperty);
		String rightPropertyValue = rightLogicPuzzleElement.getPropertyValue(rightProperty);

		if (leftPropertyValue.equals(mustBeLeft) && propertyCannotEqual(rightPropertyValue, mustBeRight))
			return false;
		if (propertyCannotEqual(leftPropertyValue, mustBeLeft) && rightPropertyValue.equals(mustBeRight))
			return false;
		if (leftPropertyValue.equals(mustBeRight) && rightPropertyValue.equals(mustBeLeft))
			return false;
		return true;
	}

	public boolean checkPropertiesMustBeSame(LogicPuzzleElement logicPuzzleElement, LogicPuzzleProperty propertyOne,
			String mustBeOne, LogicPuzzleProperty propertyTwo, String mustBeTwo)
	{
		String propertyValueOne = logicPuzzleElement.getPropertyValue(propertyOne);
		String propertyValueTwo = logicPuzzleElement.getPropertyValue(propertyTwo);

		if (propertyValueOne.equals(""))
			return true;
		if (propertyValueTwo.equals(""))
			return true;

		if (propertyValueOne.equals(mustBeOne) && (propertyCannotEqual(propertyValueTwo, mustBeTwo)))
			return false;
		if (propertyCannotEqual(propertyValueOne, mustBeOne) && (propertyValueTwo.equals(mustBeTwo)))
			return false;

		return true;
	}

	public boolean checkElementNumberMatchesProperty(LogicPuzzleElement logicPuzzleElement, int elementNumber,
			int elementNumberMustBe, LogicPuzzleProperty property, String propertyMustBe)
	{
		String propertyValue = logicPuzzleElement.getPropertyValue(property);
		if (propertyValue.equals(""))
			return true;

		if (propertyValue.equals(propertyMustBe) && (elementNumber != elementNumberMustBe))
			return false;
		if (propertyCannotEqual(propertyValue, propertyMustBe) && (elementNumber == elementNumberMustBe))
			return false;

		return true;
	}
}

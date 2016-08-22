package logicPuzzleExampleFromOnline;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleElement;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class OnlineLogizPuzzleRuleChecker extends LogicPuzzleRuleChecker
{
	public OnlinePriceLogicPuzzleProperty priceProperty;
	public OnlineLocationLogicPuzzleProperty locationProperty;
	public OnlineItemLogicPuzzleProperty itemProperty;

	@Override
	public boolean rulesHold(LogicPuzzleState logicPuzzleState)
	{
		ArrayList<LogicPuzzleElement> logicPuzzleElements = logicPuzzleState.getLogicPuzzleElements();

		for (int i = 0; i < logicPuzzleElements.size(); i++)
		{
			String heffenLaneMoney = "-1";
			String gillisParkMoney = "-1";
			String cannonballMoney = "-1";
			String earringMoney = "-1";
			LogicPuzzleElement middleLogicPuzzleElement = logicPuzzleElements.get(i);
			if (!checkPropertiesMustBeSame(middleLogicPuzzleElement, itemProperty, "Wristwatch", priceProperty, "$325"))
				return false;
			if (!checkPropertiesMustBeSame(middleLogicPuzzleElement, locationProperty, "GilisPark", priceProperty,
					"$250"))
				return false;
			if (!checkPropertiesMustBeSame(middleLogicPuzzleElement, locationProperty, "HeffenLane", priceProperty,
					"$250"))
				return false;
			if (!checkPropertiesMustBeSame(middleLogicPuzzleElement, locationProperty, "DimmotWoods", itemProperty,
					"CannonBall"))
				return false;
			if (middleLogicPuzzleElement.getPropertyValue(locationProperty).equals("HeffenLane"))
			{
				heffenLaneMoney = middleLogicPuzzleElement.getPropertyValue(priceProperty);
			}
			else if (middleLogicPuzzleElement.getPropertyValue(locationProperty).equals("GillisPark"))
			{
				gillisParkMoney = middleLogicPuzzleElement.getPropertyValue(priceProperty);
			}
			if (!propertiesAreLessThan(heffenLaneMoney, gillisParkMoney))
				return false;

			if (middleLogicPuzzleElement.getPropertyValue(itemProperty).equals("Cannonball"))
			{
				cannonballMoney = middleLogicPuzzleElement.getPropertyValue(priceProperty);
			}
			else if (middleLogicPuzzleElement.getPropertyValue(itemProperty).equals("Earring"))
			{
				earringMoney = middleLogicPuzzleElement.getPropertyValue(priceProperty);
			}
			if (!propertiesAreLessThan2(cannonballMoney, earringMoney))
				return false;
		}
		return true;
	}

	private boolean propertiesAreLessThan2(String ballMoney, String earMoney)
	{
		if (ballMoney.equals("-1") || earMoney.equals("-1"))
			return true;
		if (earMoney.equals("$250"))
			return false;
		if (ballMoney.equals("$475"))
			return false;
		if (earMoney.equals("$325") && !ballMoney.equals("$250"))
			return false;
		if (earMoney.equals("$400") && !earMoney.equals("$325"))
			return false;
		if (ballMoney.equals("$475") && !earMoney.equals("$400"))
			return false;
		return true;
	}

	private boolean propertiesAreLessThan(String hefMoney, String gilMoney)
	{
		if (hefMoney.equals("-1") || gilMoney.equals("-1"))
			return true;
		if (hefMoney.equals("$250"))
			return false;
		if (gilMoney.equals("$475"))
			return false;
		if (hefMoney.equals("$325") && !gilMoney.equals("$250"))
			return false;
		if (hefMoney.equals("$400") && !gilMoney.equals("$325") || !gilMoney.equals("$250"))
			return false;
		if (hefMoney.equals("$475") && !gilMoney.equals("$325") || !gilMoney.equals("$250") || !gilMoney.equals("$400"))
			return false;
		return true;
	}

	public void setItemProperty(OnlineItemLogicPuzzleProperty itemProperty)
	{
		this.itemProperty = itemProperty;
	}

	public void setNameProperty(OnlineLocationLogicPuzzleProperty locationProperty)
	{
		this.locationProperty = locationProperty;
	}

	public void setTimeProperty(OnlinePriceLogicPuzzleProperty priceProperty)
	{
		this.priceProperty = priceProperty;
	}
}

package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleElement;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleElement;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;

public class EinsteinLogicPuzzleRuleChecker extends LogicPuzzleRuleChecker
{
	public EinsteinHouseNationalityLogicPuzzleProperty nationalityProperty;
	public EinsteinHouseColorLogicPuzzleProperty colorProperty;
	public EinsteinHouseDrinkLogicPuzzleProperty drinkProperty;
	public EinsteinHouseSmokeLogicPuzzleProperty smokeProperty;
	public EinsteinHousePetLogicPuzzleProperty petProperty;
	private int count = 0;

	@Override
	public boolean rulesHold(LogicPuzzleState logicPuzzleState)
	{
//		if (count % 100000 == 0)
		{
//			System.out.println(count);
//			System.out.println(logicPuzzleState);
		}
		count++;

		ArrayList<LogicPuzzleElement> logicPuzzleElements = logicPuzzleState.getLogicPuzzleElements();

		for (int houseNumber = 0; houseNumber < logicPuzzleElements.size(); houseNumber++)
		{
			LogicPuzzleElement logicPuzzleElement = logicPuzzleElements.get(houseNumber);

			LogicPuzzleElement nextLogicPuzzleElement = null;
			if (houseNumber < logicPuzzleElements.size() - 1)
				nextLogicPuzzleElement = logicPuzzleElements.get(houseNumber + 1);

			LogicPuzzleElement previousLogicPuzzleElement = null;
			if (houseNumber > 0)
				previousLogicPuzzleElement = logicPuzzleElements.get(houseNumber - 1);

			if (!checkElementNumberMatchesProperty(logicPuzzleElement, houseNumber, 0, nationalityProperty,
					"Norwegian"))
				return false;
			
			if (!checkElementNumberMatchesProperty(logicPuzzleElement, houseNumber, 2, drinkProperty, "Milk"))
				return false;
			
			if (!checkPropertiesMustBeSame(logicPuzzleElement, colorProperty, "Red", nationalityProperty, "English"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, nationalityProperty, "Swede", petProperty, "Dogs"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, drinkProperty, "Tea", nationalityProperty, "Dane"))
				return false;

			if (!checkNeighborsHavePropertiesInOrder(previousLogicPuzzleElement, colorProperty, "Green",
					logicPuzzleElement, colorProperty, "White"))
				return false;

			if (!checkNeighborsHavePropertiesInOrder(logicPuzzleElement, colorProperty, "Green", nextLogicPuzzleElement,
					colorProperty, "White"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, colorProperty, "Green", drinkProperty, "Coffee"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, smokeProperty, "PallMall", petProperty, "Birds"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, colorProperty, "Yellow", smokeProperty, "Dunhill"))
				return false;

			

			if (!checkPropertiesMustBeSame(logicPuzzleElement, smokeProperty, "BlueMaster", drinkProperty, "Beir"))
				return false;

			if (!checkPropertiesMustBeSame(logicPuzzleElement, smokeProperty, "Prince", nationalityProperty, "German"))
				return false;

			if (!checkNeighborsHaveProperties(previousLogicPuzzleElement, logicPuzzleElement, nextLogicPuzzleElement,
					smokeProperty, "Blend", petProperty, "Cats"))
				return false;
			if (!checkNeighborsHaveProperties(previousLogicPuzzleElement, logicPuzzleElement, nextLogicPuzzleElement,
					smokeProperty, "Dunhill", petProperty, "Horses"))
				return false;
			if (!checkNeighborsHaveProperties(previousLogicPuzzleElement, logicPuzzleElement, nextLogicPuzzleElement,
					colorProperty, "Blue", nationalityProperty, "Norwegian"))
				return false;
			if (!checkNeighborsHaveProperties(previousLogicPuzzleElement, logicPuzzleElement, nextLogicPuzzleElement,
					smokeProperty, "Blend", drinkProperty, "Water"))
				return false;
			
		}

		return true;
	}

	public void setColorProperty(EinsteinHouseColorLogicPuzzleProperty colorProperty)
	{
		this.colorProperty = colorProperty;
	}

	public void setNationalityProperty(EinsteinHouseNationalityLogicPuzzleProperty nationalityProperty)
	{
		this.nationalityProperty = nationalityProperty;
	}

	public void setPetProperty(EinsteinHousePetLogicPuzzleProperty petProperty)
	{
		this.petProperty = petProperty;
	}

	public void setDrinkProperty(EinsteinHouseDrinkLogicPuzzleProperty drinkProperty)
	{
		this.drinkProperty = drinkProperty;
	}

	public void setSmokeProperty(EinsteinHouseSmokeLogicPuzzleProperty smokeProperty)
	{
		this.smokeProperty = smokeProperty;
	}
}

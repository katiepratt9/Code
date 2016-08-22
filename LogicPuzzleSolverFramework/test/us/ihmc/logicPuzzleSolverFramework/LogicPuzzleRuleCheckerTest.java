package us.ihmc.logicPuzzleSolverFramework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsLogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsNameLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsPetLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examplesEinstein.EinsteinHouseColorLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examplesEinstein.EinsteinHousePetLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examplesEinstein.EinsteinHouseSmokeLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examplesEinstein.EinsteinLogicPuzzle;

public class LogicPuzzleRuleCheckerTest
{

	@Test
	public void testRuleCheckerNeighborsInOrder()
	{
		LogicPuzzleRuleChecker ruleChecker = new LogicPuzzleRuleChecker()
		{
			@Override
			public boolean rulesHold(LogicPuzzleState logicPuzzleState)
			{
				return true;
			}
		};
			
		EinsteinHouseColorLogicPuzzleProperty colorProperty = new EinsteinHouseColorLogicPuzzleProperty();
		LogicPuzzle puzzle = new LogicPuzzle();
		puzzle.addProperty(colorProperty);

		ArrayList<LogicPuzzleProperty> properties = puzzle.getProperties();
		
		ArrayList<ArrayList<String>> values = new ArrayList<>();
		
		ArrayList<String> houseOne = new ArrayList<>();
		houseOne.add("Green");
		
		ArrayList<String> houseTwo = new ArrayList<>();
		houseTwo.add("White");
		
		values.add(houseOne);
		values.add(houseTwo);
		
		LogicPuzzleState state = new LogicPuzzleState(properties, values);
		ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();

		LogicPuzzleElement leftLogicPuzzleElement = logicPuzzleElements.get(0);
		LogicPuzzleElement rightLogicPuzzleElement = logicPuzzleElements.get(1);
		
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "Green", rightLogicPuzzleElement, colorProperty, "White"));
		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "Green", null, colorProperty, "White"));
		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(null, colorProperty, "Green", rightLogicPuzzleElement, colorProperty, "White"));
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "White", null, colorProperty, "Green"));
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(null, colorProperty, "White", rightLogicPuzzleElement, colorProperty, "Green"));

		houseOne.clear();
		houseOne.add("White");

		houseTwo.clear();
		houseTwo.add("Green");

		values.clear();
		values.add(houseOne);
		values.add(houseTwo);

		state = new LogicPuzzleState(properties, values);
		logicPuzzleElements = state.getLogicPuzzleElements();
		leftLogicPuzzleElement = logicPuzzleElements.get(0);
		rightLogicPuzzleElement = logicPuzzleElements.get(1);

		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "Green", rightLogicPuzzleElement, colorProperty, "White"));
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "Green", null, colorProperty, "White"));
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(null, colorProperty, "Green", rightLogicPuzzleElement, colorProperty, "White"));
		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(leftLogicPuzzleElement, colorProperty, "White", null, colorProperty, "Green"));
		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(null, colorProperty, "White", rightLogicPuzzleElement, colorProperty, "Green"));
	}
	
	
	@Test
	public void testRuleCheckerNeighborsNotInOrder()
	{
		LogicPuzzleRuleChecker ruleChecker = new LogicPuzzleRuleChecker()
		{
			@Override
			public boolean rulesHold(LogicPuzzleState logicPuzzleState)
			{
				return true;
			}
		};
			
		EinsteinHouseSmokeLogicPuzzleProperty smokeProperty = new EinsteinHouseSmokeLogicPuzzleProperty();
		EinsteinHousePetLogicPuzzleProperty petProperty = new EinsteinHousePetLogicPuzzleProperty();

		LogicPuzzle puzzle = new LogicPuzzle();
		puzzle.addProperty(smokeProperty);
		puzzle.addProperty(petProperty);

		ArrayList<LogicPuzzleProperty> properties = puzzle.getProperties();
		
		ArrayList<ArrayList<String>> values = new ArrayList<>();
		
		ArrayList<String> houseOne = new ArrayList<>();
		houseOne.add("Blend");
		houseOne.add("Fish");
		
		ArrayList<String> houseTwo = new ArrayList<>();
		houseTwo.add("PallMall");
		houseTwo.add("Cats");
		
		ArrayList<String> houseThree = new ArrayList<>();
		houseThree.add("BlueMaster");
		houseThree.add("Dogs");
		
		values.add(houseOne);
		values.add(houseTwo);
		values.add(houseThree);
		
		LogicPuzzleState state = new LogicPuzzleState(properties, values);
		ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();

		LogicPuzzleElement house0 = logicPuzzleElements.get(0);
		LogicPuzzleElement house1 = logicPuzzleElements.get(1);
		LogicPuzzleElement house2 = logicPuzzleElements.get(2);
		
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "Blend", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "Blend", petProperty, "Dogs"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "PallMall", petProperty, "Fish"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "PallMall", petProperty, "Dogs"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "PallMall", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "PallMall", petProperty, "Horses"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "BlueMaster", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "BlueMaster", petProperty, "Fish"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "BlueMaster", petProperty, "Dogs"));		
		
		assertTrue(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "Blend", petProperty, "Cats"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "PallMall", petProperty, "Fish"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "Blend", petProperty, "Fish"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "PallMall", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "Blend", petProperty, "Dogs"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, smokeProperty, "BlueMaster", petProperty, "Fish"));

		assertTrue(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "PallMall", petProperty, "Dogs"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "BlueMaster", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "BlueMaster", petProperty, "Dogs"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "Blend", petProperty, "Dogs"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "BlueMaster", petProperty, "Horses"));

		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "Blend", petProperty, "Horses"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house1, house2, null, smokeProperty, "PallMall", petProperty, "Horses"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, smokeProperty, "BlueMaster", petProperty, "Horses"));

//

		houseOne.clear();
		houseOne.add("Blend");
		houseOne.add("Fish");

		houseTwo.clear();
		houseTwo.add("");
		houseTwo.add("Cats");

		houseThree.clear();
		houseThree.add("BlueMaster");
		houseThree.add("");
		
		values.clear();
		values.add(houseOne);
		values.add(houseTwo);
		values.add(houseThree);

		LogicPuzzleState state1 = new LogicPuzzleState(properties, values);
		ArrayList<LogicPuzzleElement> logicPuzzleElements1 = state1.getLogicPuzzleElements();

		LogicPuzzleElement house11 = logicPuzzleElements1.get(0);
		LogicPuzzleElement house22 = logicPuzzleElements1.get(1);
		LogicPuzzleElement house3 = logicPuzzleElements1.get(2);	
		
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "Blend", petProperty, "Cats"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "Blend", petProperty, "Dogs"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "Blend", petProperty, "Horses"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "Blend", petProperty, "Fish"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "PallMall", petProperty, "Fish"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "PallMall", petProperty, "Dogs"));
		
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "PallMall", petProperty, "Cats"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "PallMall", petProperty, "Horses"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "BlueMaster", petProperty, "Cats"));
		assertFalse(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "BlueMaster", petProperty, "Fish"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "BlueMaster", petProperty, "Dogs"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house11, house22, house3, smokeProperty, "BlueMaster", petProperty, "Horses"));
	}
	
	
	@Test
	public void testRules()
	{
		FourNeighborsLogicPuzzle fourNeighborsLogicPuzzle = new FourNeighborsLogicPuzzle();
		
		LogicPuzzleRuleChecker ruleChecker = fourNeighborsLogicPuzzle.getRuleChecker();
			
		FourNeighborsNameLogicPuzzleProperty nameProperty = fourNeighborsLogicPuzzle.getFourNeighborsNameLogicPuzzleProperty();
		FourNeighborsPetLogicPuzzleProperty petProperty = fourNeighborsLogicPuzzle.getFourNeighborsPetLogicPuzzleProperty();
		
		LogicPuzzle puzzle = fourNeighborsLogicPuzzle.getPuzzle();

		ArrayList<LogicPuzzleProperty> properties = puzzle.getProperties();
		
		String[][] houses = new String[][]{{"Alice", "Cat"}, {"Cathy", "Dog"}, {"Bob", "Bobcat"}, {"Dave", "Ant"}};
		LogicPuzzleState state = LogicPuzzleState.createStateFromStrings(properties, houses);
		ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();

		LogicPuzzleElement house0 = logicPuzzleElements.get(0);
		LogicPuzzleElement house1 = logicPuzzleElements.get(1);
		LogicPuzzleElement house2 = logicPuzzleElements.get(2);
		LogicPuzzleElement house3 = logicPuzzleElements.get(3);
		
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(house0, nameProperty, "Cathy", house1, nameProperty, "Dave"));
		assertFalse(ruleChecker.checkNeighborsHavePropertiesInOrder(house1, nameProperty, "Cathy", house2, nameProperty, "Dave"));
		
		houses = new String[][]{{"Alice", ""}, {"Cathy", "Dog"}, {"Bob", "Bobcat"}, {"Dave", "Ant"}};
		state = LogicPuzzleState.createStateFromStrings(properties, houses);
		logicPuzzleElements = state.getLogicPuzzleElements();

		house0 = logicPuzzleElements.get(0);
		house1 = logicPuzzleElements.get(1);
		house2 = logicPuzzleElements.get(2);
		house3 = logicPuzzleElements.get(3);
		
		assertTrue(ruleChecker.checkElementNumberMatchesProperty(house0, 0, 0, petProperty, "Cat"));
		assertTrue(ruleChecker.checkPropertiesMustBeSame(house0, nameProperty, "Alice", petProperty, "Cat"));
		assertTrue(ruleChecker.checkNeighborsHaveProperties(house0, house1, house2, nameProperty, "Cathy", petProperty, "Cat"));
		assertTrue(ruleChecker.checkNeighborsHavePropertiesInOrder(house0, petProperty, "Cat", house1, nameProperty, "Cathy"));
		
		houses = new String[][]{{"", "Dog"}, {"", "Cat"}, {"", "Bobcat"}, {"", "Ant"}};
		state = LogicPuzzleState.createStateFromStrings(properties, houses);
		logicPuzzleElements = state.getLogicPuzzleElements();

		house0 = logicPuzzleElements.get(0);
		house1 = logicPuzzleElements.get(1);
		house2 = logicPuzzleElements.get(2);
		house3 = logicPuzzleElements.get(3);
		
		assertTrue(ruleChecker.checkNeighborsHaveProperties(null, house0, house1, petProperty, "Dog", nameProperty, "Cathy"));
	}
	
	@Test
	public void testRulesWithUndefinedProperties()
	{
		FourNeighborsLogicPuzzle fourNeighborsLogicPuzzle = new FourNeighborsLogicPuzzle();
		LogicPuzzleRuleChecker ruleChecker = fourNeighborsLogicPuzzle.getRuleChecker();
		
		LogicPuzzle puzzle = fourNeighborsLogicPuzzle.getPuzzle();
		ArrayList<LogicPuzzleProperty> properties = puzzle.getProperties();
				
		String[][] houses = new String[][]{{"Alice", "Ant"}, {"Bob", "Bobcat"}, {"Cathy", "Cat"}, {"Dave", "Dog"}};
		LogicPuzzleState logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", "Ant"}, {"Bob", "Bobcat"}, {"Cathy", "Cat"}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"Bob", "Bobcat"}, {"Cathy", "Cat"}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", "Bobcat"}, {"Cathy", "Cat"}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", ""}, {"Cathy", "Cat"}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", ""}, {"", "Cat"}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", ""}, {"", ""}, {"Dave", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", ""}, {"", ""}, {"", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", ""}, {"", ""}, {"", ""}, {"", ""}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", "Ant"}, {"", "Bobcat"}, {"", "Cat"}, {"", "Dog"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
		
		houses = new String[][]{{"", "Dog"}, {"", "Cat"}, {"", "Bobcat"}, {"", "Ant"}};
		logicPuzzleState = LogicPuzzleState.createStateFromStrings(properties, houses);
		assertTrue(ruleChecker.rulesHold(logicPuzzleState));
	}
	
	@Test
	public void testEinsteinPuzzleRules()
	{
		EinsteinLogicPuzzle puzzle = new EinsteinLogicPuzzle();
		LogicPuzzleRuleChecker rulesChecker = puzzle.getRulesChecker();

		String[][] valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""}
		};
		LogicPuzzleState state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "", "", "", ""},
			{"", "Blue", "", "", ""},
			{"", "", "Milk", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "", "Dunhill", ""},
			{"", "Blue", "", "", "Horses"},
			{"", "Red", "Milk", "", ""},
			{"", "Green", "Coffee", "", ""},
			{"", "White", "", "", ""}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "", "Dunhill", ""},
			{"", "Blue", "", "", "Horses"},
			{"English", "Red", "Milk", "", ""},
			{"", "Green", "Coffee", "", ""},
			{"", "White", "", "", ""}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "", "Dunhill", ""},
			{"", "Blue", "Beir", "BlueMaster", "Horses"},
			{"English", "Red", "Milk", "", ""},
			{"", "Green", "Coffee", "Blend", ""},
			{"", "White", "Water", "", "Cats"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"", "", "", "", ""},
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
		
		
		valuesArray = new String[][]{
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
		};
		state = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		assertTrue(rulesChecker.rulesHold(state));
	}

}

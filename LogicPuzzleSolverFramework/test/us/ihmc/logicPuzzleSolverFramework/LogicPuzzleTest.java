package us.ihmc.logicPuzzleSolverFramework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimHouseColorLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimLogizPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimPersonNameLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsLogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsNameLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors.FourNeighborsPetLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examplesEinstein.EinsteinLogicPuzzle;

public class LogicPuzzleTest
{

	@Test
	public void testSimpleSallyAndJimPuzzle()
	{
		SallyAndJimPersonNameLogicPuzzleProperty nameProperty = new SallyAndJimPersonNameLogicPuzzleProperty();
		SallyAndJimHouseColorLogicPuzzleProperty colorProperty = new SallyAndJimHouseColorLogicPuzzleProperty();
	
		LogicPuzzle puzzle = new LogicPuzzle();
		puzzle.addProperty(nameProperty);
		puzzle.addProperty(colorProperty);
		
		SallyAndJimLogizPuzzleRuleChecker ruleChecker = new SallyAndJimLogizPuzzleRuleChecker();
		ruleChecker.setColorProperty(colorProperty);
		ruleChecker.setNameProperty(nameProperty);
		
		puzzle.setRuleChecker(ruleChecker );
		ArrayList<LogicPuzzleState> solutions = puzzle.solve();
		
		assertEquals(1, solutions.size());
		
		LogicPuzzleState solution = solutions.get(0);
		ArrayList<LogicPuzzleElement> houses = solution.getLogicPuzzleElements();
		assertEquals("Jim", houses.get(0).getPropertyValue(nameProperty));
		assertEquals("Sally", houses.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", houses.get(0).getPropertyValue(colorProperty));
		assertEquals("Red", houses.get(1).getPropertyValue(colorProperty));
	}
	
	@Test
	public void testFourNeighborsPuzzle()
	{
		FourNeighborsLogicPuzzle puzzle = new FourNeighborsLogicPuzzle();
		ArrayList<LogicPuzzleState> solution = puzzle.solve();
		assertEquals(1, solution.size());
		
		LogicPuzzleState state = solution.get(0);
		
		ArrayList<LogicPuzzleElement> houses = state.getLogicPuzzleElements();
		LogicPuzzleElement aliceHouse = houses.get(0);
		LogicPuzzleElement bobHouse = houses.get(1);
		LogicPuzzleElement cathyHouse = houses.get(2);
		LogicPuzzleElement daveHouse = houses.get(3);
		
		FourNeighborsNameLogicPuzzleProperty nameProperty = puzzle.getFourNeighborsNameLogicPuzzleProperty();
		FourNeighborsPetLogicPuzzleProperty petProperty = puzzle.getFourNeighborsPetLogicPuzzleProperty();
		
		String alice = aliceHouse.getPropertyValue(nameProperty);
		String bob = bobHouse.getPropertyValue(nameProperty);
		String cathy = cathyHouse.getPropertyValue(nameProperty);
		String dave = daveHouse.getPropertyValue(nameProperty);
		
		String ant = aliceHouse.getPropertyValue(petProperty);
		String bobCat = bobHouse.getPropertyValue(petProperty);
		String cat = cathyHouse.getPropertyValue(petProperty);
		String dog = daveHouse.getPropertyValue(petProperty);
		
		assertEquals(alice, "Alice");
		assertEquals(bob, "Bob");
		assertEquals(cathy, "Cathy");
		assertEquals(dave, "Dave");
		
		assertEquals(ant, "Ant");
		assertEquals(bobCat, "Bobcat");
		assertEquals(cat, "Cat");
		assertEquals(dog, "Dog");
	}
	
	@Test
	public void testEinsteinPuzzle()
	{
		EinsteinLogicPuzzle puzzle = new EinsteinLogicPuzzle();
		ArrayList<LogicPuzzleState> solution = puzzle.solve();
		assertEquals(1, solution.size());
		
		LogicPuzzleState state = solution.get(0);
		
		String[][] valuesArray = new String[][]{
			{"Norwegian", "Yellow", "Water", "Dunhill", "Cats"},
			{"Dane", "Blue", "Tea", "Blend", "Horses"},
			{"English", "Red", "Milk", "PallMall", "Birds"},
			{"German", "Green", "Coffee", "Prince", "Fish"},
			{"Swede", "White", "Beir", "BlueMaster", "Dogs"}
		};
		
		LogicPuzzleState expectedState = LogicPuzzleState.createStateFromStrings(puzzle.getProperties(), valuesArray);
		
		assertTrue(state.isEqual(expectedState));
		
		
	}
}

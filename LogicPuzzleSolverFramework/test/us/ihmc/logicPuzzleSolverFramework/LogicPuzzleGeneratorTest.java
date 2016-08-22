package us.ihmc.logicPuzzleSolverFramework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimHouseColorLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimPersonNameLogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.examples.SallyAndJimPetLogicPuzzleProperty;

public class LogicPuzzleGeneratorTest
{

	@Test
	public void testGenerator()
	{
		ArrayList<LogicPuzzleProperty> properties = new ArrayList<>();
		
		SallyAndJimPersonNameLogicPuzzleProperty nameProperty = new SallyAndJimPersonNameLogicPuzzleProperty();
		properties.add(nameProperty);
		
		SallyAndJimHouseColorLogicPuzzleProperty colorProperty = new SallyAndJimHouseColorLogicPuzzleProperty();
		properties.add(colorProperty);
		
		SallyAndJimPetLogicPuzzleProperty petProperty = new SallyAndJimPetLogicPuzzleProperty();
		properties.add(petProperty);

		LogicPuzzleGenerator generator = new LogicPuzzleGenerator(properties);
		
		ArrayList<LogicPuzzleState> generatedStates = new ArrayList<>();
		
		while(true)
		{
			ArrayList<ArrayList<String>> next = generator.getNext();
			if (next == null) break;

			LogicPuzzleState state = new LogicPuzzleState(properties, next);
			ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();
			generatedStates.add(state);
			
//			System.out.println("\nElements:");
//			for (LogicPuzzleElement element : logicPuzzleElements)
//			{
//				System.out.println("Name: " + element.getPropertyValue(nameProperty));
//				System.out.println("Color: " + element.getPropertyValue(colorProperty));
//				System.out.println("Pet: " + element.getPropertyValue(petProperty));
//			}
//			
//			System.out.println("\nGenerator:");

//			System.out.println(next);
		}
		
		LogicPuzzleState state = generatedStates.get(0);
		ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(1);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(2);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(3);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(4);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(5);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(6);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(7);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(8);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(9);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(10);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(11);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(12);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		state = generatedStates.get(13);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		assertEquals(14, generatedStates.size());
		assertTrue(generator.hasRolledOver());
	}
	
	
	
	@Test
	public void testGeneratorWithRuleViolations()
	{
		ArrayList<LogicPuzzleProperty> properties = new ArrayList<>();
		
		SallyAndJimPersonNameLogicPuzzleProperty nameProperty = new SallyAndJimPersonNameLogicPuzzleProperty();
		properties.add(nameProperty);
		
		SallyAndJimHouseColorLogicPuzzleProperty colorProperty = new SallyAndJimHouseColorLogicPuzzleProperty();
		properties.add(colorProperty);
		
		SallyAndJimPetLogicPuzzleProperty petProperty = new SallyAndJimPetLogicPuzzleProperty();
		properties.add(petProperty);

		LogicPuzzleGenerator generator = new LogicPuzzleGenerator(properties);
		
		ArrayList<ArrayList<String>> next = generator.getNext();
		LogicPuzzleState state = new LogicPuzzleState(properties, next);
		ArrayList<LogicPuzzleElement> logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		generator.rulesDoNotHoldOnPreviousGenerated();
		
//		next = generator.getNext();
//		state = new LogicPuzzleState(properties, next);
//		logicPuzzleElements = state.getLogicPuzzleElements();
//		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
//		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
//		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
//		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
//		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
//		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
//		
//		next = generator.getNext();
//		state = new LogicPuzzleState(properties, next);
//		logicPuzzleElements = state.getLogicPuzzleElements();
//		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
//		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
//		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
//		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
//		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
//		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Jim", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Sally", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
		next = generator.getNext();
		state = new LogicPuzzleState(properties, next);
		logicPuzzleElements = state.getLogicPuzzleElements();
		assertEquals("Sally", logicPuzzleElements.get(0).getPropertyValue(nameProperty));
		assertEquals("Red", logicPuzzleElements.get(0).getPropertyValue(colorProperty));
		assertEquals("Cat", logicPuzzleElements.get(0).getPropertyValue(petProperty));
		assertEquals("Jim", logicPuzzleElements.get(1).getPropertyValue(nameProperty));
		assertEquals("Green", logicPuzzleElements.get(1).getPropertyValue(colorProperty));
		assertEquals("Dog", logicPuzzleElements.get(1).getPropertyValue(petProperty));
		
//		assertEquals(14, generatedStates.size());
		assertFalse(generator.hasRolledOver());
		
		assertNull(generator.getNext());
		assertTrue(generator.hasRolledOver());
	}

}

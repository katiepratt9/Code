package us.ihmc.logicPuzzleSolverFramework;

import java.util.ArrayList;

public class LogicPuzzleState
{
	private final ArrayList<LogicPuzzleElement> elements = new ArrayList<>();
	private final boolean isComplete;
	
	public LogicPuzzleState(ArrayList<LogicPuzzleProperty> properties, ArrayList<ArrayList<String>> values)
	{
		int numberOfProperties = properties.size();
		int numberOfElements = values.size();
		boolean isComplete = true;
		
		for (int elementIndex=0; elementIndex<numberOfElements; elementIndex++)
		{			
			LogicPuzzleElement element = new LogicPuzzleElement();
			
			for (int propertyIndex=0; propertyIndex<numberOfProperties; propertyIndex++)
			{
				LogicPuzzleProperty property = properties.get(propertyIndex);
				String value = values.get(elementIndex).get(propertyIndex);
				element.setPropertyValue(property, value);
				if (value.equals("")) isComplete = false;
			}
			elements.add(element);
		}
		
		this.isComplete = isComplete;
	}
	
	public static LogicPuzzleState createStateFromStrings(ArrayList<LogicPuzzleProperty> properties, String[][] valuesArray)
	{
		ArrayList<ArrayList<String>> values = new ArrayList<>();
		
		for (int i=0; i<valuesArray.length; i++)
		{
			ArrayList<String> elementValues = new ArrayList<>();
			String[] strings = valuesArray[i];
			
			for (int j=0; j<strings.length; j++)
			{
				elementValues.add(strings[j]);
			}
			
			values.add(elementValues);
		}

		LogicPuzzleState logicPuzzleState = new LogicPuzzleState(properties, values);
		return logicPuzzleState;
	}

	public ArrayList<LogicPuzzleElement> getLogicPuzzleElements()
	{
		return elements;
	}
	
	public boolean isComplete()
	{
		return isComplete;
	}
	
	public String toString()
	{
		String ret = "";
		
		for (int elementIndex = 0; elementIndex < elements.size(); elementIndex++)
		{
			LogicPuzzleElement element = elements.get(elementIndex);
			ret = ret + "\n" + elementIndex + ": " + element.toString();
		}
		
		return ret;
	}

	public boolean isEqual(LogicPuzzleState expectedState)
	{
		ArrayList<LogicPuzzleElement> expectedElements = expectedState.getLogicPuzzleElements();
		int size = elements.size();
		if (size != expectedElements.size()) return false;
		
		for (int i=0; i<size; i++)
		{
			LogicPuzzleElement element = elements.get(i);
			LogicPuzzleElement expectedElement = expectedElements.get(i);
			
			if (!element.isEqual(expectedElement)) return false;
		}
		
		return true;
	}

}

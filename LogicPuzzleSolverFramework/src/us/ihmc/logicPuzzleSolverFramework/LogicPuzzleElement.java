package us.ihmc.logicPuzzleSolverFramework;

import java.util.HashMap;
import java.util.Set;

public class LogicPuzzleElement
{
	private HashMap<LogicPuzzleProperty, String> propertyValues = new HashMap<>();
	
	public String getPropertyValue(LogicPuzzleProperty property)
	{
		return propertyValues.get(property);
	}
	public String setPropertyValue(LogicPuzzleProperty property, String value)
	{
		return propertyValues.put(property, value);
	}
	
	public String clearPropertyValue(LogicPuzzleProperty property)
	{
		return propertyValues.remove(property);
	}
	
	public String toString()
	{
		String ret = "";
		Set<LogicPuzzleProperty> keySet = propertyValues.keySet();
		
		int numberOfProperties = keySet.size();
		int count = 0;
		
		for (LogicPuzzleProperty property : keySet)
		{
			ret = ret + property.getPropertyName() + ": " + propertyValues.get(property);
			
			if (count < numberOfProperties-1) ret = ret + ", ";
			count++;
		}
		
		return ret;
	}
	
	public boolean isEqual(LogicPuzzleElement expectedElement)
	{
		Set<LogicPuzzleProperty> keySet = propertyValues.keySet();
		 HashMap<LogicPuzzleProperty, String> expectedPropertyValues = expectedElement.propertyValues;
		 
		 for (LogicPuzzleProperty key : keySet)
		 {
			 if (!propertyValues.get(key).equals(expectedPropertyValues.get(key))) return false;
		 }
		 
		 return true;
	}
}

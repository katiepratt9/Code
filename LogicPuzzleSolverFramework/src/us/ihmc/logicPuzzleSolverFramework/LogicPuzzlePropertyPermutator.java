package us.ihmc.logicPuzzleSolverFramework;

import java.util.ArrayList;

public class LogicPuzzlePropertyPermutator
{

	public ArrayList<ArrayList<String>> getPermutations(LogicPuzzleProperty property)
	{
		ArrayList<String> propertyValueStrings = property.getPropertyValues();

		return getPermutations(propertyValueStrings);
	}
	
	
	public ArrayList<ArrayList<String>> getPermutations(ArrayList<String> strings)
	{
		ArrayList<ArrayList<String>> permutationsToReturn = new ArrayList<>();

		if (strings.size() == 0) return permutationsToReturn;
		if (strings.size() == 1) 
		{
			ArrayList<String> oneWayToPermutate = new ArrayList<>();
			oneWayToPermutate.add(strings.get(0));
			permutationsToReturn.add(oneWayToPermutate);
			return permutationsToReturn;
		}

		for (String string : strings)
		{
			ArrayList<String> stringsCopy = new ArrayList<>();
			stringsCopy.addAll(strings);
			stringsCopy.remove(string);

			ArrayList<ArrayList<String>> permutations = getPermutations(stringsCopy);

			permutationsToReturn.addAll(permutations);

			for (ArrayList<String> list : permutations)
			{
				list.add(string);
			}	
		}

		return permutationsToReturn;
	}
}

package us.ihmc.logicPuzzleSolverFramework;

import java.util.ArrayList;

public class LogicPuzzleGenerator
{
	private final ArrayList<LogicPuzzleProperty> properties;
	private final ArrayList<LogicPuzzlePropertyPermutator> permutators;

	private final ArrayList<ArrayList<ArrayList<String>>> allThePermutations = new ArrayList<>();
	private int[] indices; // over the properties. Then over the permutation for
							// that property.

	private final ArrayList<String> undefinedPermutation;

	private boolean rolledOver = true;

	private boolean rulesAreValid = true;

	public LogicPuzzleGenerator(ArrayList<LogicPuzzleProperty> properties)
	{
		this.properties = properties;
		permutators = new ArrayList<>();

		for (int i = 0; i < properties.size(); i++)
		{
			LogicPuzzlePropertyPermutator permutator = new LogicPuzzlePropertyPermutator();
			LogicPuzzleProperty property = properties.get(i);
			ArrayList<ArrayList<String>> permutations = permutator.getPermutations(property);
			allThePermutations.add(permutations);

			permutators.add(permutator);
		}

		int numberOfElements = properties.get(0).getPropertyValues().size();
		undefinedPermutation = new ArrayList<>(numberOfElements);

		for (int i = 0; i < numberOfElements; i++)
		{
			undefinedPermutation.add("");
		}

		reset();
	}

	public void reset()
	{
		int numberOfProperties = properties.size();

		this.indices = new int[properties.size()];
		for (int propertyIndex = 0; propertyIndex < indices.length; propertyIndex++)
		{
			if (propertyIndex == numberOfProperties - 1)
			{
				indices[propertyIndex] = 0;
			}
			else
			{
				indices[propertyIndex] = -1;
			}
		}

		rulesAreValid = true;
		this.rolledOver = true;
	}

	public void rulesDoNotHoldOnPreviousGenerated()
	{
		rulesAreValid = false;
	}

	public boolean hasRolledOver()
	{
		return rolledOver;
	}

	public ArrayList<ArrayList<String>> getNext()
	{
		if (!rolledOver)
		{
			incrementIndices(properties.size());
			if (rolledOver) return null;
		}
		else
		{
			rolledOver = false;
		}
		
		ArrayList<ArrayList<String>> boxesWithProperties = new ArrayList<>();

		int numberOfProperties = properties.size();

		int numberOfBoxes = properties.get(0).getPropertyValues().size();

		for (int i = 0; i < numberOfBoxes; i++)
		{
			boxesWithProperties.add(new ArrayList<String>());
		}

		for (int propertyIndex = 0; propertyIndex < numberOfProperties; propertyIndex++)
		{
			ArrayList<ArrayList<String>> onePropertiesPermutations = allThePermutations.get(propertyIndex);

			int permutationIndex = indices[propertyIndex];

			ArrayList<String> onePropertiesPermutationToReturn;

			if (permutationIndex == -1)
			{
				onePropertiesPermutationToReturn = undefinedPermutation;
			}
			else
			{
				onePropertiesPermutationToReturn = onePropertiesPermutations.get(permutationIndex);
			}

			for (int boxNumber = 0; boxNumber < numberOfBoxes; boxNumber++)
			{
				ArrayList<String> oneBox = boxesWithProperties.get(boxNumber);

				oneBox.add(onePropertiesPermutationToReturn.get(boxNumber));
			}
		}

//		incrementIndices(numberOfProperties);

		return boxesWithProperties;
	}

	private void incrementIndices(int numberOfProperties)
	{
//		incrementIndexRulesAreNotValid(numberOfProperties, rulesAreValid);

		if (rulesAreValid)
		{
//			incrementIndexRulesAreNotValid(numberOfProperties, true);

			incrementIndexRulesAreValid(numberOfProperties);
		}
		else
		{
			incrementIndexRulesAreNotValid(numberOfProperties, false);
		}

		rulesAreValid = true;
	}

	private void incrementIndexRulesAreNotValid(int numberOfProperties, boolean previousWasValid)
	{
		rolledOver = true;
		for (int propertyIndex = 0; propertyIndex < numberOfProperties; propertyIndex++)
		{
			ArrayList<ArrayList<String>> onePropertiesPermutations = allThePermutations.get(propertyIndex);

			if (previousWasValid)
			{
				if ((indices[propertyIndex] == -1) && (indices[propertyIndex + 1] == -1))
					continue;
			}
			else if ((indices[propertyIndex] == -1)) // && (indices[propertyIndex + 1] == -1))
					continue;

			else
			{
				indices[propertyIndex]++;
				if (indices[propertyIndex] >= onePropertiesPermutations.size())
				{
					if (propertyIndex == numberOfProperties - 1)
					{
						indices[propertyIndex] = 0;
					}
					else
					{
						indices[propertyIndex] = -1;
					}
				}
				else
				{
					rolledOver = false;
					break;
				}
			}
		}
	}

	private void incrementIndexRulesAreValid(int numberOfProperties)
	{
		rolledOver = true;
		for (int propertyIndex = 0; propertyIndex < numberOfProperties; propertyIndex++)
		{
			ArrayList<ArrayList<String>> onePropertiesPermutations = allThePermutations.get(propertyIndex);

			if ((indices[propertyIndex] == -1) && (indices[propertyIndex + 1] == -1))
				continue;

			else
			{
				indices[propertyIndex]++;
				if (indices[propertyIndex] >= onePropertiesPermutations.size())
				{
					if (propertyIndex == numberOfProperties - 1)
					{
						indices[propertyIndex] = 0;
					}
					else
					{
						indices[propertyIndex] = -1;
					}
				}
				else
				{
					rolledOver = false;
					break;
				}
			}
		}
	}
}

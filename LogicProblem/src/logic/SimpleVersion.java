package logic;

import java.util.ArrayList;
import java.util.Random;


public class SimpleVersion
{
	ArrayList<String> jim = new ArrayList<>(2);
	ArrayList<String> sally = new ArrayList<>(2);
	boolean firstHouseCheck = false;
	boolean secondHouseCheck = false;
	boolean greenHouseCheck = false;
	boolean redHouseCheck = false;
	
	private final String firstHouse = "FirstHouse";
	private final String secondHouse = "SecondHouse";
	private final String greenHouse = "GreenHouse";
	private final String redHouse = "RedHouse";
	
	Random random = new Random();

	// public SimpleVersion(Random random)
	// {
	// this.random = random;
	//
	// }
	public boolean allAssigned()
	{
		if (findRandomUnassigned() == null)
		{
			System.out.println("null");
			return true;
		}
		return false;
	}

	public void assignAllKnowns()
	{
		jim.add(greenHouse);
		greenHouseCheck = true;
	}

	public String findRandomUnassigned()
	{
		int num;
		ArrayList<String> unused = findUnused();
		if (unused.isEmpty())
		{
			return null;
		}
		else
		{
			num = random.nextInt(unused.size());
			return unused.get(num);
		}
	}

	public ArrayList<String> findUnused()
	{
		ArrayList<String> unused = new ArrayList<>();
		if (firstHouseCheck == false)
		{
			unused.add(firstHouse);
		}
		if (secondHouseCheck == false)
		{
			unused.add(secondHouse);
		}
		if (greenHouseCheck == false)
		{
			unused.add(greenHouse);
		}
		if (redHouseCheck == false)
		{
			unused.add(redHouse);
		}
		return unused;
	}

	public void assignCondition()
	{
		String randomVarible;
		randomVarible = findRandomUnassigned();
		if (randomVarible == firstHouse)
		{
			if (secondHouseCheck == true)
			{
				if (sally.contains(secondHouse))
				{
					jim.add(firstHouse);
					firstHouseCheck = true;
				}
				else if (jim.contains(secondHouse))
				{
					sally.add(firstHouse);
					firstHouseCheck = true;
				}
			}
			else if (redHouseCheck == true)
			{
				if (sally.contains(redHouse))
				{
					jim.add(greenHouse);
					greenHouseCheck = true;
					sally.add(secondHouse);
					secondHouseCheck = true;
				}
				else if (jim.contains(redHouse))
				{
					sally.add(greenHouse);
					greenHouseCheck = true;
					jim.add(secondHouse);
					secondHouseCheck = true;
				}
			}
			else if (greenHouseCheck == true)
			{
				if (sally.contains(greenHouse))
				{
					jim.add(redHouse);
					jim.add(secondHouse);
					secondHouseCheck = true;
					redHouseCheck = true;
				}
				else if (jim.contains(greenHouse))
				{
					sally.add(redHouse);
					sally.add(secondHouse);
					secondHouseCheck = true;
					redHouseCheck = true;
				}
			}
		}
		else if (randomVarible == secondHouse)
		{
			if (firstHouseCheck == false)
			{
				if (jim.contains(greenHouse))
				{
					sally.add(redHouse);
					sally.add(secondHouse);
					jim.add(firstHouse);
					firstHouseCheck = true;
					redHouseCheck = true;
					secondHouseCheck = true;
				}
				else if (sally.contains(greenHouse))
				{
					jim.add(redHouse);
					jim.add(secondHouse);
					sally.add(firstHouse);
					firstHouseCheck = true;
					redHouseCheck = true;
					secondHouseCheck = true;
				}
			}
			else if (sally.contains(firstHouse))
			{
				jim.add(secondHouse);
				secondHouseCheck = true;
				jim.add(redHouse);
				redHouseCheck = true;
				sally.add(firstHouse);
				firstHouseCheck = true;
			}
			else if (jim.contains(firstHouse))
			{
				sally.add(secondHouse);
				secondHouseCheck = true;
				sally.add(redHouse);
				redHouseCheck = true;
				jim.add(firstHouse);
				firstHouseCheck = true;
			}
		}
		else if (randomVarible == greenHouse)
		{
			System.out.println("random varible was greenHouse");
			if (redHouseCheck == true)
			{
				if (sally.contains(redHouse))
				{
					jim.add(greenHouse);
					greenHouseCheck = true;

				}
				else if (jim.contains(redHouse))
				{
					sally.contains(greenHouse);
					greenHouseCheck = true;
				}
			}
			else if (secondHouseCheck == true)
			{
				if (sally.contains(secondHouse))
				{
					sally.add(redHouse);
					redHouseCheck = true;
					jim.add(greenHouse);
					greenHouseCheck = true;
				}
				else if (jim.contains(secondHouse))
				{
					jim.add(redHouse);
					redHouseCheck = true;
					sally.add(greenHouse);
					greenHouseCheck = true;
				}
			}
		}
		else if (randomVarible == redHouse)
		{
			if (greenHouseCheck == true)
			{
				if (sally.contains(greenHouse))
				{
					jim.add(redHouse);
					redHouseCheck = true;
					jim.add(secondHouse);
					secondHouseCheck = true;

				}
				else if (jim.contains(greenHouse))
				{
					sally.contains(redHouse);
					redHouseCheck = true;
					sally.add(secondHouse);
					secondHouseCheck = true;
				}
			}
			else if (secondHouseCheck == true)
			{
				if (sally.contains(secondHouse))
				{
					sally.add(redHouse);
					redHouseCheck = true;
					jim.add(greenHouse);
					greenHouseCheck = true;
				}
				else if (jim.contains(secondHouse))
				{
					jim.add(redHouse);
					redHouseCheck = true;
					sally.add(greenHouse);
					greenHouseCheck = true;
				}
			}
		}
	}

	public void printAnswer()
	{
		for (int i = 0; i < jim.size(); i++)
		{
			System.out.println("jim had " + jim.get(i));
		}
		System.out.println("and sally got");
		for (int i = 0; i < sally.size(); i++)
		{
			System.out.println("sally had " + sally.get(i));
		}
	}
}

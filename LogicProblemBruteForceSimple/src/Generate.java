import java.util.ArrayList;

public class Generate
{
	HouseProperties jimHouse = new HouseProperties();
	HouseProperties sallyHouse = new HouseProperties();

	ArrayList<String> personName = new ArrayList<>(2);
	private final String jimName = "jim";
	private final String sallyName = "sally";

	ArrayList<String> houseNumber = new ArrayList<>(2);
	private final String firstHouseNumber = "FirstHouse";
	private final String secondHouseNumber = "SecondHouse";

	ArrayList<String> houseColor = new ArrayList<>(2);
	private final String greenColor = "GreenHouse";
	private final String redColor = "RedHouse";

	public Generate()
	{
		houseNumber.add(firstHouseNumber);
		houseNumber.add(secondHouseNumber);
		houseColor.add(greenColor);
		houseColor.add(redColor);
		personName.add(jimName);
		personName.add(sallyName);
	}

	public void generateAndTest()
	{
//		jimHouse.clear(jimName);
//		sallyHouse.clear(sallyName);

		// for (String person : person)
		// {
		for (String jimHouseNumber : houseNumber)
		{
			jimHouse.number = jimHouseNumber;
			for (String jimColor : houseColor)
			{
				jimHouse.color = jimColor;
				for (String sallyHouseNumber : houseNumber)
				{
					if (sallyHouseNumber.equals(jimHouseNumber)) continue;
					sallyHouse.number = sallyHouseNumber;

					for (String sallyColor : houseColor)
					{
						if (sallyColor.equals(jimColor)) continue;
						sallyHouse.color = sallyColor;

						if (testRules(sallyHouse, jimHouse))
						{
							System.out.println("Found Solution:");
							System.out.println(jimHouse);
							System.out.println(sallyHouse);
						}
					}
				}
			}
		}
	}

	public boolean testRules(HouseProperties sallyHouse, HouseProperties jimHouse)
	{
		boolean ruleOne = true;
		boolean ruleTwo = true;

		if (!jimHouse.color.equals(greenColor))
			ruleOne = false;

		HouseProperties secondHouse = null;
		if (jimHouse.number.equals(secondHouseNumber))
			secondHouse = jimHouse;
		if (sallyHouse.number.equals(secondHouseNumber))
			secondHouse = sallyHouse;

		if (secondHouse != null)
		{
			if (!secondHouse.color.equals(redColor))
				ruleTwo = false;
		}

//		System.out.println();
//		System.out.println();
//		System.out.println("sallyHouse = " + sallyHouse);
//		System.out.println("jimHouse = " + jimHouse);
//		System.out.println("ruleOne = " + ruleOne);
//		System.out.println("ruleTwo = " + ruleTwo);
		
		return ruleOne && ruleTwo;
	}
}
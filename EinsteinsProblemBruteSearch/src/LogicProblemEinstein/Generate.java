package LogicProblemEinstein;

import java.util.ArrayList;

public class Generate
{
	HouseProperties house1 = new HouseProperties("HouseOne");
	HouseProperties house2 = new HouseProperties("HouseTwo");
	HouseProperties house3 = new HouseProperties("HouseThree");
	HouseProperties house4 = new HouseProperties("HouseFour");
	HouseProperties house5 = new HouseProperties("HouseFive");

	ArrayList<String> personNationality = new ArrayList<>(5);
	private final String german = "german";
	private final String swede = "swede";
	private final String norweigan = "norweigan";
	private final String english = "english";
	private final String dane = "dane";

	ArrayList<String> houseColor = new ArrayList<>(5);
	private final String whiteColor = "WhiteHouse";
	private final String blueColor = "BlueHouse";
	private final String greenColor = "GreenHouse";
	private final String yellowColor = "YellowHouse";
	private final String redColor = "RedHouse";

	ArrayList<String> housePet = new ArrayList<>(5);
	private final String fishPet = "Fish";
	private final String dogPet = "Dog";
	private final String catPet = "Cat";
	private final String horsePet = "Horse";
	private final String birdPet = "Bird";

	ArrayList<String> houseSmoke = new ArrayList<>(5);
	private final String blendSmoke = "Blend";
	private final String princeSmoke = "Prince";
	private final String blueMasterSmoke = "BlueMaster";
	private final String dunhillSmoke = "DunHill";
	private final String pallMallSmoke = "PallMall";

	ArrayList<String> houseDrink = new ArrayList<>(5);
	private final String milkDrink = "Milk";
	private final String coffeeDrink = "Coffee";
	private final String teaDrink = "Tea";
	private final String waterDrink = "Water";
	private final String beirDrink = "Beir";

	public Generate()
	{
		houseDrink.add(beirDrink);
		houseDrink.add(coffeeDrink);
		houseDrink.add(milkDrink);
		houseDrink.add(teaDrink);
		houseDrink.add(waterDrink);

		personNationality.add(dane);
		personNationality.add(english);
		personNationality.add(german);
		personNationality.add(swede);
		personNationality.add(norweigan);

		houseColor.add(yellowColor);
		houseColor.add(greenColor);
		houseColor.add(redColor);
		houseColor.add(blueColor);
		houseColor.add(whiteColor);

		houseSmoke.add(dunhillSmoke);
		houseSmoke.add(blendSmoke);
		houseSmoke.add(blueMasterSmoke);
		houseSmoke.add(pallMallSmoke);
		houseSmoke.add(princeSmoke);

		housePet.add(fishPet);
		housePet.add(dogPet);
		housePet.add(catPet);
		housePet.add(birdPet);
		housePet.add(horsePet);
	}

	public void generateAndTest()
	{
//		int count = 0;
//		
		for (String house1nationality : personNationality)
		{
			house1.nationality = house1nationality;
			if (!house1.nationality.equals(norweigan))
				continue;
			for (String house1Color : houseColor)
			{
				house1.color = house1Color;
				for (String house1Pet : housePet)
				{
					house1.pet = house1Pet;
					for (String house1Smoke : houseSmoke)
					{
						house1.smoke = house1Smoke;
						for (String house1Drink : houseDrink)
						{
							house1.drink = house1Drink;

							for (String house2nationality : personNationality)
							{
								if (house2nationality.equals(house1nationality))
									continue;
								house2.nationality = house2nationality;
								for (String house2Color : houseColor)
								{
									if (!house2Color.equals(blueColor)) continue;
									if (house2Color.equals(house1Color))
										continue;
									house2.color = house2Color;
									for (String house2Pet : housePet)
									{
										if (house2Pet.equals(house1Pet))
											continue;
										house2.pet = house2Pet;
										for (String house2Smoke : houseSmoke)
										{
											if (house2Smoke.equals(house1Smoke))
												continue;
											house2.smoke = house2Smoke;
											for (String house2Drink : houseDrink)
											{
												if (house2Drink.equals(house1Drink))
													continue;
												house2.drink = house2Drink;

												for (String house3nationality : personNationality)
												{
													if (house3nationality.equals(house1nationality)
															|| house3nationality.equals(house2nationality))
														continue;
													house3.nationality = house3nationality;
																											
													for (String house3Color : houseColor)
													{
														if (house3Color.equals(house1Color)
																|| house3Color.equals(house2Color))
															continue;
														house3.color = house3Color;
														for (String house3Pet : housePet)
														{
															if (house3Pet.equals(house1Pet)
																	|| house3Pet.equals(house2Pet))
																continue;
															house3.pet = house3Pet;
															for (String house3Smoke : houseSmoke)
															{
																if (house3Smoke.equals(house1Smoke)
																		|| house3Smoke.equals(house2Smoke))
																	continue;
																house3.smoke = house3Smoke;
																for (String house3Drink : houseDrink)
																{
																	if (house3Drink.equals(house1Drink)
																			|| house3Drink.equals(house2Drink))
																		continue;
																	house3.drink = house3Drink;
																	if (!house3.drink.equals(milkDrink))
																		continue;
																	
//																	if (!testRules(house1, house2, house3, house4, house5)) continue;

																	for (String house4nationality : personNationality)
																	{
																		if (house4nationality.equals(house1nationality)
																				|| house4nationality
																						.equals(house2nationality)
																				|| house4nationality
																						.equals(house3nationality))
																			continue;
																		house4.nationality = house4nationality;
																		for (String house4Color : houseColor)
																		{
																			if (house4Color.equals(house1Color)
																					|| house4Color.equals(house2Color)
																					|| house4Color.equals(house3Color))
																				continue;
																			house4.color = house4Color;
																			for (String house4Pet : housePet)
																			{
																				if (house4Pet.equals(house1Pet)
																						|| house4Pet.equals(house2Pet)
																						|| house4Pet.equals(house3Pet))
																					continue;
																				house4.pet = house4Pet;
																				for (String house4Smoke : houseSmoke)
																				{
																					if (house4Smoke.equals(house1Smoke)
																							|| house4Smoke
																									.equals(house2Smoke)
																							|| house4Smoke.equals(
																									house3Smoke))
																						continue;
																					house4.smoke = house4Smoke;
																					for (String house4Drink : houseDrink)
																					{
																						if (house4Drink
																								.equals(house1Drink)
																								|| house4Drink
																										.equals(house2Drink)
																								|| house4Drink.equals(
																										house3Drink))
																							continue;
																						house4.drink = house4Drink;

																						for (String house5nationality : personNationality)
																						{
																							if (house5nationality
																									.equals(house1nationality)
																									|| house5nationality
																											.equals(house2nationality)
																									|| house5nationality
																											.equals(house3nationality)
																									|| house5nationality
																											.equals(house4nationality))
																								continue;
																							house5.nationality = house5nationality;
																							for (String house5Color : houseColor)
																							{
																								if (house5Color
																										.equals(house1Color)
																										|| house5Color
																												.equals(house2Color)
																										|| house5Color
																												.equals(house3Color)
																										|| house5Color
																												.equals(house4Color))
																									continue;
																								house5.color = house5Color;
																								for (String house5Pet : housePet)
																								{
																									if (house5Pet
																											.equals(house1Pet)
																											|| house5Pet
																													.equals(house2Pet)
																											|| house5Pet
																													.equals(house3Pet)
																											|| house5Pet
																													.equals(house4Pet))
																										continue;
																									house5.pet = house5Pet;
																									for (String house5Smoke : houseSmoke)
																									{
																										if (house5Smoke
																												.equals(house1Smoke)
																												|| house5Smoke
																														.equals(house2Smoke)
																												|| house5Smoke
																														.equals(house3Smoke)
																												|| house5Smoke
																														.equals(house4Smoke))
																											continue;
																										house5.smoke = house5Smoke;
																										for (String house5Drink : houseDrink)
																										{
																											if (house5Drink
																													.equals(house1Drink)
																													|| house5Drink
																															.equals(house2Drink)
																													|| house5Drink
																															.equals(house3Drink)
																													|| house5Drink
																															.equals(house4Drink))
																												continue;
																											house5.drink = house5Drink;
																											
//																											count++;
																											
//																											if (count % 100000 == 0)
//																											{
//																												System.out.println();
//																												System.out.println(count);
//																												System.out.println(house1);
//																												System.out.println(house2);
//																												System.out.println(house3);
//																												System.out.println(house4);
//																												System.out.println(house5);
//																											}
																											
																											if (testRules(house1, house2, house3, house4, house5))
																											{
																												System.out.println("\nFound Solution:");
																												System.out.println(house1);
																												System.out.println(house2);
																												System.out.println(house3);
																												System.out.println(house4);
																												System.out.println(house5);
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}

						}
					}
				}
			}
			
		}

	}

	public boolean testRules(HouseProperties house1, HouseProperties house2, HouseProperties house3,
			HouseProperties house4, HouseProperties house5)
	{

		boolean ruleOne = true;
		boolean ruleTwo = true;
		boolean ruleThree = true;
		boolean ruleFour = true;
		boolean ruleFive = true;
		boolean ruleSix = true;
		boolean ruleSeven = true;
		boolean ruleEight = true;
		boolean ruleNine = true;
		boolean ruleTen = true;
		boolean ruleEleven = true;
		boolean ruleTwelve = true;
		boolean ruleThirteen = true;
		boolean ruleFourteen = true;
		boolean ruleFifteen = true;
		if(!checkRuleOne())
		{
			ruleOne = false;
	}
		if(!checkRuleTwo())
		{
			ruleTwo = false;
		}
		if(!checkRuleThree())
		{
			ruleThree = false;
		}
		if(!checkRuleFour())
		{
			ruleFour = false;
		}
			if(!checkRuleFive())
			{
				ruleFive = false;
			}
if(!checkRuleSix())
{
	ruleSix = false;
}
if(!checkRuleSeven())
{
	ruleSeven = false;
}
	if (!checkRuleEight())
	{
		ruleEight = false;
	}
		if(!checkRuleNine())
		{
			ruleNine = false;
		}
			if(!checkRuleTen())
			{
				ruleTen = false;
			}
		if(!checkRuleEleven())
		{
			ruleEleven = false;
		}
		if(!checkRuleTwelve())
		{
			ruleTwelve = false;
		}
		if(!checkRuleThirteen())
		{
			ruleThirteen = false;
		}
		if(!checkRuleFourteen())
		{
			ruleFourteen = false;
		}
		if(!checkRuleFifteen())
		{
			ruleFifteen = false;
		}
		
		return ruleOne && ruleTwo && ruleThree && ruleFour && ruleFive && ruleSix && ruleSeven
				&& ruleTen && ruleEleven && ruleThirteen && ruleTwelve && ruleFifteen;
	
	
	}

	
	private boolean checkRuleFourteen()
	{
		if (house1.nationality.equals(norweigan) && !house2.color.equals(blueColor))
			return false;
		else if (house1.nationality.equals(norweigan) && house2.color.equals(blueColor))
		{
			return true;
		}
		if (house2.nationality.equals(norweigan) && !house3.color.equals(blueColor) || !house1.color.equals(blueColor))
			return false;
		else if (house2.nationality.equals(norweigan) && house3.color.equals(blueColor)
				|| house1.color.equals(blueColor))
		{
			return true;
		}
		if (house3.nationality.equals(norweigan) && !house4.color.equals(blueColor) || !house2.color.equals(blueColor))
			return false;
		else if (house3.nationality.equals(norweigan) && house4.color.equals(blueColor)
				|| house2.color.equals(blueColor))
		{
			return true;
		}
		if (house4.nationality.equals(norweigan) && !house5.color.equals(blueColor) || !house3.color.equals(blueColor))
			return false;
		else if (house4.nationality.equals(norweigan) && house5.color.equals(blueColor)
				|| house3.color.equals(blueColor))
		{
			return true;
		}
		if (house5.nationality.equals(norweigan) && !house4.color.equals(blueColor))
			return false;
		else if (house5.nationality.equals(norweigan) && house4.color.equals(blueColor))
		{
			return true;
		}
		return true;
	}

	private boolean checkRuleThirteen()
	{
		if (!checkRuleThirteen(house1)) return false;
		if (!checkRuleThirteen(house2)) return false;
		if (!checkRuleThirteen(house3)) return false;
		if (!checkRuleThirteen(house4)) return false;
		if (!checkRuleThirteen(house5)) return false;
		return true;
	}

	private boolean checkRuleThirteen(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.smoke, princeSmoke, house.nationality, german);
	}

	
	private boolean checkRuleEleven()
	{
		if (!checkRuleEleven(house1)) return false;
		if (!checkRuleEleven(house2)) return false;
		if (!checkRuleEleven(house3)) return false;
		if (!checkRuleEleven(house4)) return false;
		if (!checkRuleEleven(house5)) return false;
		return true;
	}

	private boolean checkRuleEleven(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.smoke, blueMasterSmoke, house.drink, beirDrink);
	}

	private boolean checkRuleNine()
	{
		if (!house1.nationality.equals(norweigan))
		{
			return false;
		}
		return true;
	}

	private boolean checkRuleEight()
	{
		if (!house3.drink.equals(milkDrink))
		{
			return false;
		}

		return true;
	}

	private boolean checkRuleSeven()
	{
		if (!checkRuleSeven(house1)) return false;
		if (!checkRuleSeven(house2)) return false;
		if (!checkRuleSeven(house3)) return false;
		if (!checkRuleSeven(house4)) return false;
		if (!checkRuleSeven(house5)) return false;
		return true;
	}

	private boolean checkRuleSeven(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.color, yellowColor, house.smoke, dunhillSmoke);
	}

	private boolean checkRuleSix()
	{
		if (!checkRuleSix(house1)) return false;
		if (!checkRuleSix(house2)) return false;
		if (!checkRuleSix(house3)) return false;
		if (!checkRuleSix(house4)) return false;
		if (!checkRuleSix(house5)) return false;
		return true;
	}

	private boolean checkRuleSix(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.smoke, pallMallSmoke, house.pet, birdPet);
	}

	private boolean checkRuleFive()
	{
		if (!checkRuleFive(house1)) return false;
		if (!checkRuleFive(house2)) return false;
		if (!checkRuleFive(house3)) return false;
		if (!checkRuleFive(house4)) return false;
		if (!checkRuleFive(house5)) return false;
		return true;
	}

	private boolean checkRuleFive(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.color, greenColor, house.drink, coffeeDrink);
	}

	private boolean checkRuleFour()
	{
		if (!checkRuleFour(house1, house2)) return false;
		if (!checkRuleFour(house2, house3)) return false;
		if (!checkRuleFour(house3, house4)) return false;
		if (!checkRuleFour(house4, house5)) return false;
		
		return true;
	}
	
	private boolean checkRuleFour(HouseProperties leftHouse, HouseProperties rightHouse)
	{
		String leftHouseColor = leftHouse.color;
		String rightHouseColor = rightHouse.color;
		
		if (leftHouseColor.equals(greenColor))
		{
			if (rightHouseColor.equals("")) return true;
			if (rightHouseColor.equals(whiteColor)) return true;
			return false;
		}
		
		if (rightHouseColor.equals(whiteColor))
		{
			if (leftHouseColor.equals("")) return true;
			if (leftHouseColor.equals(greenColor)) return true;
			return false;
		}
		
		return true;
	}

	private boolean checkRuleThree()
	{
		if (!checkRuleThree(house1)) return false;
		if (!checkRuleThree(house2)) return false;
		if (!checkRuleThree(house3)) return false;
		if (!checkRuleThree(house4)) return false;
		if (!checkRuleThree(house5)) return false;
		return true;
	}

	private boolean checkRuleThree(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.nationality, dane, house.drink, teaDrink);
	}
	
	private boolean checkRuleTwo()
	{
		if (!checkRuleTwo(house1)) return false;
		if (!checkRuleTwo(house2)) return false;
		if (!checkRuleTwo(house3)) return false;
		if (!checkRuleTwo(house4)) return false;
		if (!checkRuleTwo(house5)) return false;
		return true;
	}
	
	private boolean checkRuleTwo(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.nationality, swede, house.pet, dogPet);
	}

	private boolean checkRuleOne()
	{
		if (!checkRuleOne(house1)) return false;
		if (!checkRuleOne(house2)) return false;
		if (!checkRuleOne(house3)) return false;
		if (!checkRuleOne(house4)) return false;
		if (!checkRuleOne(house5)) return false;
		return true;
	}
	
	private boolean checkRuleOne(HouseProperties house)
	{
		return checkPropertiesMustBeSame(house.nationality, english, house.color, redColor);
	}
	
	public boolean checkPropertiesMustBeSame(String propertyOne, String mustBeOne, String propertyTwo, String mustBeTwo)
	{
		if (propertyOne.equals("")) return true;
		if (propertyTwo.equals("")) return true;

		if (propertyOne.equals(mustBeOne) && (!propertyTwo.equals(mustBeTwo))) return false;
		if (!propertyOne.equals(mustBeOne) && (propertyTwo.equals(mustBeTwo))) return false;
		
		return true;
	}
	
	public boolean checkRuleTen()
	{
		if (!checkRuleTen(null, house1, house2)) return false;
		if (!checkRuleTen(house1, house2, house3)) return false;
		if (!checkRuleTen(house2, house3, house4)) return false;
		if (!checkRuleTen(house3, house4, house5)) return false;
		if (!checkRuleTen(house4, house5, null)) return false;
		
		return true;
	}

	public boolean checkRuleTen(HouseProperties leftNeighbor, HouseProperties houseToCheck, HouseProperties rightNeighbor)
	{
		String propertyToCheck = houseToCheck.smoke;
		String propertyIfEquals = blendSmoke;
		String neighborMatch = catPet;

		String leftNeighborProperty = null;
		if (leftNeighbor != null) leftNeighborProperty = leftNeighbor.pet;
		
		String rightNeighborProperty = null;
		if (rightNeighbor != null) rightNeighborProperty = rightNeighbor.pet;
		
		return checkNeighborProperty(propertyToCheck, propertyIfEquals, leftNeighborProperty, rightNeighborProperty, neighborMatch);
	}
	
	public boolean checkRuleTwelve()
	{
		if (!checkRuleTwelve(null, house1, house2)) return false;
		if (!checkRuleTwelve(house1, house2, house3)) return false;
		if (!checkRuleTwelve(house2, house3, house4)) return false;
		if (!checkRuleTwelve(house3, house4, house5)) return false;
		if (!checkRuleTwelve(house4, house5, null)) return false;
		
		return true;
	}
	
	public boolean checkRuleTwelve(HouseProperties leftNeighbor, HouseProperties houseToCheck, HouseProperties rightNeighbor)
	{
		String propertyToCheck = houseToCheck.pet;
		String propertyIfEquals = horsePet;
		String neighborMatch = dunhillSmoke;

		String leftNeighborProperty = null;
		if (leftNeighbor != null) leftNeighborProperty = leftNeighbor.smoke;
		
		String rightNeighborProperty = null;
		if (rightNeighbor != null) rightNeighborProperty = rightNeighbor.smoke;
		
		return checkNeighborProperty(propertyToCheck, propertyIfEquals, leftNeighborProperty, rightNeighborProperty, neighborMatch);
	}
	
	public boolean checkRuleFifteen()
	{
		if (!checkRuleFifteen(null, house1, house2)) return false;
		if (!checkRuleFifteen(house1, house2, house3)) return false;
		if (!checkRuleFifteen(house2, house3, house4)) return false;
		if (!checkRuleFifteen(house3, house4, house5)) return false;
		if (!checkRuleFifteen(house4, house5, null)) return false;
		
		return true;
	}
	
	public boolean checkRuleFifteen(HouseProperties leftNeighbor, HouseProperties houseToCheck, HouseProperties rightNeighbor)
	{
		String propertyToCheck = houseToCheck.smoke;
		String propertyIfEquals = blendSmoke;
		String neighborMatch = waterDrink;

		String leftNeighborProperty = null;
		if (leftNeighbor != null) leftNeighborProperty = leftNeighbor.drink;
		
		String rightNeighborProperty = null;
		if (rightNeighbor != null) rightNeighborProperty = rightNeighbor.drink;
		
		return checkNeighborProperty(propertyToCheck, propertyIfEquals, leftNeighborProperty, rightNeighborProperty, neighborMatch);
	}

	private boolean checkNeighborProperty(String propertyToCheck, String propertyIfEquals, String leftNeighborProperty,
			String rightNeighborProperty, String neighborMatch)
	{
		if (!propertyToCheck.equals(propertyIfEquals)) return true;
		
		if ((leftNeighborProperty != null) && (leftNeighborProperty.equals(""))) return true;
		if ((rightNeighborProperty != null) && (rightNeighborProperty.equals(""))) return true;

		if ((leftNeighborProperty == null) && (!rightNeighborProperty.equals(neighborMatch))) return false;
		if ((rightNeighborProperty == null) && (!leftNeighborProperty.equals(neighborMatch))) return false;
		
		if ((leftNeighborProperty != null) && (rightNeighborProperty != null))
		{
			if ((!leftNeighborProperty.equals(neighborMatch)) && (!rightNeighborProperty.equals(neighborMatch))) return false;
		}

		return true;
	}
	
//	public boolean checkNeighborProperties(String mustBeOne, String mustBeTwo, String leftHousePropertyOne, String leftHousePropertyTwo, )
//	{
//		if (propertyOne.equals("")) return true;
//		if (propertyTwo.equals("")) return true;
//
//		if (propertyOne.equals(mustBeOne) && (!propertyTwo.equals(mustBeTwo))) return false;
//		if (!propertyOne.equals(mustBeOne) && (propertyTwo.equals(mustBeTwo))) return false;
//		
//		return true;
//	}
	
}

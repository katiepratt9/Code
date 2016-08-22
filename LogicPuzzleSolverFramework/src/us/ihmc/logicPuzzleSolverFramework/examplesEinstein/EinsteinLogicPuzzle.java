package us.ihmc.logicPuzzleSolverFramework.examplesEinstein;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleProperty;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleRuleChecker;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class EinsteinLogicPuzzle
{
	EinsteinHouseNationalityLogicPuzzleProperty nationalityProperty = new EinsteinHouseNationalityLogicPuzzleProperty();
	EinsteinHouseColorLogicPuzzleProperty colorProperty = new EinsteinHouseColorLogicPuzzleProperty();
	EinsteinHouseDrinkLogicPuzzleProperty drinkProperty = new EinsteinHouseDrinkLogicPuzzleProperty();
	EinsteinHousePetLogicPuzzleProperty petProperty = new EinsteinHousePetLogicPuzzleProperty();
	EinsteinHouseSmokeLogicPuzzleProperty smokeProperty = new EinsteinHouseSmokeLogicPuzzleProperty();

	EinsteinLogicPuzzleRuleChecker ruleChecker = new EinsteinLogicPuzzleRuleChecker();

	LogicPuzzle puzzle = new LogicPuzzle();

	public EinsteinLogicPuzzle()
	{
		puzzle.addProperty(nationalityProperty);
		puzzle.addProperty(colorProperty);
		puzzle.addProperty(drinkProperty);
		puzzle.addProperty(smokeProperty);
		puzzle.addProperty(petProperty);

		ruleChecker.setNationalityProperty(nationalityProperty);
		ruleChecker.setColorProperty(colorProperty);
		ruleChecker.setDrinkProperty(drinkProperty);
		ruleChecker.setSmokeProperty(smokeProperty);
		ruleChecker.setPetProperty(petProperty);

		puzzle.setRuleChecker(ruleChecker);
	}

	public ArrayList<LogicPuzzleState> solve()
	{
		ArrayList<LogicPuzzleState> solutions = puzzle.solve();
		return solutions;
	}

	public static void main(String[] args)
	{
		EinsteinLogicPuzzle puzzle = new EinsteinLogicPuzzle();
		ArrayList<LogicPuzzleState> solutions = puzzle.solve();

		System.out.println("Found " + solutions.size() + " solutions:");
		for (LogicPuzzleState solution : solutions)
		{
			System.out.println(solution);
		}
	}

	public ArrayList<LogicPuzzleProperty> getProperties()
	{
		return puzzle.getProperties();
	}

	public LogicPuzzleRuleChecker getRulesChecker()
	{
		return puzzle.getRuleChecker();
		
	}
}

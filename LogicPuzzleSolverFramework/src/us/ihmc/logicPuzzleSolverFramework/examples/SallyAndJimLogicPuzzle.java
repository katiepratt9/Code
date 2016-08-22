package us.ihmc.logicPuzzleSolverFramework.examples;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class SallyAndJimLogicPuzzle
{
	public static void main(String[] args)
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
		ArrayList<LogicPuzzleState> solution = puzzle.solve();
		
		System.out.println(solution.get(0));
	}
}

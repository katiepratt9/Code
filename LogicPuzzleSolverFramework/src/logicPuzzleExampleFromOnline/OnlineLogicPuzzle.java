package logicPuzzleExampleFromOnline;

import java.util.ArrayList;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class OnlineLogicPuzzle
{
	public static void main(String[] args)
	{
		OnlineLocationLogicPuzzleProperty locationProperty = new OnlineLocationLogicPuzzleProperty();
		OnlineItemLogicPuzzleProperty itemProperty = new OnlineItemLogicPuzzleProperty();
		OnlinePriceLogicPuzzleProperty priceProperty = new OnlinePriceLogicPuzzleProperty();

		LogicPuzzle puzzle = new LogicPuzzle();
		puzzle.addProperty(locationProperty);
		puzzle.addProperty(itemProperty);
		puzzle.addProperty(priceProperty);

		OnlineLogizPuzzleRuleChecker ruleChecker = new OnlineLogizPuzzleRuleChecker();
		ruleChecker.setItemProperty(itemProperty);
		ruleChecker.setNameProperty(locationProperty);
		ruleChecker.setTimeProperty(priceProperty);

		puzzle.setRuleChecker(ruleChecker);
		ArrayList<LogicPuzzleState> solution = puzzle.solve();

		System.out.println(solution.get(0));
	}
}

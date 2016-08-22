package us.ihmc.logicPuzzleSolverFramework.examples.fourNeighbors;

import java.util.ArrayList;

import us.ihmc.logicPuzzleSolverFramework.LogicPuzzle;
import us.ihmc.logicPuzzleSolverFramework.LogicPuzzleState;

public class FourNeighborsLogicPuzzle
{
	private final LogicPuzzle puzzle = new LogicPuzzle();
	
	private final FourNeighborsNameLogicPuzzleProperty nameProperty = new FourNeighborsNameLogicPuzzleProperty();
	private final FourNeighborsPetLogicPuzzleProperty petProperty = new FourNeighborsPetLogicPuzzleProperty();
	
	private final FourNeighborsLogicPuzzleRuleChecker ruleChecker = new FourNeighborsLogicPuzzleRuleChecker();

	public FourNeighborsLogicPuzzle()
	{
		puzzle.addProperty(nameProperty);
		puzzle.addProperty(petProperty);
		
		ruleChecker.setNameProperty(nameProperty);
		ruleChecker.setPetProperty(petProperty);
		
		puzzle.setRuleChecker(ruleChecker);
	}
	
	public FourNeighborsLogicPuzzleRuleChecker getRuleChecker()
	{
		return ruleChecker;
	}
	
	public FourNeighborsNameLogicPuzzleProperty getFourNeighborsNameLogicPuzzleProperty()
	{
		return nameProperty;
	}
	
	public FourNeighborsPetLogicPuzzleProperty getFourNeighborsPetLogicPuzzleProperty()
	{
		return petProperty;
	}
	
	public LogicPuzzle getPuzzle()
	{
		return puzzle;
	}
	
	public ArrayList<LogicPuzzleState> solve()
	{
		ArrayList<LogicPuzzleState> solutions = puzzle.solve();

		for (LogicPuzzleState solution : solutions)
		{
			System.out.println(solution);			
		}
		
		return solutions;
	}
	
	public static void main(String[] args)
	{
		FourNeighborsLogicPuzzle puzzle = new FourNeighborsLogicPuzzle();
		puzzle.solve();
	}
}


package us.ihmc.logicPuzzleSolverFramework;

import java.util.ArrayList;

public class LogicPuzzle
{
	private ArrayList<LogicPuzzleProperty> properties = new ArrayList<>();
	private LogicPuzzleRuleChecker ruleChecker;
	
	public void addProperty(LogicPuzzleProperty property)
	{
		properties.add(property);
	}

	public void setRuleChecker(LogicPuzzleRuleChecker ruleChecker)
	{
		this.ruleChecker = ruleChecker;
	}

	public ArrayList<LogicPuzzleState> solve()
	{
		ArrayList<LogicPuzzleState> solutions = new ArrayList<>();
		
		LogicPuzzleGenerator generator = new LogicPuzzleGenerator(properties);
		
		while(true) //!generator.hasRolledOver())
		{
			ArrayList<ArrayList<String>> next = generator.getNext();
			if (next == null) break;
			
			LogicPuzzleState logicPuzzleState = new LogicPuzzleState(properties, next);

			boolean rulesHold = ruleChecker.rulesHold(logicPuzzleState);
			if (!rulesHold)
			{
				generator.rulesDoNotHoldOnPreviousGenerated();
				continue;
			}
			else if (logicPuzzleState.isComplete())
			{
//				System.out.println(next);
				solutions.add(logicPuzzleState);
			}
			else
			{
				continue;
			}
		}
		
		return solutions;	
	}

	public ArrayList<LogicPuzzleProperty> getProperties()
	{
		return properties;
	}

	public LogicPuzzleRuleChecker getRuleChecker()
	{
		return ruleChecker;
	}
}

package logic;

public class RunLogicProblem
{

	public static void main(String[] args)
	{
		SimpleVersion simp = new SimpleVersion();
		simp.assignAllKnowns();

		while (!simp.allAssigned())
		{
			simp.findRandomUnassigned();
			simp.assignCondition();
		}
		simp.printAnswer();
	}
}

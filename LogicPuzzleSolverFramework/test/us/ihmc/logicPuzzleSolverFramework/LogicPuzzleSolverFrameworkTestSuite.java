package us.ihmc.logicPuzzleSolverFramework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
{
		LogicPuzzleGeneratorTest.class,
		LogicPuzzlePropertyPermutatorTest.class, 
		LogicPuzzleRuleCheckerTest.class, 
		LogicPuzzleTest.class

})

public class LogicPuzzleSolverFrameworkTestSuite
{

}

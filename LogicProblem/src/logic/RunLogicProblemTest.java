package logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunLogicProblemTest
{

	@Test
	public void test()
	{
		SimpleVersion simp = new SimpleVersion();
		assertTrue(simp.allAssigned());
	}

}

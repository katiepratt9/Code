package us.ihmc.logicPuzzleSolverFramework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LogicPuzzlePropertyPermutatorTest
{

	@Test
	public void testBeatlesPermutations()
	{
		LogicPuzzlePropertyPermutator permutator = new LogicPuzzlePropertyPermutator();
		
		ArrayList<String> beatles = new ArrayList<String>();
		beatles.add("Paul");
		beatles.add("Ringo");
		beatles.add("John");
		beatles.add("George");
		
		ArrayList<ArrayList<String>> permutationsOfBeatles = permutator.getPermutations(beatles);
		assertEquals(4*3*2*1, permutationsOfBeatles.size());
		
		ArrayList<String> firstPermutation = permutationsOfBeatles.get(0);
		assertEquals("Paul", firstPermutation.get(3));
		assertEquals("Ringo", firstPermutation.get(2));
		assertEquals("John", firstPermutation.get(1));
		assertEquals("George", firstPermutation.get(0));
		
		ArrayList<String> lastPermutation = permutationsOfBeatles.get(permutationsOfBeatles.size()-1);
		assertEquals("Paul", lastPermutation.get(0));
		assertEquals("Ringo", lastPermutation.get(1));
		assertEquals("John", lastPermutation.get(2));
		assertEquals("George", lastPermutation.get(3));
		
		for (ArrayList<String> permutation : permutationsOfBeatles)
		{
			assertEquals(4, permutation.size());
			assertTrue(permutation.contains("Paul"));
			assertTrue(permutation.contains("Ringo"));
			assertTrue(permutation.contains("John"));
			assertTrue(permutation.contains("George"));
		}
	}

}

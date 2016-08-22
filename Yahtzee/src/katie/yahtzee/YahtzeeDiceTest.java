package katie.yahtzee;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class YahtzeeDiceTest
{

	@Test
	public void testYahtzeeDice()
	{
		YahtzeeDice yahtzeeDice = new YahtzeeDice(new Random());
		yahtzeeDice.rollAll();
		
		boolean[] reroll = new boolean[5];
		yahtzeeDice.reRoll(reroll);
		int[] values = yahtzeeDice.getValues();
		assertEquals(values.length, 5);
		
		for( int i =0; i< 5; i ++)
		{
			assertTrue(values[i] >= 1);
			assertTrue(values[i] <= 6);
		}
				
	}
	
	@Test
	public void testCount()
	{
		YahtzeeDice yahtzeeDice = new YahtzeeDice(new Random(), 1, 5, 3, 4, 3);

		assertEquals(1, yahtzeeDice.count(1));
		assertEquals(0, yahtzeeDice.count(2));
		assertEquals(2, yahtzeeDice.count(3));
		assertEquals(1, yahtzeeDice.count(4));
		assertEquals(1, yahtzeeDice.count(5));
		assertEquals(0, yahtzeeDice.count(6));
		
		assertTrue(yahtzeeDice.atLeastOneDieHasValue(1));
		assertFalse(yahtzeeDice.atLeastOneDieHasValue(2));
		assertTrue(yahtzeeDice.atLeastOneDieHasValue(3));
		assertTrue(yahtzeeDice.atLeastOneDieHasValue(4));
		assertTrue(yahtzeeDice.atLeastOneDieHasValue(5));
		assertFalse(yahtzeeDice.atLeastOneDieHasValue(6));
	}

}

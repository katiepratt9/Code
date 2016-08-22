package katie.yahtzee;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class YahtzeeDieTest
{
	@Test
	public void testRollDice()
	{
		Random random = new Random();
		YahtzeeDie yahtzeeDie = new YahtzeeDie(random);
		testBounds(yahtzeeDie);
		for (int i = 0; i < 1000; i++)
		{
			yahtzeeDie.rollDice();
			testBounds(yahtzeeDie);
		}
	}

	private void testBounds(YahtzeeDie yahtzeeDie)
	{
		int number = yahtzeeDie.getNumber();
		assertTrue(number >= 1);
		assertTrue(number <= 6);
	}

}

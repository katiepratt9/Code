package katie.yahtzee;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class RandomYahtzeePlayerEasyTest
{

	@Test
	public void test()
	{
		Random random = new Random();
		ScoreSheet sheet = new ScoreSheet();
		RandomYahtzeePlayerEasy player = new RandomYahtzeePlayerEasy(random);

		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 2, 2, 2);
		player.chooseHowToScore(dice, sheet);

		assertTrue(player.chooseHowToScore(dice, sheet) == YahtzeeRoll.YAHTZEE);
	}

}

package katie.yahtzee;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class YahtzeeGameTest
{
	@Test
	public void test()
	{
		Random random = new Random();
		RandomYahtzeePlayerEasy player = new RandomYahtzeePlayerEasy(random);
		YahtzeeGame game = new YahtzeeGame();
		game.addPlayer(player);
		game.playGame();
		assertTrue(game.isGameDone());
	}

}

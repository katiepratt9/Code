package katie.yahtzee;

import static org.junit.Assert.*;

import org.junit.Test;

public class YahtzeeRefereeTest
{

	@Test
	public void testIsThreeOfAKind()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 1, 1, 1, 2, 3);
		assertTrue(referee.isThreeOfAKind(dice));

		dice = new YahtzeeDice(null, 4, 1, 1, 4, 4);
		assertTrue(referee.isThreeOfAKind(dice));

		dice = new YahtzeeDice(null, 6, 1, 6, 4, 4);
		assertFalse(referee.isThreeOfAKind(dice));
	}

	@Test
	public void testIsFourOfAKind()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 1, 1, 1, 2, 1);
		assertTrue(referee.isFourOfAKind(dice));

		dice = new YahtzeeDice(null, 4, 4, 1, 4, 4);
		assertTrue(referee.isFourOfAKind(dice));

		dice = new YahtzeeDice(null, 6, 1, 6, 4, 4);
		assertFalse(referee.isFourOfAKind(dice));

		dice = new YahtzeeDice(null, 1, 1, 3, 4, 4);
		assertFalse(referee.isFourOfAKind(dice));
	}

	@Test
	public void testIsYahtzee()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 1, 1, 1, 1, 1);
		assertTrue(referee.isYahtzee(dice));

		dice = new YahtzeeDice(null, 4, 4, 4, 4, 4);
		assertTrue(referee.isYahtzee(dice));

		dice = new YahtzeeDice(null, 6, 6, 6, 4, 4);
		assertFalse(referee.isYahtzee(dice));

		dice = new YahtzeeDice(null, 4, 4, 3, 4, 4);
		assertFalse(referee.isYahtzee(dice));
	}

	@Test
	public void testIsSmallStraight()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 2, 1, 3, 4, 1);
		assertTrue(referee.isSmStraight(dice));

		dice = new YahtzeeDice(null, 3, 5, 2, 4, 4);
		assertTrue(referee.isSmStraight(dice));

		dice = new YahtzeeDice(null, 1, 4, 6, 2, 5);
		assertFalse(referee.isSmStraight(dice));

		dice = new YahtzeeDice(null, 4, 4, 4, 4, 4);
		assertFalse(referee.isSmStraight(dice));
	}
	
	@Test
	public void testisLrgStraight()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 2, 1, 3, 4, 5);
		assertTrue(referee.isLrgStraight(dice));

		dice = new YahtzeeDice(null, 3, 5, 2, 4, 6);
		assertTrue(referee.isLrgStraight(dice));

		dice = new YahtzeeDice(null, 1, 4, 6, 6, 5);
		assertFalse(referee.isLrgStraight(dice));

		dice = new YahtzeeDice(null, 4, 3, 3, 2, 5);
		assertFalse(referee.isLrgStraight(dice));
	}

	@Test
	public void testIsFullHouse()
	{
		YahtzeeReferee referee = new YahtzeeReferee();
		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 3, 3, 3);
		assertTrue(referee.isFullHouse(dice));

		dice = new YahtzeeDice(null, 3, 3, 4, 4, 4);
		assertTrue(referee.isFullHouse(dice));

		dice = new YahtzeeDice(null, 3, 3, 3, 3, 3);
		assertFalse(referee.isFullHouse(dice));
		
		dice = new YahtzeeDice(null, 3, 3, 2, 2, 4);
		assertFalse(referee.isFullHouse(dice));
		
		dice = new YahtzeeDice(null, 3, 6, 6, 5, 6);
		assertFalse(referee.isFullHouse(dice));

	}
}

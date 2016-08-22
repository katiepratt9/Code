package katie.yahtzee;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreSheetTest
{
	@Test
	public void testAces()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 1, 3, 3);
		sheet.scoreAces(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(1, sheet.getUpperHalfTotal());
		assertEquals(1, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 1, 2, 1, 1, 1);
		try
		{
			sheet.scoreAces(dice);
			fail("Already scored aces.");
		} catch (Exception exception)
		{
		}

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(1, sheet.getUpperHalfTotal());
		assertEquals(1, sheet.getGrandTotal());
	}

	@Test
	public void testFullHouse()
	{
		ScoreSheet sheet = new ScoreSheet();
		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 3, 3, 3);
		sheet.scoreFullHouse(dice);
		assertEquals(25, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(25, sheet.getGrandTotal());
		try
		{
			sheet.scoreFullHouse(dice);
			fail("Already scored fullHouse.");
		} catch (Exception exception)
		{
		}
		assertEquals(25, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(25, sheet.getGrandTotal());
	}

	@Test
	public void testTwos()
	{
		
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 1, 3, 3);
		sheet.scoreTwos(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(4, sheet.getUpperHalfTotal());
		assertEquals(4, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 1, 2, 1, 1, 1);
		try
		{
			sheet.scoreTwos(dice);
			fail("Already scored aces.");
		} catch (Exception exception)
		{
		}

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(4, sheet.getUpperHalfTotal());
		assertEquals(4, sheet.getGrandTotal());
	}

	@Test
	public void testThrees()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 2, 2, 3, 3, 3);
		sheet.scoreThrees(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(9, sheet.getUpperHalfTotal());
		assertEquals(9, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 1, 3, 3, 2, 2);
		try
		{
			sheet.scoreThrees(dice);
			fail("Already scored threes.");
		} catch (Exception exception)
		{
		}

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(9, sheet.getUpperHalfTotal());
		assertEquals(9, sheet.getGrandTotal());
	}

	@Test
	public void testFours()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 4, 2, 3, 4, 3);
		sheet.scoreFours(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(8, sheet.getUpperHalfTotal());
		assertEquals(8, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 4, 4, 4, 2, 2);
		try
		{
			sheet.scoreFours(dice);
			fail("Already scored fours.");
		} catch (Exception exception)
		{
		}

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(8, sheet.getUpperHalfTotal());
		assertEquals(8, sheet.getGrandTotal());
	}

	@Test
	public void testFives()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 4, 5, 3, 4, 3);
		sheet.scoreFives(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(5, sheet.getUpperHalfTotal());
		assertEquals(5, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 5, 4, 5, 2, 2);
		try
		{
			sheet.scoreFives(dice);
			fail("Already scored fives.");
		} catch (Exception exception)
		{
		}
		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(5, sheet.getUpperHalfTotal());
		assertEquals(5, sheet.getGrandTotal());
	}

	@Test
	public void testSixes()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 4, 6, 6, 4, 3);
		sheet.scoreSixes(dice);

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(12, sheet.getUpperHalfTotal());
		assertEquals(12, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 6, 4, 6, 6, 2);
		try
		{
			sheet.scoreSixes(dice);
			fail("Already scored sixes.");
		} catch (Exception exception)
		{
		}

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(12, sheet.getUpperHalfTotal());
		assertEquals(12, sheet.getGrandTotal());
	}

	@Test
	public void testThreeOfAKind()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 6, 6, 6, 4, 3);
		sheet.scoreThreeOfAKind(dice);

		assertEquals(25, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(25, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 6, 4, 6, 6, 2);
		try
		{
			sheet.scoreThreeOfAKind(dice);
			fail("Already scored three of a kind.");
		} catch (Exception exception)
		{
		}

		assertEquals(25, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(25, sheet.getGrandTotal());
	}

	@Test
	public void testFourOfAKind()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 6, 6, 6, 6, 3);
		sheet.scoreFourOfAKind(dice);

		assertEquals(27, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(27, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 3, 4, 3, 3, 3);
		try
		{
			sheet.scoreFourOfAKind(dice);
			fail("Already scored four of a kind.");
		} catch (Exception exception)
		{
		}

		assertEquals(27, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(27, sheet.getGrandTotal());
	}

	@Test
	public void testSmStraight()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 1, 2, 3, 4, 3);
		sheet.scoreSmStraight(dice);

		assertEquals(30, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(30, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 3, 4, 5, 6, 3);
		try
		{
			sheet.scoreSmStraight(dice);
			fail("Already scored small straight.");
		} catch (Exception exception)
		{
		}

		assertEquals(30, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(30, sheet.getGrandTotal());
	}

	@Test
	public void testLrgStraight()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 1, 2, 3, 4, 5);
		sheet.scoreLrgStraight(dice);

		assertEquals(40, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(40, sheet.getGrandTotal());

		try
		{
			sheet.scoreLrgStraight(dice);
			fail("Already scored large straight.");
		} catch (Exception exception)
		{
		}
		assertEquals(40, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(40, sheet.getGrandTotal());
	}

	@Test
	public void testYahtzee()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 1, 1, 1, 1, 1);
		sheet.scoreYahtzee(dice);
		assertEquals(50, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(50, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 3, 3, 3, 3, 3);
		try
		{
			sheet.scoreYahtzee(dice);
			fail("Already scored yahtzee.");
		} catch (Exception exception)
		{
		}

		assertEquals(50, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(50, sheet.getGrandTotal());
	}

	@Test
	public void testChance()
	{
		ScoreSheet sheet = new ScoreSheet();

		assertEquals(0, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(0, sheet.getGrandTotal());

		YahtzeeDice dice = new YahtzeeDice(null, 5, 6, 4, 2, 1);
		sheet.scoreChance(dice);

		assertEquals(18, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(18, sheet.getGrandTotal());

		dice = new YahtzeeDice(null, 3, 4, 3, 6, 3);
		try
		{
			sheet.scoreChance(dice);
			fail("Already scored chance.");
		} catch (Exception exception)
		{
		}

		assertEquals(18, sheet.getLowerHalfTotal());
		assertEquals(0, sheet.getUpperHalfTotal());
		assertEquals(18, sheet.getGrandTotal());
	}

}

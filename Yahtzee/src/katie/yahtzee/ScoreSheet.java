package katie.yahtzee;

import java.util.ArrayList;
import java.util.Random;

public class ScoreSheet extends YahtzeeReferee
{
	private final int NOT_SCORED = -1;
	private int acesScore = NOT_SCORED;
	private int twosScore = NOT_SCORED;
	private int threesScore = NOT_SCORED;
	private int foursScore = NOT_SCORED;
	private int fivesScore = NOT_SCORED;
	private int sixesScore = NOT_SCORED;
	private int bonusScore = NOT_SCORED;
	private int threeOfAKindScore = NOT_SCORED;
	private int fourOfAKindScore = NOT_SCORED;
	private int fullHouseScore = NOT_SCORED;
	private int smStraightScore = NOT_SCORED;
	private int lrgStraightScore = NOT_SCORED;
	private int yahtzeeScore = NOT_SCORED;
	private int chanceScore = NOT_SCORED;

	public String toString()
	{
		for (int i = 0; i < YahtzeeRoll.values().length; i++)
		{
			System.out.println(i + " " + YahtzeeRoll.values()[i].toString());
		}
		return "";
	}

	public boolean isSheetFull()
	{
		for (YahtzeeRoll roll : YahtzeeRoll.values())
		{
			if (!wasScored(roll))
				return false;
		}
		return true;

	}

	private boolean canScore(int value)
	{
		if (value == NOT_SCORED)
		{
			return true;
		}
		return false;
	}

	public int currentScoreOfAces()
	{
		return acesScore;
	}

	public int currentScoreOfTwos()
	{
		return twosScore;
	}

	public int currentScoreOfThrees()
	{
		return threesScore;
	}

	public int currentScoreOfFours()
	{
		return foursScore;
	}

	public int currentScoreOfFives()
	{
		return fivesScore;
	}

	public int currentScoreOfSixes()
	{
		return sixesScore;
	}

	public int currentScoreOfFourOfAKind()
	{
		return fourOfAKindScore;
	}

	public int currentScoreThreeOfAKind()
	{
		return threeOfAKindScore;
	}

	public int currentScoreOfFullHouse()
	{
		return fullHouseScore;
	}

	public int currentScoreOfChance()
	{
		return chanceScore;
	}

	public int currentScoreOfSmStraight()
	{
		return smStraightScore;
	}

	public int currentScoreOfLrgStraight()
	{
		return lrgStraightScore;
	}

	public int currentScoreOfYahtzee()
	{
		return yahtzeeScore;
	}

	private boolean wasBonusScored()
	{
		return wasScored(bonusScore);
	}

	public boolean wasSmStraightScored()
	{
		return wasScored(smStraightScore);
	}

	public boolean wasLrgStraightScored()
	{
		return wasScored(lrgStraightScore);
	}

	public boolean wasThreeOfAKindScored()
	{
		return wasScored(threeOfAKindScore);
	}

	public boolean wasFourOfAKindScored()
	{
		return wasScored(fourOfAKindScore);
	}

	public boolean wasFullHouseScored()
	{
		return wasScored(fullHouseScore);
	}

	private boolean wasScored(int value)
	{
		return (value != NOT_SCORED);
	}

	public boolean wasSixesScored()
	{
		return wasScored(sixesScore);
	}

	public boolean wasFivesScored()
	{
		return wasScored(fivesScore);
	}

	public boolean wasFoursScored()
	{
		return wasScored(foursScore);
	}

	public boolean wasThreesScored()
	{
		return wasScored(threesScore);
	}

	public boolean wasTwosScored()
	{
		return wasScored(twosScore);
	}

	public boolean wasAcesScored()
	{
		return wasScored(acesScore);
	}

	public boolean wasYahtzeeScored()
	{
		return wasScored(yahtzeeScore);
	}

	public void scoreAces(YahtzeeDice dice)
	{
		if (canScore(acesScore))
		{
			int numberOfOnes = dice.count(1);
			if (numberOfOnes >= 1)
			{
				acesScore = numberOfOnes;
			}
			else
			{
				acesScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored aces.");
		}
	}

	public void scoreTwos(YahtzeeDice dice)
	{
		if (canScore(twosScore))
		{
			int numberOfTwos = dice.count(2);
			if (numberOfTwos >= 1)
			{
				twosScore = numberOfTwos * 2;
			}
			else
			{
				twosScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored twos.");
		}
	}

	public void scoreThrees(YahtzeeDice dice)
	{
		if (canScore(threesScore))
		{
			int numberOfThrees = dice.count(3);
			if (numberOfThrees >= 1)
			{
				threesScore = numberOfThrees * 3;
			}
			else
			{
				threesScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored threes.");
		}
	}

	public void scoreFours(YahtzeeDice dice)
	{
		if (canScore(foursScore))
		{
			int numberOfFours = dice.count(4);
			if (numberOfFours >= 1)
			{
				foursScore = numberOfFours * 4;
			}
			else
			{
				foursScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored fours.");

		}

	}

	public void scoreFives(YahtzeeDice dice)
	{
		if (canScore(fivesScore))
		{
			int numberOfFives = dice.count(5);
			if (numberOfFives >= 1)
			{
				fivesScore = numberOfFives * 5;
			}
			else
			{
				fivesScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored fives.");
		}
	}

	public void scoreSixes(YahtzeeDice dice)
	{
		if (canScore(sixesScore))
		{
			int numberOfSixes = dice.count(6);
			if (numberOfSixes >= 1)
			{
				sixesScore = numberOfSixes * 6;
			}
			else
			{
				sixesScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored sixes.");
		}

	}

	public void scoreThreeOfAKind(YahtzeeDice dice)
	{
		if (canScore(threeOfAKindScore))
		{
			for (int i = 1; i <= 6; i++)
				if (dice.atLeastThreeDieHasValue(i))
				{
					threeOfAKindScore = addAllDice(dice);
				}
				else
				{
					threeOfAKindScore = 0;
				}
		}
		else
		{
			throw new RuntimeException("You already scored a three of a kind.");
		}
	}

	public void scoreFourOfAKind(YahtzeeDice dice)
	{
		if (canScore(fourOfAKindScore))
		{
			for (int i = 1; i <= 6; i++)
				if (dice.atLeastFourDieHasValue(i))
				{
					fourOfAKindScore = addAllDice(dice);
				}
				else
				{
					fourOfAKindScore = 0;
				}
		}
		else
		{
			throw new RuntimeException("You already scored a three of a kind.");
		}
	}

	public void scoreSmStraight(YahtzeeDice dice)
	{

		if (canScore(smStraightScore))
		{
			if (isSmStraight(dice))
				smStraightScore = 30;
			else
				smStraightScore = 0;
		}
		else
		{
			throw new RuntimeException("You already scored a small straight.");
		}

	}

	public void scoreBonus(YahtzeeDice dice)
	{
		int upperHalfScore = 0;
		if (canScore(bonusScore))
		{
			if (acesScore != NOT_SCORED && twosScore != NOT_SCORED && threesScore != NOT_SCORED
					&& foursScore != NOT_SCORED && fivesScore != NOT_SCORED && sixesScore != NOT_SCORED)
			{
				upperHalfScore = acesScore + twosScore + threesScore + foursScore + fivesScore + sixesScore;
			}

			if (upperHalfScore >= 63)

			{
				bonusScore = 35;
			}
		}
	}

	public void scoreFullHouse(YahtzeeDice dice)
	{
		if (canScore(fullHouseScore))
		{
			if (this.isFullHouse(dice))
			{
				fullHouseScore = 25;
			}
			else
			{
				fullHouseScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored a full house.");
		}
	}

	public void scoreLrgStraight(YahtzeeDice dice)
	{
		if (canScore(lrgStraightScore))
		{
			if (this.isLrgStraight(dice))
			{
				lrgStraightScore = 40;
			}
			else
			{
				lrgStraightScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored a large straight.");
		}
	}

	public void scoreYahtzee(YahtzeeDice dice)
	{
		if (canScore(yahtzeeScore))
		{
			if (this.isYahtzee(dice))
			{
				yahtzeeScore = 50;
			}
			else
			{
				yahtzeeScore = 0;
			}
		}
		else
		{
			throw new RuntimeException("You already scored a Yahtzee.");
		}
	}

	public void scoreChance(YahtzeeDice dice)
	{
		if (canScore(chanceScore))
		{
			chanceScore = addAllDice(dice);
		}
		else
		{
			throw new RuntimeException("You already scored a chance.");
		}
	}

	public boolean wasChanceScored()
	{
		return wasScored(chanceScore);
	}

	private int addAllDice(YahtzeeDice dice)
	{
		int total = 0;
		for (int i = 0; i < 5; i++)
		{
			total = total + dice.getValue(i);
		}
		return total;
	}

	public int getLowerHalfTotal()
	{
		int scoreOfLowerHalf = 0;
		if (wasFourOfAKindScored())
		{
			scoreOfLowerHalf += fourOfAKindScore;
		}
		if (wasThreeOfAKindScored())
		{
			scoreOfLowerHalf += threeOfAKindScore;
		}
		if (wasFullHouseScored())
		{
			scoreOfLowerHalf += fullHouseScore;
		}
		if (wasSmStraightScored())
		{
			scoreOfLowerHalf += smStraightScore;
		}
		if (wasLrgStraightScored())
		{
			scoreOfLowerHalf += lrgStraightScore;
		}
		if (wasYahtzeeScored())
		{
			scoreOfLowerHalf += yahtzeeScore;
		}
		if (wasChanceScored())
		{
			scoreOfLowerHalf += chanceScore;
		}
		return scoreOfLowerHalf;
	}

	public int getUpperHalfTotal()
	{
		int scoreOfUpperHalf = 0;
		if (wasAcesScored())
		{
			scoreOfUpperHalf += acesScore;
		}
		if (wasTwosScored())
		{
			scoreOfUpperHalf += twosScore;
		}
		if (wasThreesScored())
		{
			scoreOfUpperHalf += threesScore;
		}
		if (wasFoursScored())
		{
			scoreOfUpperHalf += foursScore;
		}
		if (wasFivesScored())
		{
			scoreOfUpperHalf += fivesScore;
		}
		if (wasSixesScored())
		{
			scoreOfUpperHalf += sixesScore;
		}
		if (wasBonusScored())
		{
			scoreOfUpperHalf += bonusScore;
		}
		return scoreOfUpperHalf;
	}

	public int getGrandTotal()
	{
		int lower = getLowerHalfTotal();
		int upper = getUpperHalfTotal();
		int grandTotal = lower + upper;
		return grandTotal;

	}

	public boolean wasScored(YahtzeeRoll roll)
	{
		switch (roll)
		{
		case ACES:
			return wasAcesScored();

		case TWOS:
			return wasTwosScored();

		case THREES:
			return wasThreesScored();

		case FOURS:
			return wasFoursScored();

		case FIVES:
			return wasFivesScored();

		case SIXES:
			return wasSixesScored();

		case FULLHOUSE:
			return wasFullHouseScored();

		case CHANCE:
			return wasChanceScored();

		case FOUROFAKIND:
			return wasFourOfAKindScored();

		case THREEOFAKIND:
			return wasThreeOfAKindScored();

		case LRGSTRAIGHT:
			return wasLrgStraightScored();

		case SMSTRAIGHT:
			return wasSmStraightScored();

		case YAHTZEE:
			return wasYahtzeeScored();

		}
		return false;

	}

	public void score(YahtzeeDice dice, YahtzeeRoll roll)
	{
		switch (roll)
		{
		case ACES:
			scoreAces(dice);
			break;
		case TWOS:
			scoreTwos(dice);
			break;
		case THREES:
			scoreThrees(dice);
			break;
		case FOURS:
			scoreFours(dice);
			break;
		case FIVES:
			scoreFives(dice);
			break;
		case SIXES:
			scoreSixes(dice);
			break;
		case FULLHOUSE:
			scoreFullHouse(dice);
			break;
		case CHANCE:
			scoreChance(dice);
			break;
		case FOUROFAKIND:
			scoreFourOfAKind(dice);
			break;
		case THREEOFAKIND:
			scoreThreeOfAKind(dice);
			break;
		case LRGSTRAIGHT:
			scoreLrgStraight(dice);
			break;
		case SMSTRAIGHT:
			scoreSmStraight(dice);
			break;
		case YAHTZEE:
			scoreYahtzee(dice);
			break;
		default:
			break;
		}
	}

	public ArrayList<YahtzeeRoll> getAllUnscoredRolls()
	{
		ArrayList<YahtzeeRoll> unscoredRolls = new ArrayList<>();
		for (YahtzeeRoll roll : YahtzeeRoll.values())
		{
			if (!wasScored(roll))
			{
				unscoredRolls.add(roll);
			}
		}
		return unscoredRolls;
	}

	public YahtzeeRoll getRandomUnscored(Random random)
	{
		System.out.println("Getting random");
		int num;
		ArrayList<YahtzeeRoll> unscoredRolls = getAllUnscoredRolls();
		num = random.nextInt(unscoredRolls.size());
		return unscoredRolls.get(num);
	}

	public void printScoreSheet()
	{
		ArrayList<YahtzeeRoll> unscoredRolls = getAllUnscoredRolls();
		System.out.print("you can still score: ");
		for (int i = 0; i < unscoredRolls.size(); i++)
		{
			System.out.print(unscoredRolls.get(i) + " ");
		}
		System.out.println();
	}
}

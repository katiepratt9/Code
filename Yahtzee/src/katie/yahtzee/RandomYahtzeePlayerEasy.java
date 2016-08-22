package katie.yahtzee;

import java.util.Random;

public class RandomYahtzeePlayerEasy implements YahtzeePlayer
{
	private Random random;

	public RandomYahtzeePlayerEasy(Random random)
	{
		this.random = random;

	}

	public static void main(String[] args)
	{
		Random random1 = new Random();
		Random random2 = new Random();
		RandomYahtzeePlayerEasy player1 = new RandomYahtzeePlayerEasy(random1);
		RandomYahtzeePlayerEasy player2 = new RandomYahtzeePlayerEasy(random2);

		YahtzeeGame game = new YahtzeeGame();
		game.addPlayer(player1);
		game.addPlayer(player2);
		game.playGame();
	}

	@Override
	public void chooseRoll(ScoreSheet sheet, int rollNumber, int[] diceValues, boolean[] diceToReroll)
	{
		for (int i = 0; i < 5; i++)
		{
			diceToReroll[i] = random.nextBoolean();
		}
	}

	@Override
	public YahtzeeRoll chooseHowToScore(YahtzeeDice dice, ScoreSheet sheet)
	{
		YahtzeeReferee ref = new YahtzeeReferee();
		printCurrentDiceValues(dice);
		sheet.scoreBonus(dice);
		if (ref.isYahtzee(dice) && !sheet.wasYahtzeeScored())
		{
			return YahtzeeRoll.YAHTZEE;
		}
		else if (ref.isFourOfAKind(dice) && !sheet.wasFourOfAKindScored())
		{
			return YahtzeeRoll.FOUROFAKIND;
		}
		else if (ref.isThreeOfAKind(dice) && !sheet.wasThreeOfAKindScored())
		{
			return YahtzeeRoll.THREEOFAKIND;
		}
		else if (ref.isFullHouse(dice) && !sheet.wasFullHouseScored())
		{
			return YahtzeeRoll.FULLHOUSE;
		}
		else if (ref.isLrgStraight(dice) && !sheet.wasLrgStraightScored())
		{
			return YahtzeeRoll.LRGSTRAIGHT;
		}
		else if (ref.isSmStraight(dice) && !sheet.wasSmStraightScored())
		{
			return YahtzeeRoll.SMSTRAIGHT;
		}
		else if (dice.atLeastTwoDieHasValue(1) && !sheet.wasAcesScored())
		{
			return YahtzeeRoll.ACES;
		}
		else if (dice.atLeastTwoDieHasValue(2) && !sheet.wasTwosScored())
		{
			return YahtzeeRoll.TWOS;
		}
		else if (dice.atLeastTwoDieHasValue(3) && !sheet.wasThreesScored())
		{
			return YahtzeeRoll.THREES;
		}
		else if (dice.atLeastTwoDieHasValue(4) && !sheet.wasFoursScored())
		{
			return YahtzeeRoll.FOURS;
		}
		else if (dice.atLeastTwoDieHasValue(5) && !sheet.wasFivesScored())
		{
			return YahtzeeRoll.FIVES;
		}
		else if (dice.atLeastTwoDieHasValue(6) && !sheet.wasSixesScored())
		{
			return YahtzeeRoll.SIXES;
		}
		else if (!sheet.wasChanceScored())
			return YahtzeeRoll.CHANCE;
		else
		{
			return sheet.getRandomUnscored(random);

		}
	}

	private void printCurrentDiceValues(YahtzeeDice dice)
	{
		System.out.print("Random players current dice Values are" + "-");
		for (int i = 0; i < 5; i++)
		{
			int[] diceValues = dice.getValues();
			System.out.print(diceValues[i] + " ");
		}
	}
}

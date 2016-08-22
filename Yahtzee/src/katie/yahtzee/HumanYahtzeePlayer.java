package katie.yahtzee;

import java.util.Random;
import java.util.Scanner;

public class HumanYahtzeePlayer implements YahtzeePlayer
{
	YahtzeeReferee ref = new YahtzeeReferee();
	private Scanner scanner = new Scanner(System.in);

	private YahtzeeRoll chooseHowToScoreInternal(YahtzeeDice dice, ScoreSheet sheet)
	{
		for (int i = 0; i < YahtzeeRoll.values().length; i++)
		{
			System.out.println(i + " " + YahtzeeRoll.values()[i]);
		}
		printCurrentDiceValues(dice);
		sheet.scoreBonus(dice);
		sheet.scoreBonus(dice);
		int choice = scanner.nextInt();
		if (choice >= 0 && choice <= 12)
		{
			if (!sheet.wasScored(YahtzeeRoll.values()[choice]))
			{

				return YahtzeeRoll.values()[choice];
			}
			else
			{
				System.out.println("You already Scored that, try another");
				return null;
			}

		}
		else
		{
			System.out.println("choice needs to be a number from 0-12");
			return null;
		}
	}

	@Override
	public void chooseRoll(ScoreSheet sheet, int rollNumber, int[] diceValues, boolean[] diceToReroll)
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.print(diceValues[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++)
		{
			String reroll = scanner.next();
			diceToReroll[i] = (reroll.contains("y"));
		}
	}


	public void printCurrentDiceValues(YahtzeeDice dice)
	{
		System.out.print("Your current dice Values are" + "-");
		for (int i = 0; i < 5; i++)
		{
			int[] diceValues = dice.getValues();
			System.out.print(diceValues[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		HumanYahtzeePlayer player = new HumanYahtzeePlayer();
		RandomYahtzeePlayerEasy player2 = new RandomYahtzeePlayerEasy(new Random());
		YahtzeeGame game = new YahtzeeGame();
		game.addPlayer(player);
		game.addPlayer(player2);
		game.playGame();
	}

	@Override
	public YahtzeeRoll chooseHowToScore(YahtzeeDice dice, ScoreSheet sheet)
	{
		YahtzeeRoll roll = null;
		while (roll == null)
		{
			roll = chooseHowToScoreInternal(dice, sheet);
		}
		return roll;
	}

}
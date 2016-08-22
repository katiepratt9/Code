package katie.yahtzee;

import java.util.ArrayList;
import java.util.Random;

public class YahtzeeGame
{
	private ArrayList<YahtzeePlayer> players = new ArrayList<>();
	private ArrayList<ScoreSheet> sheets = new ArrayList<>();
	private Random random = new Random();
	private final YahtzeeGUI GUI = new YahtzeeGUI();

	public void addPlayer(YahtzeePlayer player)
	{
		players.add(player);
		sheets.add(new ScoreSheet());
	}

	public void clearPlayers()
	{
		players.clear();
		sheets.clear();
	}

	private void PrintPlayerScore()
	{
		for (int i = 0; i < players.size(); i++)
		{
			System.out
					.println("Player" + " " + (i + 1) + " Your current score is" + " " + sheets.get(i).getGrandTotal());
		}
	}

	public void doOneRoll(YahtzeePlayer player, ScoreSheet sheet)
	{
		boolean[] diceToReroll = new boolean[5];
		YahtzeeDice dice = new YahtzeeDice(random);
		GUI.go();
		for (int i = 0; i < 2; i++)
		{
			int[] diceValues = dice.getValues();
			player.chooseRoll(sheet, i, diceValues, diceToReroll);
			dice.reRoll(diceToReroll);
		}

		YahtzeeRoll chooseHowToScore = player.chooseHowToScore(dice, sheet);

		System.out.println("Choose " + chooseHowToScore);
		System.out.println();
		sheet.score(dice, chooseHowToScore);
		printChoiceScore(chooseHowToScore, sheet);
		PrintPlayerScore();
	}

	private void printChoiceScore(YahtzeeRoll choice, ScoreSheet sheet)
	{
		if (choice == YahtzeeRoll.ACES)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfAces() + " " + "with your Aces");
		}
		else if (choice == YahtzeeRoll.TWOS)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfTwos() + " " + "with your Twos");
		}
		else if (choice == YahtzeeRoll.THREES)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfThrees() + " " + "with your Threes");
		}
		else if (choice == YahtzeeRoll.FOURS)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfFours() + " " + "with your Fours");
		}
		else if (choice == YahtzeeRoll.FIVES)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfFives() + " " + "with your Fives");
		}
		else if (choice == YahtzeeRoll.SIXES)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfSixes() + " " + "with your Sixes");
		}
		else if (choice == YahtzeeRoll.THREEOFAKIND)
		{
			System.out.println(
					"You Scored a" + " " + sheet.currentScoreThreeOfAKind() + " " + "with your Three Of A Kind");
		}
		else if (choice == YahtzeeRoll.FOUROFAKIND)
		{
			System.out.println(
					"You Scored a" + " " + sheet.currentScoreOfFourOfAKind() + " " + "with your Four Of A Kind");
		}
		else if (choice == YahtzeeRoll.YAHTZEE)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfYahtzee() + " " + "with your Yahtzee");
		}
		else if (choice == YahtzeeRoll.FULLHOUSE)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfFullHouse() + " " + "with your Full House");
		}
		else if (choice == YahtzeeRoll.SMSTRAIGHT)
		{
			System.out.println(
					"You Scored a" + " " + sheet.currentScoreOfSmStraight() + " " + "with your Small Straight");
		}
		else if (choice == YahtzeeRoll.LRGSTRAIGHT)
		{
			System.out.println(
					"You Scored a" + " " + sheet.currentScoreOfLrgStraight() + " " + "with your Large Straight");
		}
		else if (choice == YahtzeeRoll.CHANCE)
		{
			System.out.println("You Scored a" + " " + sheet.currentScoreOfChance() + " " + "with your Chance");
		}
	}

	public void playOneRound()
	{
		for (int i = 0; i < players.size(); i++)
		{
			YahtzeePlayer yahtzeePlayer = players.get(i);
			ScoreSheet sheet = sheets.get(i);
			doOneRoll(yahtzeePlayer, sheet);
			sheet.printScoreSheet();
			System.out.println("Next player " + (i + 1) + "s' turn.");
		}
	}

	public void playGame()
	{
		while (!isGameDone())
		{// graphics-random player and human player need to be playing at the
			// same time-music
			playOneRound();
			if (isGameDone())
			{
				PrintWinner(sheets);
			}
		}

	}

	private void PrintWinner(ArrayList<ScoreSheet> sheets)
	{ // doesnt compare totals
		ArrayList<Integer> scores = new ArrayList<>(players.size());
		for (int j = 0; j < players.size(); j++)
		{
			ScoreSheet sheet = sheets.get(j);
			scores.set(j, sheet.getGrandTotal());
		}
		int tempwinner = 0;
		if (scores.get(0) > scores.get(1))
		{
			tempwinner = scores.get(0);
		}
		else
		{
			tempwinner = scores.get(1);
		}
		for (int j = 1; j < players.size(); j++)
		{
			if (scores.get(j) > tempwinner)
			{
				tempwinner = scores.get(j);
			}
		}
		for (int j = 0; j < players.size(); j++)
		{
			ScoreSheet sheet = sheets.get(j);
			if (sheet.getGrandTotal() == tempwinner)
			{
				System.out.println(
						"Player " + j + " is the winner, " + "Player " + j + " had " + tempwinner + " points!");
			}
		}
	}

	public boolean isGameDone()
	{
		for (int i = 0; i < sheets.size(); i++)
		{
			ScoreSheet sheet = sheets.get(i);
			if (!sheet.isSheetFull())
				return false;
		}
		return true;
	}

	public String getPlayerScoreSheet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getPlayerNum()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

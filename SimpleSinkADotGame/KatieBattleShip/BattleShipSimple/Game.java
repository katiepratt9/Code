package BattleShipSimple;

import java.util.ArrayList;

public class Game
{
	public static void main(String[] args)
	{
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		SimpleDotCom theDotCom = new SimpleDotCom();
		ArrayList<String> locations = null;
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		while (isAlive == true)
		{
			String guess = helper.getUserInput("enter  number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill"))
			{
			isAlive = false;
			System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}

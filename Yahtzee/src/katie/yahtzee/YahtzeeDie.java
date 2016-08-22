package katie.yahtzee;

import java.util.Random;

public class YahtzeeDie
{
	private int number;
	private Random random;

	public YahtzeeDie(Random random)
	{
		this.random = random;
		this.rollDice();
	}

	public YahtzeeDie(Random random, int number)
	{
		this.random = random;
		this.number = number;
	}

	public int getNumber()
	{
		return number;
	}

	public void rollDice()
	{
		this.number = random.nextInt(6) + 1;
	}
	public String toString()
	{
		return "" + number;
	}
}
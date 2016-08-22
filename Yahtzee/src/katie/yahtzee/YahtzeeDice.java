package katie.yahtzee;

import java.util.Random;

public class YahtzeeDice
{
	private YahtzeeDie[] yahtzeeDice = new YahtzeeDie[5];
	private final int numberOfDice = 5;

	public YahtzeeDice(Random random)
	{
		for (int i = 0; i < numberOfDice; i++)
		{
			yahtzeeDice[i] = new YahtzeeDie(random);
		}
	}

	public YahtzeeDice(Random random, int die1, int die2, int die3, int die4, int die5)
	{
		yahtzeeDice[0] = new YahtzeeDie(random, die1);
		yahtzeeDice[1] = new YahtzeeDie(random, die2);
		yahtzeeDice[2] = new YahtzeeDie(random, die3);
		yahtzeeDice[3] = new YahtzeeDie(random, die4);
		yahtzeeDice[4] = new YahtzeeDie(random, die5);
	}

	public void rollAll()
	{
		for (int i = 0; i < numberOfDice; i++)
		{
			yahtzeeDice[i].rollDice();
		}
	}

	public void reRoll(boolean[] reroll)
	{
		for (int i = 0; i < numberOfDice; i++)
		{
			if (reroll[i])
				yahtzeeDice[i].rollDice();
		}
	}

	public int[] getValues()
	{
		int[] values = new int[numberOfDice];
		for (int i = 0; i < numberOfDice; i++)
		{
			values[i] = yahtzeeDice[i].getNumber();

		}
		return values;
	}

	public int getValue(int index)
	{
		int value;
		value = yahtzeeDice[index].getNumber();
		return value;
	}

	public int count(int value)
	{
		int count = 0;

		for (int i = 0; i < numberOfDice; i++)
		{
			if (yahtzeeDice[i].getNumber() == value)
			{
				count++;
			}
		}
		return count;
	}

	public boolean atLeastOneDieHasValue(int value)
	{
		return (this.count(value) >= 1);
	}

	public boolean atLeastThreeDieHasValue(int value)
	{
		return (this.count(value) == 3);
	}

	public boolean atLeastFourDieHasValue(int value)
	{
		return (this.count(value) == 4);
	}

	public boolean atLeastTwoDieHasValue(int value)
	{
		return (this.count(value) == 2);
	}

	public String toString()
	{
		String string = "";
		for (int i = 0; i < numberOfDice; i++)
		{
			string = string + yahtzeeDice[i] + " ";
		}
		return string;
	}
}

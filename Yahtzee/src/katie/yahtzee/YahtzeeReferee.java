package katie.yahtzee;

//number of roles left
public class YahtzeeReferee
{
	public boolean isThreeOfAKind(YahtzeeDice dice)
	{
		for (int i = 1; i <= 6; i++)
		{
			if (hasThree(dice, i))
				return true;
		}

		return false;
	}

	public boolean hasThree(YahtzeeDice dice, int value)
	{
		int count = dice.count(value);
		return (count >= 3);
	}

	public boolean isFourOfAKind(YahtzeeDice dice)
	{
		for (int i = 1; i <= 6; i++)
		{
			if (hasFour(dice, i))
				return true;
		}

		return false;
	}

	public boolean hasFour(YahtzeeDice dice, int value)
	{
		int count = dice.count(value);
		return (count >= 4);
	}

	public boolean isYahtzee(YahtzeeDice dice)
	{
		for (int i = 1; i <= 6; i++)
		{
			if (hasFive(dice, i))
				return true;
		}

		return false;
	}

	public boolean hasFive(YahtzeeDice dice, int value)
	{
		int count = dice.count(value);
		return (count >= 5);
	}

	public boolean isSmStraight(YahtzeeDice dice)
	{
		if (hasSequence(dice))
			return true;

		return false;
	}

	private boolean hasSequence(YahtzeeDice dice)
	{
		boolean bool = false;
		int one = dice.count(1);
		int two = dice.count(2);
		int three = dice.count(3);
		int four = dice.count(4);
		int five = dice.count(5);
		int six = dice.count(6);
		if (one >= 1 && two >= 1 && three >= 1 && four >= 1)
		{
			bool = true;
		} else if (two >= 1 && three >= 1 && four >= 1 && five >= 1)
		{
			bool = true;
		} else if (three >= 1 && four >= 1 && five >= 1 && six >= 1)
		{
			bool = true;
		} else
		{
			bool = false;
		}
		return (bool);
	}

	public boolean isLrgStraight(YahtzeeDice dice)
	{
		if (has12345(dice))
			return true;

		return false;
	}

	private boolean has12345(YahtzeeDice dice)
	{
		boolean bool = false;

		if (dice.atLeastOneDieHasValue(1) && dice.atLeastOneDieHasValue(2) && dice.atLeastOneDieHasValue(3)
				&& dice.atLeastOneDieHasValue(4) && dice.atLeastOneDieHasValue(5))
		{
			bool = true;
		} else if (dice.atLeastOneDieHasValue(2) && dice.atLeastOneDieHasValue(3) && dice.atLeastOneDieHasValue(4)
				&& dice.atLeastOneDieHasValue(5) && dice.atLeastOneDieHasValue(6))
		{
			bool = true;
		} else
		{
			bool = false;
		}
		return (bool);
	}

	public boolean isFullHouse(YahtzeeDice dice)
	{
		int threeOfAKind = -1;
		
		for (int i = 1; i <= 6; i++)
		{
			if (hasThree(dice, i)) threeOfAKind = i;
		}
		
		if (threeOfAKind == -1) return false;
		
		for (int i = 1; i <= 6; i++)
		{
			if (hasTwo(dice, i) && (i != threeOfAKind)) return true;
		}

		return false;
	}
	
	public boolean hasTwo(YahtzeeDice dice, int value)
	{
		int count = dice.count(value);
		return (count >= 2);

	}

	public boolean reRollsLeftRandomPlayer1()
	{
		int i = 0;
		i++;
		if (i > 2)
		{
			return true;
		} else
		{
			return false;
		}
	}
	public boolean reRollsLeftHumanPlayer(int value)
	{
		if(value < 2)
		{
			return true;
		}
		return false;
	}
}

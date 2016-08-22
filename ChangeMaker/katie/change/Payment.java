package change;

import java.util.Random;

public class Payment
{

	private int amount;
	private Random random;

	public Payment(Random random)
	{
		this.random = random;
		this.chooseNum();
	}

	public Payment(Random random, int amount)
	{
		this.random = random;
		this.amount = amount;
	}

	public int getNumber2()
	{
		return amount;
	}

	public void chooseNum()
	{
		this.amount = random.nextInt(250) + 1;
	}
}

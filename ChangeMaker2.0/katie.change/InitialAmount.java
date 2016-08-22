import java.util.Random;
public class InitialAmount
{
	private int amount;
	private Random random;
	
	public InitialAmount(Random random)
	{
		this.random = random;
		this.chooseNum();
	}
	public InitialAmount(Random random, int amount)
	{
		this.random = random;
		this.amount = amount;
	}
	public int getNumber()
	{
		return amount;
	}
	public void chooseNum()
	{
		this.amount = random.nextInt(500) + 1;
	}

}

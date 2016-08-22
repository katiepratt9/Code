import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class InitialAmountTest
{

	@Test
	public void testchooseNum()
	{
		Random random = new Random();
		InitialAmount initialAmount = new InitialAmount(random);
		testBounds(initialAmount);
		for (int i = 0; i <1000; i++)
		{
			initialAmount.chooseNum();
			testBounds(initialAmount);
		}
	}
	private void testBounds(InitialAmount initialAmount)
	{
		int number = initialAmount .getNumber();
		assertTrue(number >= 1);
		assertTrue(number <=500);
	}

}

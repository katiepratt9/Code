package change;

import java.util.Random;

public class Calculate
{
	int numOfTwentys;
	int numOfTens;
	int numOfFives;
	int numOfOnes;
	int amount;

	public Integer numCash()
	{
		Random random = new Random();
		InitialAmount initial = new InitialAmount(random);
		Payment payment = new Payment(random);
		int value1 = initial.getNumber();
		int value2 = payment.getNumber2();
		int cashAmount;
		cashAmount = value1 - value2;
		System.out.println(cashAmount + ": ");
		return cashAmount;
		
	}

	public void amountEach()
	{
		amount = numCash();
		numOfTwentys = amount/20;
        amount = amount %20;
        numOfTens = amount/10;
        amount = amount%10;
        numOfFives = amount/5;
        amount = amount%5;
        numOfOnes = amount;
		
		
		System.out.println("You need " + numOfTwentys + " Twentys");
		System.out.println("You need " + numOfTens + " Tens");
		System.out.println("You need " + numOfFives + " Fives");
		System.out.println("You need " + numOfOnes + " Ones");
	}
}
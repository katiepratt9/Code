package HackerrankChallengeNotes;

import java.util.*;

public class BinaryGivenBaseTenFindBaseTwoPrintAmountOfConsecutiveOnes
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b, count = 0, max = 0;
		while (n > 0)
		{
			b = n % 2;
			if (b == 1)
			{
				count++;
				if (count > max)
				{
					max = count;
				}
			}
			else
			{
				count = 0;
			}
			n = n / 2;
		}
		System.out.println(max);
	}
}

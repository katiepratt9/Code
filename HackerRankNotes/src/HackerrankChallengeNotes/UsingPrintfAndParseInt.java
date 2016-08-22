package HackerrankChallengeNotes;

import java.util.Scanner;

public class UsingPrintfAndParseInt
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		// create a new scanner for input
		int numCases = Integer.parseInt(in.nextLine());
		// The parseInt() function parses a string and returns an integer from
		// the nextLine
		double negativeCount = 0.0, positiveCount = 0.0, zeroCount = 0.0;
		// 3 doubles for negitive # positive# and zeroes
		for (int i = 0; i < numCases; i++)
		{
			// for every number case
			int num = in.nextInt();
			// set num = next integer
			if (num < 0)
			{
				// if num is < 0
				negativeCount++;
				// increment - count
			}
			else if (num > 0)
			{
				// if num > 0
				positiveCount++;
				// increment positive count
			}
			else
			{
				// else neither
				zeroCount++;
				// increment zeroes count
			}
		}
		System.out.printf("%.6f\n%.6f\n%.6f", positiveCount / numCases, negativeCount / numCases, zeroCount / numCases);
		// print formatted in a certain way
		// Printf format string refers to a control parameter used by a class of
		// functions in the string-processing libraries of various programming
		// languages.
	}
}

package HackerrankChallengeNotes;

import java.util.Scanner;

public class PermutationReturningLexographicallySmallestAbsolutePermutation
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0)
		{
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			StringBuilder sb = new StringBuilder();
			if (k == 0)
				for (int i = 1; i <= n; i++)
					sb.append(i + " ");
			else if (n % (2 * k) != 0)
				sb.append(-1);
			else
				buildString(sb, n, k, 1);
			System.out.println(sb.toString());
		}
	}

	private static void buildString(StringBuilder sb, int n, int k, int i)
	{
		if (i > n)
			return;
		if (0 < i % (2 * k) && i % (2 * k) <= k)
		{
			sb.append(i + k);
		}
		else
		{
			sb.append(i - k);
		}
		sb.append(" ");
		buildString(sb, n, k, ++i);
	}
}
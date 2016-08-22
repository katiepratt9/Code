package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindingAndCreatingSubArraysToFindNegetiveSums
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
		}
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			int sum = 0;
			for (int j = i; j < n; j++)
			{
				sum += a[j];
				if (sum < 0)
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
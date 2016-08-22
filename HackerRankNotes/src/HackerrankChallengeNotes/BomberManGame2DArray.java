package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BomberManGame2DArray
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		int N = scanner.nextInt();
		char[][] grid = new char[R][C];
		char[][] fullGrid = new char[R][C];
		char[][] thirdGrid = new char[R][C];
		char[][] fifthGrid = new char[R][C];
		for (int i = 0; i < R; i++)
		{
			String line = scanner.next();
			char[] chars = line.toCharArray();
			grid[i] = chars;
			for (int j = 0; j < C; j++)
			{
				fullGrid[i][j] = thirdGrid[i][j] = fifthGrid[i][j] = 'O';
			}
		}
		bombToProduce(R, C, grid, thirdGrid);
		bombToProduce(R, C, thirdGrid, fifthGrid);
		if (N == 1)
			print2D(grid);
		else if (N % 2 == 0)
			print2D(fullGrid);
		else if (N % 4 == 1)
			print2D(fifthGrid);
		else
			print2D(thirdGrid);
	}

	private static void bombToProduce(int r, int c, char[][] before, char[][] after)
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (before[i][j] == 'O')
				{
					after[i][j] = '.';
					if (i >= 1)
						after[i - 1][j] = '.';
					if (i + 1 < r)
						after[i + 1][j] = '.';
					if (j >= 1)
						after[i][j - 1] = '.';
					if (j + 1 < c)
						after[i][j + 1] = '.';
				}
			}
		}
	}
	private static void print2D(char[][] grid)
	{
		for (char[] chars : grid)
		{
			for (char c : chars)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
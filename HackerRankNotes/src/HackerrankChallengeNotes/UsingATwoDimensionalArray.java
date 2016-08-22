package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;

public class UsingATwoDimensionalArray
{

	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		// make a new scanner to read input
		int N = scn.nextInt();
		// int N = next int scanned in
		int diag1 = 0;
		// diagonal 1 = 0
		int diag2 = 0;
		// diagonal 2 = 0
		int[][] matrix = new int[N][N];
		// //2 dimensional arrays as an array of arrays
		// //you must always specify the first dimension
		// nums = new int[][]; // ILLEGAL - NEEDS 1ST DIMENSION
		//
		// you do not need to specify the second dimension
		// nums = new int[5][]; // OK
		// nums = new int[5][4]; // OK
		// Elements of the Array: if nums is a 2D array as shown above,
		//
		// nums[i][j] represents a single integer in that array
		// nums[i] represents a 1D array (a single row in the 2D array)
		for (int i = 0; i < N; i++)
		{// for every N
			for (int j = 0; j < N; j++)
			{// for every N
				matrix[i][j] = scn.nextInt();
				// matrix[array1 index][Array2 index] = next int scanned
			}
		}
		for (int i = 0; i < N; i++)
		{// for every N
			for (int j = 0; j < N; j++)
			{// for every N
				if (i == j)
					// if i = j
					diag1 += matrix[i][j];
				// add matrix[array1 index][Array2 index] to diagonal 1
			}
		}
		int counter1 = 0, counter2 = N - 1;
		// counter1 = 0 and counter2 = N-1
		for (int i = 0; i < N; i++)
		{// for every N
			for (int j = 0; j < N; j++)
			{// for every N
				if (i == counter1 && j == counter2)
				{// if i = counter 1 and j = counter2
					// then add matrix[array1 index][Array2 index] to diagonal 2
					diag2 += matrix[i][j];
					counter1++;
					// increment counter1 by 1
					counter2--;
					// decrement counter2 by 1
				}

			}
		}
		System.out.println(Math.abs(diag1 - diag2));
		// print diagonal 1 - diagonal 2
	}

}

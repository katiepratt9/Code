package HackerrankChallengeNotes;

import java.util.*;

public class FindingTheHourGlassSumOfA2DArray
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				arr[i][j] = in.nextInt();
				// creates a 2darray that is 6X6
			}
		}
		int maxSum = sumBasedOnHourglassesTopLeftCoordinates(arr, 0, 0);
		int currentSum = sumBasedOnHourglassesTopLeftCoordinates(arr, 0, 0);
		// sets initial maxsum and currentsum
		for (int n = 0; n < 4; n++)
		{
			for (int m = 0; m < 4; m++)
			{
				// goes through whole array finding an hourglass and adding up
				// the numbers its made out of to find the highest hourglass sum
				currentSum = sumBasedOnHourglassesTopLeftCoordinates(arr, n, m);
				maxSum = currentSum > maxSum ? currentSum : maxSum;
			}
		}
		System.out.println(maxSum);
	}

     static int sumBasedOnHourglassesTopLeftCoordinates(int[][] arr, int row, int col){
        return arr[row][col] + arr[row][col+1] + arr[row][col+2] + 
                              arr[row+1][col+1] + 
            arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
        //finds sum in 2darray in shape like an hourglass given intital column and row cordinates
    }
}
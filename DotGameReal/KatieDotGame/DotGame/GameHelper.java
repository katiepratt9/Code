package DotGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper
{
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;

	public String getUserInput(String prompt)
	{
		String inputLine = null;
		System.out.println(prompt + " ");
		try
		{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0)
				return null;
		} catch (IOException e)
		{
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}

	public ArrayList<String> placeDotCom(int comSize)
	{
		ArrayList<String> alphaCells = new ArrayList<String>();// holds 'f6'
																// type coords
		String temp = null;// temp string for concat
		int[] coords = new int[comSize];// current candidate cordinates
		int attempts = 0;// current attempts counter
		boolean success = false;// flag found a good location
		int location = 0;// current starting location
		comCount++;// number of the dot com to place
		int increment = 1;// set horizontal increment
		if ((comCount % 2) == 1)// if odd dot com place vertica;
		{
			increment = gridLength; // set vertical increment
		}
		while (!success && attempts++ < 200)// main search loop- loops 32 times
		{
			location = (int) (Math.random() * gridSize);// get random starting
														// point
			int x = 0;// numbered position of the dot com to place
			success = true;// assume success
			while (success && x < comSize)// look for adjacent unused spot
			{
				if (grid[location] == 0)// if not already used
				{
					coords[x++] = location;// save location
					location += increment; // try next adjacent
					if (location >= gridSize)// out of bounds -bottom
					{
						success = false;// failure
					}
					if (x > 0 && (location % gridLength == 0))// out of
																// bounds-right
																// edge
					{
						success = false;// failure
					}
				}
				else
				{
					success = false;// failure
				}
			}
		}
		int x = 0; // turn location into alpha cordinates
		int row = 0;
		int column = 0;
		while (x < comSize)
		{
			grid[coords[x]] = 1;// mark master grid points as used
			row = (int) (coords[x] % gridLength);// get row value
			column = coords[x] % gridLength;// get numeric column value
			temp = String.valueOf(alphabet.charAt(column));// convert to alpa
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		return alphaCells;

	}

}

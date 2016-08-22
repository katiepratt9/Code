package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UsingArrayToGetMilitaryTimeFromNormalTime
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//create new scanner to read input
		String inputTime = input.nextLine();
		//inputTime = the input of the next line
		String[] tempArray = inputTime.split(":");
		//make an array of strings, fill it with inputTime, split up, everytime theres a ':'
		String hours = tempArray[0];
		//hours = tempArray[index 0]
		String minutes = tempArray[1];
		//minutes = tempArray[index 1]
		String seconds = tempArray[2].substring(0, 2);
//seconds = temp array[index 2] 
		//make a substring to hold the charecters at the end of seconds(AM,PM)
		int tempHours;
//creat an integer to hold the temporary hours
		if (tempArray[2].substring(2, 4).equalsIgnoreCase("PM"))
		{
			if (Integer.parseInt(hours) < 12)
			{
				tempHours = Integer.parseInt(hours);
				tempHours += 12;
				hours = Integer.toString(tempHours);
			}
		}
		if (tempArray[2].substring(2, 4).equalsIgnoreCase("AM"))
		{
			if (Integer.parseInt(hours) == 12)
			{
				hours = "00";
			}
		}
		System.out.println(hours + ":" + minutes + ":" + seconds);

	}
}

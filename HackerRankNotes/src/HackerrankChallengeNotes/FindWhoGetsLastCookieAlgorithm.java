package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindWhoGetsLastCookieAlgorithm
{
//	It's to handle the case where m >= n. Note that m is NOT bounded by n. If it was, you wouldn't need the modulus.
//	Simple example:
//	n = 5, m = 7, id = 5.
//	Prisoner circle looks like this: 5 -> 6 -> 7 -> 8 -> 9 -> 10 (back to 5)
//	So we know that warning = id + (m - 1).. then
//	= 5 + (7 - 1)
//	= 11
//	But.. there is no 11..
//	The problem states once we go around once and still have candies remaining, we start referencing prisoners by [1..m]
//	so in this example, the answer is 1.. we currently have 11.
//	How do we get 1? 11 mod 5 = 1.
	public static void main(String[] args) {
		   Scanner sc=new Scanner(System.in);
		    long t=sc.nextLong();
		    for(int i=0;i<t;i++){
		        long noOfprisoner=sc.nextLong();
		        long noOfSweet=sc.nextLong();
		        long startId=sc.nextLong();

		        long result=(startId+noOfSweet-1)% noOfprisoner;    

		            if(result ==0){
		                System.out.println(noOfprisoner);
		            }else{
		                System.out.println(result);
		            }
		        }
		}
		}
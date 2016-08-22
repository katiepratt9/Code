package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class usingMathMethodPow
{

	public static void main(String[] args)
	{
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		int i, n;
		BigInteger a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextBigInteger();
		b = sc.nextBigInteger();
		n = sc.nextInt();
		BigInteger[] val = new BigInteger[n];
		val[0] = a;
		val[1] = b;
		for (i = 2; i < n; i++)
		{
			val[i] = (val[i - 1].pow(2)).add(val[i - 2]);
			// // simple
			// Math.pow(7, 2); // 49
			// Math.pow(7, 3); // 343
			// Math.pow(2, 10); // 1024
			// // fractional exponents
			// Math.pow(4, 0.5); // 2 (square root of 4)
			// Math.pow(8, 1/3); // 2 (cube root of 8)
			// Math.pow(2, 0.5); // 1.4142135623730951 (square root of 2)
			// Math.pow(2, 1/3); // 1.2599210498948732 (cube root of 2)
			// // signed exponents
			// Math.pow(7, -2); // 0.02040816326530612 (1/49)
			// Math.pow(8, -1/3); // 0.5
			// // signed bases
			// Math.pow(-7, 2); // 49 (squares are positive)
			// Math.pow(-7, 3); // -343 (cubes can be negative)
			// Math.pow(-7, 0.5); // NaN (negative numbers don't have a real
			// square root)
			// // due to "even" and "odd" roots laying close to each other,
			// // and limits in the floating number precision,
			// // negative bases with fractional exponents always return NaN
			// Math.pow(-7, 1/3); // NaN
		}
		System.out.println(val[i - 1]);
	}
}
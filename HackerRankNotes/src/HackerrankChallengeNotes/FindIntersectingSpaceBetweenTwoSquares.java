package HackerrankChallengeNotes;
import java.util.*;

public class FindIntersectingSpaceBetweenTwoSquares
{
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int L = in.nextInt();  // length
	        int S1 = in.nextInt(); // velocity of 1st square
	        int S2 = in.nextInt(); // velocity of 2nd square
	        int Q = in.nextInt();  // # of queries
	        for(int a0 = 0; a0 < Q; a0++) {
	            long qi = in.nextLong();
	            double ans = Math.sqrt(2) * (L - Math.sqrt(qi));
	            double diff = Math.abs(S2 - S1);
	            System.out.printf("%.4f\n", ans / diff);
	        }
	    }
	}


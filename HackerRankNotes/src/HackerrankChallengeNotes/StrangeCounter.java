package HackerrankChallengeNotes;

import java.util.Scanner;
//As you may have noticed, brute force algoritm is too slow to pass all tests for this problem. So we need to find a faster way to solve this problem. For these type of questions which has lots of numbers and follows some rule while it's growing, more offen than not, there is a math pattern that will work. Normally, we just have to write down a general enough example somewhere to find out what is the pattern. For example, if you are in an interview you need to think in this way and write your own cycles. Now, since there already are examples of the first three cycles in the description, we'll just use that instead
//If you look carefully, the last 'time' value of cycle 1 is 3 which is 3*1=3*(2^1-1), the last 'time' value of cycle 2 is 9 which is 3*3=3*(2^2-1), the last 'time' value of cycle 3 is 21 which is 3*7=3*(2^3-1).
//So, we should keep doubling n, which represents the 2^1, 2^2, 2^3 part. Hence the while loop. The loop stops when it reaches to a cycle whose max time is bigger than the real time t, then we know that it has reached the last cycle.
//And taking the second cycle as an example, 'time' 7 has 'value' 3, and the max time of the second cycle is 9. We find the relationship between them is 3 = 9 - 7 + 1, which is why we print (3 * (n - 1) - t + 1) to get the output of 3 when t is 7.
public class StrangeCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong(), n = 2;
        while (3 * (n - 1) < t) n = 2 * n;
        System.out.println((3 * (n - 1) - t + 1));
    }
}
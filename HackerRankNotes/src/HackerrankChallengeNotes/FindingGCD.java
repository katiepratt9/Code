package HackerrankChallengeNotes;
import java.io.*;
import java.util.*;

public class FindingGCD {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int test_case = scan.nextInt();
    for(int i=0;i<test_case;i++){
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        if(gcd(x1,y1) == gcd(x2,y2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

static int gcd(int x, int y)
{
    int r=0, a, b;
    a = (x > y) ? x : y; // a is greater number
    b = (x < y) ? x : y; // b is smaller number

    r = b;
    while(a % b != 0)
    {
        r = a % b;
        a = b;
        b = r;
    }
    return r;
}
}
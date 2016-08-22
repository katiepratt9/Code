package HackerrankChallengeNotes;
import java.io.*;
import java.util.*;

public class FindingReflectingPointBetweenEndPointAndMidPoint{
public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int test_case = scan.nextInt();
    for(int i=0;i<test_case;i++){
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        findNextPoint(x1,x2,y1,y2);
    }
}

private static void findNextPoint(int x1, int x2, int y1, int y2) {
    int x, y;

    x= 2*x2 - x1;
    y = 2*y2 - y1;

    System.out.println(x +" "+y);
}
}
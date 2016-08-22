package HackerrankChallengeNotes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CreatingACharArrayAndOrderingLexographically {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            String str = scanner.next();
            char[] arr = str.toCharArray();
            if (!next(arr)) {
                System.out.println("no answer");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }
    
    private static boolean next(char[] array) {
        int last = array.length - 1;
        int i = last;
        while (i>0 && array[i-1]>=array[i]) i--;
        if (i<=0) return false;
        int j = last;
        while (array[j]<=array[i-1]) j--;
        swap(array, i-1, j);
        int k = last;
        while (i < k) {
            swap(array, i, k);
            i++;
            k--;
        }
        return true;
    }
    
    private static void swap (char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
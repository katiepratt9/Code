package HackerrankChallengeNotes;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CheckingAStringForCertainCharecters {
public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str=in.nextLine();
    str=str.toLowerCase();
    boolean isPanagram=true;
    if(str.length()<26){
        isPanagram=false;
    }else {
        boolean[] allLetters = new boolean[26];
        for (int i = 0; i < allLetters.length; i++) {
            allLetters[i] = false;
        }
        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i)!=32) {
                allLetters[(int) str.charAt(i) - 97] = true;
            }
        }
        for (int i = 0; i < allLetters.length; i++) {
            if (!allLetters[i]) {
                isPanagram = false;
            }
        }
    }
    if(isPanagram){
        System.out.println("pangram");
    }else{
        System.out.println("not pangram");
    }
}
}
package HackerrankChallengeNotes;

import java.util.LinkedList;
import java.util.Scanner;

public class UsingLinkedList
{
	//an ordered set of data elements, each containing a link to its successor (and sometimes its predecessor).
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int rot = scan.nextInt();
		int t = scan.nextInt();
		// int[] a = new int[size];
		LinkedList<Integer> a = new LinkedList<Integer>();
		for (int i = 0; i < size; i++)
		{
			int element = scan.nextInt();
			a.add(element);

		}
		for (int i = 0; i < rot; i++)
		{
			a.addFirst(a.getLast());
			//put the element in last index of linked list in the first index of the linked list
			a.removeLast();
			//remove last index of linked list
		}
		// System.out.println(a);
		while (t > 0)
		{
			t--;
			int postion = scan.nextInt();
			System.out.println(a.get(postion));
		}

	}
}

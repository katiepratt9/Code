package chooseOwn;

import java.util.Scanner;

public class HumanPlayer implements EscapeTheRoomPlayer
{
	private Scanner scanner = new Scanner(System.in);

	public ChooseAction chooseAction()
	{
		for (int i = 0; i < ChooseAction.values().length; i++)
		{
			System.out.println(i + " " + ChooseAction.values()[i]);
		}
		System.out.println("What would you like to do?");
		int choice = scanner.nextInt();
		return ChooseAction.values()[choice];
	}

	@Override
	public ChooseAction chooseWhatToDo()
	{
		ChooseAction action = null;
		while (action == null)
		{
			action = chooseAction();
		}
		return action;
	}

	public static void main(String[] args)
	{
		EscapeTheRoom adventure = new EscapeTheRoom();
		StoryBoard story = new StoryBoard(adventure, new HumanPlayer());
		story.storyContinue();
	}
}

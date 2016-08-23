package chooseOwn;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class HumanPlayerUsingGUI implements EscapeTheRoomPlayer, EscapeTheRoomListener
{
	Scanner scanner = new Scanner(System.in);
	private final JFrame frame;
	private final JPanel panel;
	private final JTextField field;
	private ChooseAction lastSelectedChooseAction = null;

	public HumanPlayerUsingGUI()
	{ 
		frame = new JFrame("Escape The Room");
		panel = new JPanel();

		field = new JTextField("You find yourself in a small square room.");
		field.setEditable(false);
		field.addActionListener(new enterChoiceListener());

		JComboBox<ChooseAction> comboBox = new JComboBox<ChooseAction>(ChooseAction.values());
		comboBox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				lastSelectedChooseAction = (ChooseAction) comboBox.getSelectedItem();
			}
		});
		Font comboFont = new Font("Serif", Font.BOLD, 20);
		Font feildFont = new Font("Imprint MT Shadow", Font.BOLD, 20);
		comboBox.setFont(comboFont);
		field.setFont(feildFont);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		panel.add(field);
		panel.add(comboBox);

		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(900, 300);
		frame.setVisible(true);
	}

	public ChooseAction chooseActionUsingScanner()
	{
		for (int i = 0; i < ChooseAction.values().length; i++)
		{
			System.out.println(i + " " + ChooseAction.values()[i]);
		}
		System.out.println("What would you like to do?");
		int choice = scanner.nextInt();
		return ChooseAction.values()[choice];
	}

	public ChooseAction chooseActionUsingComboBox()
	{
		for (int i = 0; i < ChooseAction.values().length; i++)
		{
			System.out.println(i + " " + ChooseAction.values()[i]);
		}
		System.out.println("What would you like to do?");

		while (lastSelectedChooseAction == null)
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
			}
		}
		ChooseAction ret = lastSelectedChooseAction;
		lastSelectedChooseAction = null;
		return ret;
	}

	@Override
	public ChooseAction chooseWhatToDo()
	{
		ChooseAction action = null;
		while (action == null)
		{
			action = chooseActionUsingComboBox();
		}
		return action;
	}

	class enterChoiceListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Action Performed!!");
			ChooseAction action = null;
			while (action == null)
			{
				action = chooseAction();
			}
		}

		public ChooseAction chooseAction()
		{
			for (int i = 0; i < ChooseAction.values().length; i++)
			{
				field.setText((i + " " + ChooseAction.values()[i]));
			}
			int choice = 0; // scanner.nextInt();
			return ChooseAction.values()[choice];
		}
	}

	public static void main(String[] args)
	{
		EscapeTheRoom adventure = new EscapeTheRoom();
		HumanPlayerUsingGUI humanPlayer = new HumanPlayerUsingGUI();
		StoryBoard story = new StoryBoard(adventure, humanPlayer);

		adventure.setListener(humanPlayer);
		story.storyContinue();
	}

	@Override
	public void deliverMessage(String message)
	{
		field.setText(message.replaceAll("(\\? )|(\\! )|(\\. )", "$0\n"));
	}
}

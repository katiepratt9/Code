package chooseOwn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HumanPlayerUsingGUI implements EscapeTheRoomPlayer
{
	private final Scanner scanner = new Scanner(System.in);

	private final JFrame frame;
	private final JButton submitChoice;
	private final JLabel label;
	private final JPanel panel;
	private final JTextField enterChoice;
	
	private ChooseAction lastSelectedChooseAction = null;
	
	public HumanPlayerUsingGUI()
	{
		frame = new JFrame("Escape The Room");

		submitChoice = new JButton("Submit Choice");
		submitChoice.addActionListener(new submitChoiceListener());

		label = new JLabel("I'm a label");
		panel = new JPanel();

		enterChoice = new JTextField("Enter choice here.");
		enterChoice.addActionListener(new enterChoiceListener());
	
		
		JComboBox<ChooseAction> comboBox = new JComboBox<ChooseAction>(ChooseAction.values());
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
//				System.out.println("Selected: " + comboBox.getSelectedItem());
				lastSelectedChooseAction = (ChooseAction) comboBox.getSelectedItem();
			}});
		
		
		panel.add(comboBox);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(enterChoice);
		panel.add(label);
		panel.add(submitChoice);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(500, 100);
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
		
		while(lastSelectedChooseAction == null)
		{
			try
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e)
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
//			action = chooseActionUsingScanner();
			action = chooseActionUsingComboBox();
		}
		return action;
	}
	
	class submitChoiceListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{
			label.setText("public ChooseAction chooseWhatToDo(EscapeTheRoomPlayer player)");
		}
	}

	class enterChoiceListener implements ActionListener
	{

//		public void main(String[] args)
//			{
//				EscapeTheRoom adventure = new EscapeTheRoom();
//				StoryBoard story = new StoryBoard(adventure, );
//				story.storyContinue();
//			}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Action Performed!!");
			ChooseAction action = null;
			while (action == null)
			{
				action = chooseAction();
			}
			// return action;
		}

		public ChooseAction chooseAction()
		{
			for (int i = 0; i < ChooseAction.values().length; i++)
			{
				enterChoice.setText((i + " " + ChooseAction.values()[i]));
			}
			// enterChoice.appendText("What would you like to do?");
			int choice = 0; //scanner.nextInt();
			return ChooseAction.values()[choice];
		}
	}

	public static void main(String[] args)
	{
		EscapeTheRoom adventure = new EscapeTheRoom();
		StoryBoard story = new StoryBoard(adventure, new HumanPlayerUsingGUI());
		story.storyContinue();
	}
}


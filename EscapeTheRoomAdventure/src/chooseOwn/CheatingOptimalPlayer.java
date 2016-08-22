package chooseOwn;

import java.util.ArrayList;

public class CheatingOptimalPlayer implements EscapeTheRoomPlayer
{
	private int nextActionIndex = 0;
	
	private final ArrayList<ChooseAction> optimalActions;
	
	public CheatingOptimalPlayer()
	{
		optimalActions = new ArrayList<>();
		
		optimalActions.add(ChooseAction.MOVETOLEFTSIDE);
		optimalActions.add(ChooseAction.PICKUP);
		optimalActions.add(ChooseAction.MOVETOMIDDLE);
		optimalActions.add(ChooseAction.PLACE);
		
		optimalActions.add(ChooseAction.MOVETOLEFTSIDE);
		optimalActions.add(ChooseAction.EXAMINE);
		optimalActions.add(ChooseAction.PICKUP);
		
		optimalActions.add(ChooseAction.MOVETORIGHTSIDE);
		optimalActions.add(ChooseAction.OPEN);
		optimalActions.add(ChooseAction.PICKUP);
		
		optimalActions.add(ChooseAction.MOVETOBACK);
		optimalActions.add(ChooseAction.PLACE);
		
		optimalActions.add(ChooseAction.PICKUP);
		
		optimalActions.add(ChooseAction.ACTIONDESTROY);
		optimalActions.add(ChooseAction.PLACE);
		optimalActions.add(ChooseAction.PICKUP);
		
		optimalActions.add(ChooseAction.MOVETOFRONT);
		optimalActions.add(ChooseAction.OPEN);
	}
	
	@Override
	public ChooseAction chooseWhatToDo()
	{
		ChooseAction chooseAction = optimalActions.get(nextActionIndex);
		nextActionIndex++;
		return chooseAction;
	}

}

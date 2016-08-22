package katie.yahtzee;
public interface YahtzeePlayer
{
public void chooseRoll(ScoreSheet sheet,int rollNumber, int[] diceValues, boolean[] diceToReroll); 
public YahtzeeRoll chooseHowToScore(YahtzeeDice dice, ScoreSheet sheet);
}


import java.util.Random;
import katie.change.InitialAmount;
public class Twentys
{
	public InitialAmount amount = new InitialAmount(null);
		int twentys = 0;
		int value = amount.getNumber();
		public Integer numOfTwentys()
		{
			twentys = value % 20;
			return twentys;
		}
}

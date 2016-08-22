package BattleShipSimple;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SinkADotGameTest
{

	@Test
	public void test()
	{
		SimpleDotCom dot = new SimpleDotCom();
		ArrayList<String> locations =
		null;
		dot.setLocationCells(locations);
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		assertTrue(result.equals("hit"));
	}

}

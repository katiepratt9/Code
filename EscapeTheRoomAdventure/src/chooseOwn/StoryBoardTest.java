package chooseOwn;

import static org.junit.Assert.*;

import org.junit.Test;

public class StoryBoardTest
{

	@Test
	public void test()
	{
		EscapeTheRoom adventure = new EscapeTheRoom();
		StoryBoard story = new StoryBoard(adventure, new CheatingOptimalPlayer());
		assertTrue(story.storyContinue());
	}

}

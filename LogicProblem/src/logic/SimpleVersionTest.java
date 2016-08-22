package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SimpleVersionTest
{

	@Test
	public void testInitialization()
	{
		SimpleVersion simpleVersion = new SimpleVersion();
		ArrayList<String> unused = simpleVersion.findUnused();
		assertEquals(4, unused.size());
		assertEquals("First", unused.get(0));
		
		String randomUnassigned = simpleVersion.findRandomUnassigned();
		assertNotNull(randomUnassigned);
		
		boolean allAssigned = simpleVersion.allAssigned();
		assertFalse(allAssigned);
		
		

	}

}

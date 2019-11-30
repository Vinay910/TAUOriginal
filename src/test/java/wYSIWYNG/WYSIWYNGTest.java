package wYSIWYNG;

import org.testng.annotations.Test;

import tests.TestBase;

public class WYSIWYNGTest extends TestBase{
	
	@Test
	public void EnterDataInFrameVerification()
	{
		wysiwyngPage=homepage.clickWYSIWYNGLink();
		wysiwyngPage.clearFrame();
		wysiwyngPage.clickIndenting();
		wysiwyngPage.EnterData("My name is Vinayak");
	}

}

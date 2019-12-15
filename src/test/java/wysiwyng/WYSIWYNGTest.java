package wysiwyng;

import org.testng.annotations.Test;

import tests.TestBase;

public class WYSIWYNGTest extends TestBase{
	
	@Test
	public void enterDataInFrameVerification()
	{
		wysiwyngPage=homepage.clickWYSIWYNGLink();
		wysiwyngPage.clearFrame();
		wysiwyngPage.clickIndenting();
		wysiwyngPage.enterData("My name is Vinayak");
	}

}

package frames;

import org.testng.annotations.Test;

import tests.TestBase;

public class NestedFrameTest extends TestBase{
	
	@Test
	public void frameTextVerification()
	{
		framesPage=homepage.clickFrameLink();
		nestedFramePage=framesPage.nestedLinkClick();
		sf.assertTrue(nestedFramePage.verifyLeftFrame().contains("LEFT"),"Invalid Text returned");
		sf.assertTrue(nestedFramePage.verifyBottomFrame().contains("BOTTOM"),"Invalid Text returned");
		sf.assertAll();
	}

}

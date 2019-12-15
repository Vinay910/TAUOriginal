package hoverover;

import org.testng.annotations.Test;

import tests.TestBase;

public class HoverOverTest extends TestBase{
	
	@Test
	public void hoverSuccessfulTest()
	{
		int i=2;
		hoverOverPage=homepage.clickHoverOver();
		figureInner=hoverOverPage.hoverOver(i);
		sf.assertTrue(figureInner.validateLinkDisplayed(), "No link is present");
		sf.assertTrue(figureInner.validateHeading().contains("name: user"+i), "Invalid user is present");
		sf.assertTrue(figureInner.validateLinkText().endsWith("/users/"+i), "Invalid Link");
	    sf.assertAll();
	}

}

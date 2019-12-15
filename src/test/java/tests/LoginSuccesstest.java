package tests;


import org.testng.annotations.Test;


public class LoginSuccesstest extends TestBase {

	@Test
	public void loginSucessTest1()
	{
		loginPage=homepage.clickingAuthenticationLink();
		loginPage.enterCred("tomsmith", "SuperSecretPassword!");
		successLoginPage=loginPage.clickLogin();
		sf.assertTrue(successLoginPage.validateSuccess().contains("You logged into a secure area!"), "Message doesnot matched");
	    sf.assertAll();
	}
}

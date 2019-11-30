package retrieveEmail;

import org.testng.annotations.Test;

import tests.TestBase;

public class RetrieveEmailTest extends TestBase{
	@Test
	public void verifyRetrieveEmail()
	{
		forgotPasswordPage=homepage.clickingForgotPassword();
		forgotPasswordPage.enterEmail("v@v.com");
		emailSentPage=forgotPasswordPage.clickRetrieve();
		sf.assertTrue(emailSentPage.validateMsg().contains("Your e-mail's been sent!"),"Invalid message");
		sf.assertAll();
	}

}

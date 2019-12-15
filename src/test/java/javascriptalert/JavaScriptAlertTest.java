package javascriptalert;

import org.testng.annotations.Test;

import tests.TestBase;

public class JavaScriptAlertTest extends TestBase {
	
	@Test
	public void alertClickingAcceptvalidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alertClickAccept().contains("You successfuly clicked an alert"),"Accept "
				+ "Alert doesnot worked as accepted");
		sf.assertAll();
	}
	@Test
	public void alertClickDismissValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alertClickCancel().contains("You clicked: Cancel"),"Dismiss "
				+ "Alert doesnot worked as accepted");
		sf.assertAll();
	}
	@Test
	public void alertDismissPopupTextValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alertClickCancelTextVerification().contains("I am a JS Confirm"),"Dismiss "
				+ "Alert Text is not correct");
		sf.assertAll();
	}
	@Test
	public void alertSubmissionValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alertInputData("My name is ").contains("My name is"),"Submit "
				+ "Alert Text is not correct");
		sf.assertAll();
	}
	

}

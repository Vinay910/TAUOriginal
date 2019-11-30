package javaScriptAlert;

import org.testng.annotations.Test;

import tests.TestBase;

public class JavaScriptAlertTest extends TestBase {
	
	@Test
	public void alert_clickingAcceptvalidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alert_clickAccept().contains("You successfuly clicked an alert"),"Accept "
				+ "Alert doesnot worked as accepted");
		sf.assertAll();
	}
	@Test
	public void alert_clickDismissValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alert_clickCancel().contains("You clicked: Cancel"),"Dismiss "
				+ "Alert doesnot worked as accepted");
		sf.assertAll();
	}
	@Test
	public void alert_DismissPopupTextValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alert_clickCancelTextVerification().contains("I am a JS Confirm"),"Dismiss "
				+ "Alert Text is not correct");
		sf.assertAll();
	}
	@Test
	public void alert_SubmissionValidation()
	{
		javaScriptAlertPage=homepage.clickJavaScriptAlert();
		sf.assertTrue(javaScriptAlertPage.alert_InputData("My name is ").contains("My name is"),"Submit "
				+ "Alert Text is not correct");
		sf.assertAll();
	}
	

}

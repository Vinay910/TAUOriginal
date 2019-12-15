package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventReporter implements WebDriverEventListener {
	
	static Logger infoLog=LogManager.getLogger(EventReporter.class.getName());
	private String elementName;
	private String pageName;

	public void beforeAlertAccept(WebDriver driver) {
		//Not implemented
	}

	public void afterAlertAccept(WebDriver driver) {
		//Not implemented
	}

	public void afterAlertDismiss(WebDriver driver) {
		//Not implemented	
	}

	public void beforeAlertDismiss(WebDriver driver) {
		//Not implemented
	}

	public void beforeNavigateTo(String url, WebDriver driver) {

		//Not implemented
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		//Not implemented
	}

	public void beforeNavigateBack(WebDriver driver) {

		//Not implemented
	}

	public void afterNavigateBack(WebDriver driver) {

		//Not implemented
	}

	public void beforeNavigateForward(WebDriver driver) {

		//Not implemented
	}

	public void afterNavigateForward(WebDriver driver) {

		//Not implemented
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		//Not implemented
	}

	public void afterNavigateRefresh(WebDriver driver) {

		//Not implemented
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		//Not implemented
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		//Not implemented
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		elementName=element.getText();
		pageName=driver.getCurrentUrl();
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		infoLog.info(elementName + " is clicked successfully on "+pageName);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//Not implemented
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		//Not implemented
	}

	public void beforeScript(String script, WebDriver driver) {
		//Not implemented
		
	}

	public void afterScript(String script, WebDriver driver) {

		//Not implemented
	}

	public void onException(Throwable throwable, WebDriver driver) {
		//Not implemented
	}

	

}

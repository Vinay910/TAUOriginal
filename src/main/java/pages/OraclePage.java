package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OraclePage {
	WebDriver driver;
	private WebDriverWait wait;
	Actions act;
	String longmessage = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaqqq";
	private By username = By.xpath("//input[@id='dialogTemplate-dialogForm-content-login-name1']");
	private By password = By.xpath("//input[@id='dialogTemplate-dialogForm-content-login-password']");
	private By loginButton = By.xpath("//span[@class='nav-btn5']");
	private By fluidLink = By.xpath("//a[contains(text(),'Fluid Recruiting')]");
	private By findCandidateButton = By.xpath("//span[contains(text(),'Find Candidates')]");
	private By savedSearchesTab = By.xpath("//span[contains(text(),'Saved Searches')]");
	private By queryName = By.xpath("//a[text()='fasAdvancedQuery']");
	private By propIcon = By.xpath(
			"//div[@class='search-criteria-tab__actions-item-group search-criteria-tab__actions-item-group--left']/div[2]//span[@class='oj-button-text']");
	private By comment = By.xpath("//textarea[@id='comments-value|input']");
	private By spinner = By.xpath(".//div[@id=\"spinner\"]");
	private By TextBox = By.xpath("//textarea[@id='searchTermCheckBoxValue|input']");
	private By threeDot=By.xpath("//div[@class='oj-button-label'][1]//span[@slot='startIcon']");
	private By createFolder=By.xpath("//span[contains(text(),'Create Folder')]");
	public OraclePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		act = new Actions(driver);
	}

	public void loginToTaleo() {
		driver.findElement(username).sendKeys("fasAccess");
		driver.findElement(password).sendKeys("rsft789p");
		driver.findElement(loginButton).click();
	}

	public void redirectingToSavedSearchesTab() {
		driver.findElement(fluidLink).click();
		driver.findElement(findCandidateButton).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(spinner)));
		driver.findElement(savedSearchesTab).click();
	}

	public void errorchecking() {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(spinner)));
		driver.findElement(queryName).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(spinner)));
		WebElement textBox1 = driver.findElement(TextBox);
		textBox1.sendKeys(longmessage);
		act.moveToElement(textBox1).doubleClick().build().perform();
		textBox1.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		WebElement propetyIcon = driver.findElement(propIcon);
		propetyIcon.click();
		WebElement commentSection = driver.findElement(comment);
		wait.until(ExpectedConditions.visibilityOf(commentSection));
		commentSection.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}
	public void createFolder()
	{
		driver.findElement(threeDot).click();
		driver.findElement(createFolder).click();
		WebElement eq=driver.switchTo().activeElement();
		try{Thread.sleep(3000);}catch(Exception e){e.getMessage();}
		eq.sendKeys("Yesy");
		try{Thread.sleep(3000);}catch(Exception e){e.getMessage();}
		act.sendKeys(Keys.TAB);
	}

}

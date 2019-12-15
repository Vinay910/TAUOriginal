package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
	
	private WebDriver driver;
	private By fileUploadButton=By.xpath("//input[@id='file-upload']");
	private By fileUploadButtonClick=By.xpath("//input[@id='file-submit']");
	private By result=By.xpath("//div[@id='uploaded-files']");
	public FileUploadPage(WebDriver driver) {
		this.driver=driver;
	}
	public String verifyFileUpload(String value)
	{
		driver.findElement(fileUploadButton).sendKeys(value);
		driver.findElement(fileUploadButtonClick).click();
		return driver.findElement(result).getText();
	}
	

}

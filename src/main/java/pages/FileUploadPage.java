package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
	
	private WebDriver driver;
	private By FileUploadButton=By.xpath("//input[@id='file-upload']");
	private By FileUploadButtonClick=By.xpath("//input[@id='file-submit']");
	private By result=By.xpath("//div[@id='uploaded-files']");
	public FileUploadPage(WebDriver driver) {
		this.driver=driver;
	}
	public String verifyFileUpload(String value)
	{
		driver.findElement(FileUploadButton).sendKeys(value);
		driver.findElement(FileUploadButtonClick).click();
		return driver.findElement(result).getText();
	}
	

}

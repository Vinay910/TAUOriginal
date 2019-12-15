package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
    private void authclick(String link)
    {
    	driver.findElement(By.xpath(link)).click();
    }
    public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage clickingAuthenticationLink()
	{
	    authclick("//a[contains(text(),'Form Authentication')]");
		return new LoginPage(driver);
	}
    public DropDownPage clickingDropDownLink()
    {
    	authclick("//a[contains(text(),'Dropdown')]");
    	return new DropDownPage(driver);
    }
    public ForgotPasswordPage clickingForgotPassword()
    {
    	authclick("//a[contains(text(),'Forgot Password')]");
    	return new ForgotPasswordPage(driver);
    }
    public HoverOverPage clickHoverOver()
    {
    	authclick("//a[contains(text(),'Hovers')]");
    	return new HoverOverPage(driver);
    }
    public KeysPressesPage clickKeyPress()
    {
    	authclick("//a[contains(text(),'Key Presses')]");
    	return new KeysPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSliderLink()
    {
    	authclick("//a[contains(text(),'Horizontal Slider')]");
    	return new  HorizontalSliderPage(driver);
    }
    public JavaScriptAlertPage clickJavaScriptAlert()
    {
    	authclick("//a[contains(text(),'JavaScript Alerts')]");
    	return new JavaScriptAlertPage(driver);
    }
    public FileUploadPage clickFileUpload()
    {
    	authclick("//a[contains(text(),'File Upload')]");
    	return new FileUploadPage(driver);
    }
    public WYSIWYNGPage clickWYSIWYNGLink()
    {
    	authclick("//a[contains(text(),'WYSIWYG Editor')]");
    	return new WYSIWYNGPage(driver);
    }
    public FramesPage clickFrameLink()
    {
    	authclick("//li[22]//a[1]");
    	return new FramesPage(driver);
    }
    public DynamicLoadingPage dynamicLoadingLink()
    {
    	authclick("//a[contains(text(),'Dynamic Loading')]");
    	return new DynamicLoadingPage(driver);
    }
    public InfiniteScrollPage clickingInfiniteScrollLink()
    {
    	authclick("//a[contains(text(),'Infinite Scroll')]");
    	return new InfiniteScrollPage(driver);
    }
    public MultiplePage clickMultiplePage()
    {
    	authclick("//a[contains(text(),'Multiple Windows')]");
    	return new MultiplePage(driver);
    }
}

package tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import pages.DropDownPage;
import pages.DynamicHiddenPage;
import pages.DynamicLoadingPage;
import pages.DynamicRenderingPage;
import pages.EmailSentPage;
import pages.FileUploadPage;
import pages.ForgotPasswordPage;
import pages.FramesPage;
import pages.HomePage;
import pages.HorizontalSliderPage;
import pages.HoverOverPage;
import pages.HoverOverPage.FigureInner;
import pages.InfiniteScrollPage;
import pages.JavaScriptAlertPage;
import pages.KeysPressesPage;
import pages.LoginPage;
import pages.MultiplePage;
import pages.NestedFramePage;
import pages.SuccessLoginPage;
import pages.WYSIWYNGPage;
import utils.EventReporter;
import utils.WindowNavigator;

public class TestBase {

	protected HomePage homepage;
	protected LoginPage loginPage;
	protected SuccessLoginPage successLoginPage;
	protected DropDownPage dropDownPage;
	protected ForgotPasswordPage forgotPasswordPage;
	protected EmailSentPage emailSentPage;
	protected HoverOverPage hoverOverPage;
	protected FigureInner figureInner;
	protected KeysPressesPage keysPressesPage;
	protected HorizontalSliderPage horizontalSliderPage;
	protected JavaScriptAlertPage javaScriptAlertPage;
	protected FileUploadPage fileUploadPage;
	protected WYSIWYNGPage wysiwyngPage;
	protected FramesPage framesPage;
	protected NestedFramePage nestedFramePage;
	protected DynamicLoadingPage dynamicLoadingPage;
	protected DynamicHiddenPage dynamicHiddenPage;
	protected DynamicRenderingPage dynamicRenderingPage;
	protected InfiniteScrollPage infiniteScrollPage;
	protected MultiplePage multiplePage;
	protected WindowNavigator windowNavigator;
	protected SoftAssert sf;
	private EventFiringWebDriver driver;
	protected Properties prop;
	protected DesiredCapabilities caps;
	

	@BeforeClass
	public void SetUp() {
		caps=new DesiredCapabilities();
		prop = System.getProperties();
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/Prop.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			driver = new EventFiringWebDriver(new ChromeDriver());
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
			driver = new EventFiringWebDriver(new FirefoxDriver());
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/main/resources/IEDriverServer.exe");
			caps.setCapability("requireWindowFocus", true);  
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
			driver = new EventFiringWebDriver(new InternetExplorerDriver(caps));
		}
		driver.register(new EventReporter());
		sf = new SoftAssert();
		goToHome();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
	}
	private void goToHome() {
		driver.get(prop.getProperty("URL"));
	}

	@AfterClass
	public void TearDown() {
		Object[] win=driver.getWindowHandles().toArray();
		for(int i=0;i<win.length;i++)
		{
		driver.switchTo().window(win[i].toString());
		driver.close();
		}
	}

	@AfterMethod
	public void captureFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		
			TakesScreenshot camera = (TakesScreenshot) driver;
			File file = camera.getScreenshotAs(OutputType.FILE);
			try {
				long time=System.currentTimeMillis();
				new File(System.getProperty("user.dir")+"/src/main/java/screenshot/"+time).mkdir();
				Files.move(file, new File(
						System.getProperty("user.dir")+"/src/main/java/screenshot/"+time+"/" + result.getName()+".jpg"));
			} catch (Exception e) {
				System.out.println("Screenshot is not working");
			}
		}
	}
}

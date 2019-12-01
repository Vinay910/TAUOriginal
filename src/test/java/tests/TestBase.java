package tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	

	@BeforeClass
	public void SetUp() {
		prop = System.getProperties();
		try {
			prop.load(new FileInputStream(new File("../TAU/src/main/resources/Prop.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", "../TAU/src/main/resources/chromedriver.exe");
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new EventFiringWebDriver(new ChromeDriver());
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new EventFiringWebDriver(new FirefoxDriver());
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
		driver.close();
	}

	@AfterMethod
	public void captureFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		
			TakesScreenshot camera = (TakesScreenshot) driver;
			File file = camera.getScreenshotAs(OutputType.FILE);
			try {
				long time=System.currentTimeMillis();
				new File("../TAU/src/main/java/screenshot/"+time).mkdir();
				Files.move(file, new File(
						"../TAU/src/main/java/screenshot/"+time+"/" + result.getName()+".jpg"));
			} catch (Exception e) {
				System.out.println("Screenshot is not working");
			}
		}
	}
}

package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHome;



public class BaseTest {
	private WebDriver driver;
    protected GoogleHome OpenP;
    String URL ="https://www.google.com/";

    @BeforeClass
    public void setUp(){ 
    	 WebDriverManager.chromedriver().setup();
        driver =(new ChromeDriver(getChromeOptions()));
        driver.manage().window().maximize();
    
    }

    @BeforeMethod
    public void goHome(){
        driver.get(URL);
        OpenP = new GoogleHome(driver);
    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }


    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--lang=en-GB");
        return options;
    }

   
}


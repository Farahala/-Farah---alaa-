package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class GoogleHome  {
	  private static WebDriver driver;
	    public GoogleHome (WebDriver driver){
	        GoogleHome.driver = driver;
	    }
	    public static GoogleSearchResults searchForQuery(String searchQuery ,By element) {
	    	driver.findElement(element).sendKeys(searchQuery,(Keys.ENTER));
	    	return new GoogleSearchResults(driver);
		}
		public static GoogleSearchResults searchForQuery(Keys space) {
			return new GoogleSearchResults(driver);
		}
		public static GoogleSearchResults searchClickableElemnts() {
			return new GoogleSearchResults(driver);
		}

		public static void assertLogoExists(By logoElement) {
			Assert.assertTrue(driver.findElement(logoElement).isDisplayed());
		}
		
	   

}

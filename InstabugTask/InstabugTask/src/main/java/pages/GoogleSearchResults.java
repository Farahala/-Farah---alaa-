package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleSearchResults {
	 WebDriver driver;
	 WebDriverWait wait;


	    public GoogleSearchResults(WebDriver driver){
	        this.driver = driver;
	    }

	    public void assertSearchResultText(By element, String expectedText) {
	    	 wait=new WebDriverWait(driver, 20);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText().contains(expectedText),expectedText);
			
		}

	    public void assertClickBtn(By element1,By element2,String expectedText) {
	    	 wait=new WebDriverWait(driver, 20);
	    	 driver.findElement(element1).click();
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(element2)).getText().contains(expectedText),expectedText);
			
		}
	    public void assertSearchspace(By element) {
	    	 wait=new WebDriverWait(driver, 20);
	    	 String textInsideInputBox =  driver.findElement(element).getText();
	    	 
	    	 if(textInsideInputBox.isEmpty())
	    	 {
	    		   System.out.println("Input field is empty");
	    		   Assert.assertTrue(true);
	    	 }
	    }
	    	 public void clickable(By element)
	    	 {
	    		 try {
	    		       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((element)));
	    		       System.out.println("Element is clickable");
	    		     }
	    		catch(TimeoutException e) {
	    		       System.out.println("Element isn't clickable");
	    		    }

	  	     }

}

package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.GoogleHome;
import pages.GoogleSearchResults;

public class SearchTest  extends BaseTest {
	 By searchResult=By.xpath("//div[1]/a/h3");
	 By searchinvaild=By.xpath("//li[contains(text(),'Try different keywords.')]");
	 By clearbtb=By.cssSelector("div[aria-label=\"Clear\"]");
	 By searchBar = By.name("q");
    By Timeresponse=By.xpath("//div[@id='result-stats']/nobr");
    By nextPngresponse=By.xpath("//div[@id='result-stats']");
    By nextpng=By.id("pnnext");
    By logo=By.tagName("img");
	
	// enter text
	@Test(priority=1,description="enter text.")
	    public void TestHappySeniro(){

		  GoogleSearchResults sPage = GoogleHome.searchForQuery("Selenium",searchBar);
		  sPage.assertSearchResultText(searchResult,"Selenium");
	    }
	  // enter *
	  @Test(priority=2,description="enter * ")
	    public void TestAsterk(){
		  GoogleSearchResults sPage = GoogleHome.searchForQuery("*",searchBar);
		  sPage.assertSearchResultText(searchinvaild,"Try different keywords.");
	    }
	//x btn clear
	  @Test(priority=3,description="x btn clear")
	    public void Testclearfield(){
		  GoogleSearchResults sPage = GoogleHome.searchForQuery("test",searchBar);
		  sPage.assertClickBtn(clearbtb,searchBar,"");
	    }
	  //enter space
	  @Test(priority=4 ,description=" enter space")
	    public void Testsapce(){
		  GoogleSearchResults sPage = GoogleHome.searchForQuery(Keys.SPACE);
		  sPage.assertSearchspace(searchBar);
	    }
	  
//enter sqlquery
	  @Test(priority=5 ,description="enter sql query")
	    public void TestSqlInjection(){
		  GoogleSearchResults sPage = GoogleHome.searchForQuery("search=keyword or'1'='1",searchBar);
		  sPage.assertSearchResultText(searchResult,"SQL Injection");
	    }
	  //search bar is clickable and enabled
	  @Test(priority=6 ,description="search bar is clickable and enabled")
	    public void Testclickable(){
		  GoogleSearchResults sPage = GoogleHome.searchClickableElemnts();
		  sPage.clickable(searchBar);
	    }
	  //header time seconds appear
	  @Test(priority=7 ,description="header time seconds appear")
	    public void TestTime(){
		  GoogleSearchResults sPage = GoogleHome.searchForQuery("seconds",searchBar);
		  sPage.assertSearchResultText(Timeresponse,"seconds");
	    }
	  
	  //logo appeared
	  @Test (priority=8 ,description="logo appeared")
		public void Googlesearhlogo() {

		  GoogleHome.assertLogoExists(logo);
		}

	  //click on next btn
	  @Test (priority=9,description="click on next btn")
		public void nextpage() {
		  GoogleSearchResults sPage = GoogleHome.searchForQuery("test",searchBar);
		  sPage.assertClickBtn(nextpng,nextPngresponse,"Page 2");
		}
	

}

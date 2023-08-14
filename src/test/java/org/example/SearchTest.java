package org.example;

import io.qameta.allure.*;
import org.example.drivers.DriverCreator;
import org.example.models.Item;
import org.example.pages.HomePage;
import org.example.pages.LauncherPage;
import org.example.pages.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Search")
@Feature("Relevant Search")
public class SearchTest {

    //public void TestWithChromeDriver(){
//        public void testWithChromeDriver() {
//            WebDriverContext context = new WebDriverContext();
//            context.setStrategy(new ChromeWebDriverCreator());
//            WebDriver webDriver = context.createWebDriver();
//            // Use the WebDriver for testing with Chrome.
//        }
    //}
    @Test(description = "when the user searches for item the relevant results should be displayed")
    @Story("verifyIfSearchItemShowsRelevantResults")
    @Severity(SeverityLevel.MINOR)
    public void verifyIfSearchItemShowsRelevantResults(){
        //Arrange
        String SearchItem="jeans";
        String SearchKey="jeans";
        String browser="firefox";
        WebDriver webDriver=new DriverCreator().create(browser);
        //LauncherPage launcherPage=new LauncherPage(webDriver);
        PageActions pageActions=new PageActions(webDriver);
        pageActions.navigateTo("https://web-playground.ultralesson.com/");
        //Act
        HomePage homePage=new HomePage(webDriver);
        homePage.search(SearchItem);
        List<Item> searchItems=homePage.getSearchItems();
        //webDriver.quit();
        //Assert
        Assert.assertEquals(searchItems.size(),5);
        //Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(SearchKey)));
    }
    @Test
    public void verifyUnavailableProducts(){
        //Arrange
        String searchItem="unavailable";
        WebDriver webDriver=new ChromeDriver();     //webdriver declaration
        //LauncherPage launcherPage=new LauncherPage(webDriver);
        PageActions pageActions=new PageActions(webDriver);

        pageActions.navigateTo("https://web-playground.ultralesson.com/");
        //Act
        HomePage homePage=new HomePage(webDriver);
        homePage.search(searchItem);
        List<Item> searchItems=homePage.getSearchItems();
        //Assert
        Assert.assertTrue(searchItems.isEmpty());

    }
    @Test
    public void verifyItemsBasedOnDifferentBrands(){
        //Arrange
        String SearchBrand="allen solly";
        //String SearchKey="allen solly";
        WebDriver webDriver=new ChromeDriver();
        //LauncherPage launcherPage=new LauncherPage(webDriver);
        PageActions pageActions=new PageActions(webDriver);

        pageActions.navigateTo("https://web-playground.ultralesson.com/");
        //Act
        HomePage homePage=new HomePage(webDriver);
        homePage.search(SearchBrand);
        List<Item> searchBrand=homePage.getSearchItems();
        //Assert
        Assert.assertTrue(searchBrand.stream().allMatch(item -> item.getName().contains(SearchBrand)));
    }

    @Test
    public void verifySearchResultCountMatchesDisplayedItems(){
        //DriverCreator dc = new DriverCreator();
        //Arrange
        String itemName="shoes";
        WebDriver webDriver=new ChromeDriver();
        //LauncherPage launcherPage=new LauncherPage(webDriver);
        PageActions pageActions=new PageActions(webDriver);
        pageActions.navigateTo("https://web-playground.ultralesson.com/");
        //Act
        HomePage homePage=new HomePage(webDriver);
        homePage.search(itemName);
        List<Item> searchItems=homePage.getSearchItems();
        int itemCount=homePage.getItemCount();
        //Assert
        Assert.assertEquals(searchItems.size(),itemCount);
        System.out.println(itemCount);
        //dc.getweb();
    }
    @Test
    public void should(){
        //Arrange

        //Act

        //Assert
    }

}

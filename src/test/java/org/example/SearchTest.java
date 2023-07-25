package org.example;

import org.example.models.Item;
import org.example.pages.HomePage;
import org.example.pages.LauncherPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTest {
    @Test
    public void verifyIfSearchItemShowsRelevantResults(){
        //Arrange
        String SearchItem="jeans";
        String SearchKey="jeans";
        WebDriver webDriver=null;     //dummy webdriver declaration
        LauncherPage launcherPage=new LauncherPage(webDriver);
        launcherPage.navigateTO("https://web-playground.ultralesson.com/");
        //Act
        HomePage homePage=new HomePage(webDriver);
        homePage.search(SearchItem);
        List<Item> searchItems=homePage.getSearchItems();
        //Assert
        Assert.assertEquals(searchItems.size(),4);
        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(SearchKey)));
    }
}

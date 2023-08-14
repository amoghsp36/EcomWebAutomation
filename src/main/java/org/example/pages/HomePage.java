package org.example.pages;

import org.example.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    List<Item> items;

    By searchIcon=By.cssSelector("summary[aria-label='Search']");
    By searchBar=By.id("Search-In-Modal");
    //By searchResults=By.id("predictive-search-results");
    By productName=By.cssSelector("ul#predictive-search-results-list > li.predictive-search__list-item");
    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }
    public HomePage search(String searchItem){
        actions.safeClick(searchIcon);
        //webDriver.findElement(searchBar).sendKeys(searchItem);
        actions.type(searchBar,searchItem);
        return this;
    }

    public List getSearchItems(){
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> elements=waits.waitUntilAllElementsAreVisible(productName);
        items = new ArrayList<>();
        for(WebElement element:elements){
            String name=webDriver.findElement(productName).getText();
            if (!name.contains("Search for")) {
                Item it = new Item();
                it.setName(name);
                items.add(it);
            }
        }
//        return new ArrayList<>();        //returns empty list
        return items;
    }

    public int getItemCount(){
        return items.size();
    }
}

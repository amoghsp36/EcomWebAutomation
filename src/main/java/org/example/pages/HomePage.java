package org.example.pages;

import org.example.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{


    By searchIcon=By.cssSelector("summary[aria-label='Search']");
    By searchBar=By.id("Search-In-Modal");
    By searchResults=By.cssSelector("li[id^='predictive-search-option'] a");
    By productName=By.cssSelector(".predictive-search_item-heading ");
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
        List<WebElement> elements=waits.waitUntilAllElementsAreVisible(searchResults);
        List<Item> items=new ArrayList<>();
        for(WebElement element:elements){
            String name=webDriver.findElement(productName).getText();
            Item item=new Item();
            item.setName(name);
            items.add(item);
        }
//        return new ArrayList<>();        //returns empty list
        return items;
    }

    public int getItemCount(){
        return 0;
    }
}

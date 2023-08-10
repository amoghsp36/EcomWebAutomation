package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected PageWaits waits;
    protected PageActions actions;
    protected WebDriver webDriver;
    public BasePage(WebDriver webDriver){
        this.waits=new PageWaits(webDriver);
        this.actions=new PageActions(webDriver);
        this.webDriver=webDriver;
    }
}

package org.example.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageActions {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private PageWaits pageWaits;
    public  PageActions(WebDriver webDriver){
        this.webDriver=webDriver;
        this.wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
        this.pageWaits=new PageWaits(webDriver);
    }
    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        webDriver.findElement(by).click();
    }
    public void safeClick(By by){
        pageWaits.waitForElementToBePresent(by).click();
    }
    public void type(By by, String value){
        //webDriver.findElement(by).sendKeys(value);
        pageWaits.waitForElementToBePresent(by).sendKeys(value);
    }
    public void executeJS(String script, Object... args){
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        js.executeScript(script,args);
    }
    public void takeScreenShot(String name){
        File takesScreenshot=((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(takesScreenshot,new File("/Users/testvagrant/desktop/"+name+".png"));
            System.out.println("SS saved successfully");
        }catch (IOException e){
            System.out.println("SS not saved "+e.getMessage());
        }
    }
    public void navigateTo(String url){
        webDriver.get(url);
    }
    public void refreshPage(){
        webDriver.navigate().refresh();
    }
    public void goBack(){
        webDriver.navigate().back();
    }
}

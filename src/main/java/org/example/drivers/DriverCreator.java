package org.example.drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverCreator {
//    WebDriver webDriver = new ChromeDriver();
//    public void getweb()
//    {
//        //webDriver.get("https://flipkart.com/");
//        webDriver.get("https://youtube.com/");
//    }

    public WebDriver create(String browser){
        switch (browser.toLowerCase()){
            case "edge":return new EdgeDriverManager().create();
            //case "edge":WebDriverManager.edgedriver().setup();


            case "firefox":return new FirefoxDriverManager().create();
            //case "firefox":WebDriverManager.firefoxdriver().setup();
            //default:WebDriver webDriver = new ChromeDriver();
            default:WebDriver webDriver=new ChromeDriverManager().create();
            return webDriver;

        }
    }

    public interface createWebDriverStrategies{
        WebDriver createWebDriver();
    }

    public class chromeWebDriverCreator implements createWebDriverStrategies{
        @Override
        public WebDriver createWebDriver(){
            return new ChromeDriver();
        }
    }
    public class FirefoxDriverCreator implements createWebDriverStrategies{
        @Override
        public WebDriver createWebDriver(){
            return new FirefoxDriver();
        }
    }

    public class WebDriverContext{
        private createWebDriverStrategies strategies;
        public void setStrategies(createWebDriverStrategies strategies){
            this.strategies=strategies;
        }
        public WebDriver createWebDrivers(){
            if(strategies==null){
                throw new IllegalStateException("Please specify a strategy");
            }
            return strategies.createWebDriver();
        }
    }
}

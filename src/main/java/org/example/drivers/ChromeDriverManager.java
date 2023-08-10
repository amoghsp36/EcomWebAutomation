package org.example.drivers;
import org.example.internal.Toggles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class ChromeDriverManager extends DriverCreator {
    @Override
    public WebDriver create(String browser) {
        if (Toggles.HEADLESS.isOn()) {
            return createHeadLessChromeDriver();
        }
        return new io.github.bonigarcia.wdm.managers.ChromeDriverManager().create();
    }

    private ChromeDriver createHeadLessChromeDriver() {
        new io.github.bonigarcia.wdm.managers.ChromeDriverManager().setup();
        ChromeOptions chromeOptions = getHeadlessChromeOptions();     //option for chromedriver
        return new ChromeDriver(chromeOptions);
    }

    private ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        return chromeOptions;
    }
}

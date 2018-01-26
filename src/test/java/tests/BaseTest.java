package tests;

import helpers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

/**
 * Created by michał on 1/25/2018.
 */
public class BaseTest {

    WebDriver driver;

    public WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else driver = new FirefoxDriver();

        return driver;

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}

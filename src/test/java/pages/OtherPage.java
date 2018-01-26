package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by michał on 1/25/2018.
 */
public class OtherPage {

    public static void selectCalculator(String calculator, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[text()='" + calculator + "']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='" + calculator + "']")));

    }

    public static void fillConcreteData(String length, String width, String thickness, String quantity, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("slablength")).clear();
        driver.findElement(By.id("slablength")).sendKeys(length);

        driver.findElement(By.id("slabwidth")).clear();
        driver.findElement(By.id("slabwidth")).sendKeys(width);

        driver.findElement(By.id("slabthick")).clear();
        driver.findElement(By.id("slabthick")).sendKeys(thickness);

        driver.findElement(By.id("slabquantity")).clear();
        driver.findElement(By.id("slabquantity")).sendKeys(quantity);

        driver.findElement(By.cssSelector("input[name=\"slabcal\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p font b")));

    }

    public static String getCalculationResult(WebDriver driver){

        return driver.findElement(By.cssSelector("p font b")).getText();

    }

}

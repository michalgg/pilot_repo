package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by michał on 1/25/2018.
 */
public class FitnessAndHealthPage {

    public static void selectCalculator(String calculator, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[text()='" + calculator + "']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='" + calculator + "']")));

    }

    public static void fillBMIData(String unitType, String age, String gender, String height, String weight, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[text()='" + unitType + "']")).click();

        driver.findElement(By.id("cage")).clear();
        driver.findElement(By.id("cage")).sendKeys(age);

        driver.findElement(By.xpath("//input[@value='" + gender  + "']")).click();

        driver.findElement(By.id("cheightmeter")).clear();
        driver.findElement(By.id("cheightmeter")).sendKeys(height);

        driver.findElement(By.id("ckg")).clear();
        driver.findElement(By.id("ckg")).sendKeys(weight);

        driver.findElement(By.cssSelector("input[alt='Calculate']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div font b")));

    }

    public static String getCalculationResult(WebDriver driver){

        return driver.findElement(By.cssSelector("div font b")).getText();

    }

}

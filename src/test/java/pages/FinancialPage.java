package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

/**
 * Created by michał on 1/25/2018.
 */
public class FinancialPage {

    public static void selectCalculator(String calculator, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[text()='"+calculator+"']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='" + calculator + "']")));

    }

    public static void fillMortgageData(String homePrice, String downPayment, String longTerm, String interestRate, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("chouseprice")).clear();
        driver.findElement(By.id("chouseprice")).sendKeys(homePrice);

        driver.findElement(By.id("cdownpayment")).clear();
        driver.findElement(By.id("cdownpayment")).sendKeys(downPayment);

        driver.findElement(By.id("cloanterm")).clear();
        driver.findElement(By.id("cloanterm")).sendKeys(longTerm);

        driver.findElement(By.id("cinterestrate")).clear();
        driver.findElement(By.id("cinterestrate")).sendKeys(interestRate);

        driver.findElement(By.cssSelector("input[alt='Calculate']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.h2result")));

    }

    public static String getCalculationResult(WebDriver driver){

        String result = driver.findElement(By.cssSelector("h2.h2result")).getText();

        return result.substring(result.indexOf("$") + 1);

    }

}

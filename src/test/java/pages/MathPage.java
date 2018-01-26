package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

/**
 * Created by michał on 1/25/2018.
 */
public class MathPage {

    public static void selectCalculator(String calculator, WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[text()='" + calculator + "']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='" + calculator + "']")));

    }

    public static void fillSciCalcData(String operation, String parameters, WebDriver driver){

        if (operation.equals("add")){
            performAddOperation(parameters, driver);
        } else if (operation.equals("multiply")){
            performMultiplyOperation(parameters, driver);
        }

    }

    public static String getCalculationResult(WebDriver driver){

        return driver.findElement(By.id("sciOutPut")).getText();

    }

    public static void resetResult(WebDriver driver){

        driver.findElement(By.xpath("//span[text()='C']")).click();

    }

    private static void performAddOperation(String parameters, WebDriver driver){

        List<String> values = Arrays.asList(parameters.split("\\|"));

        for (int i = 0; i < values.size() ; i ++){

            driver.findElement(By.xpath("//span[text()='"+ values.get(i).toString() +"']")).click();

            if (i == values.size() - 1){
                driver.findElement(By.xpath("//span[text()='=']")).click();
            } else driver.findElement(By.xpath("//span[text()='+']")).click();
        }

    }

    private static void performMultiplyOperation(String parameters, WebDriver driver){

        List<String> values = Arrays.asList(parameters.split("\\|"));

        for (int i = 0; i < values.size() ; i ++){

            driver.findElement(By.xpath("//span[text()='"+ values.get(i) +"']")).click();

            if (i == values.size() - 1){
                driver.findElement(By.xpath("//span[text()='=']")).click();
            } else driver.findElement(By.xpath("//span[contains(@onclick, '*')]")).click();
    }

    }


}

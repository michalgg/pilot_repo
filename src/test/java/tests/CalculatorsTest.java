package tests;

import helpers.ConfigReader;
import helpers.Utilities;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FinancialPage;
import pages.FitnessAndHealthPage;
import pages.MathPage;
import pages.OtherPage;

import java.util.Iterator;

/**
 * Created by michał on 1/25/2018.
 */
public class CalculatorsTest extends BaseTest {

    WebDriver driver;

    @BeforeClass
    public  void setUp(){
        driver = getDriver();
    }

    @Test(groups = "financialCalculatorTests", dataProvider = "mortgageCalculatorData")
    public void testMortgageCalculator(String homePrice, String downPayment, String longTerm, String interestRate, String expectedResult){

        driver.get(ConfigReader.getProperty("financialCalculatorUrl"));
        FinancialPage.selectCalculator("Mortgage Calculator", driver);
        FinancialPage.fillMortgageData(homePrice, downPayment, longTerm, interestRate, driver);
        Assert.assertEquals(expectedResult, FinancialPage.getCalculationResult(driver));
    }

    @Test(groups = "fitnessAndHealthCalculatorTests", dataProvider = "bmiCalculatorData")
    public void testBmiCalculator(String unitType, String age, String gender, String height, String weight, String expectedResult){

        driver.get(ConfigReader.getProperty("fitnessAndHealthCalculatorUrl"));
        FitnessAndHealthPage.selectCalculator("BMI Calculator", driver);
        FitnessAndHealthPage.fillBMIData(unitType, age, gender, height, weight, driver);
        Assert.assertEquals(expectedResult, FitnessAndHealthPage.getCalculationResult(driver));
    }

    @Test(groups = "mathCalculatorTests", dataProvider = "mathCalculatorData")
    public void testScientificCalculator(String operation, String parameters, String expectedResult){

        driver.get(ConfigReader.getProperty("mathCalculatorUrl"));
        MathPage.selectCalculator("Scientific Calculator", driver);
        MathPage.fillSciCalcData(operation, parameters, driver);

        Assert.assertEquals(expectedResult, MathPage.getCalculationResult(driver));

        MathPage.resetResult(driver);

    }

    @Test(groups = "otherCalculatorTests", dataProvider = "otherCalculatorData")
    public void testConcreteCalculator(String length, String width, String thickness, String quantity, String expectedResult){

        driver.get(ConfigReader.getProperty("otherCalculatorUrl"));

        OtherPage.selectCalculator("Concrete Calculator", driver);
        OtherPage.fillConcreteData(length, width, thickness, quantity, driver);
        Assert.assertEquals(expectedResult, OtherPage.getCalculationResult(driver));
    }



    @DataProvider(name = "mortgageCalculatorData")
    public Iterator<Object []> financialCalcProvider() throws InterruptedException
    {
        return  Utilities.getTestDataFromFile("mortgage_calc_testData").iterator();

    }

    @DataProvider(name = "bmiCalculatorData")
    public Iterator<Object []> fnaCalcProvider() throws InterruptedException
    {
        return  Utilities.getTestDataFromFile("bmi_calc_testData").iterator();

    }

    @DataProvider(name = "mathCalculatorData")
    public Iterator<Object []> mathCalcProvider() throws InterruptedException
    {
        return  Utilities.getTestDataFromFile("scientific_calc_testData").iterator();

    }

    @DataProvider(name = "otherCalculatorData")
    public Iterator<Object []> otherCalcProvider() throws InterruptedException
    {
        return  Utilities.getTestDataFromFile("concrete_calc_testData").iterator();

    }





}

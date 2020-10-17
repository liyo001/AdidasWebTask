package com.adidas.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adidas.qa.base.Base;

public class Utility extends Base {

    public static void clickByJS(WebDriver driver, By ele)

    {
        WebElement element = driver.findElement(ele);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By ele,
            int timeout) {
        WebElement element = driver.findElement(ele);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement waitedElement = wait
                .until(ExpectedConditions.visibilityOf(element));
        return waitedElement;
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver,
            By ele, int timeout) {
        WebElement element = driver.findElement(ele);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement waitedElement = wait
                .until(ExpectedConditions.elementToBeClickable(element));
        return waitedElement;
    }

    public static void sendKeyByJS(WebDriver driver, By ele, String txt)

    {
        WebElement element = driver.findElement(ele);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value=arguments[1]", element, txt);
    }

    public static void getscreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(
                System.getProperty("user.dir") + "/AdidasWeb/ScreenShot.png"));
    }
}

package com.factory.mortgagePaymentPage;

import com.factory.ISlider;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class PurchasePriceSlider implements ISlider {
    private WebDriverWait wait;

    @Override
    public void moveSliderRight(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, 10);

        WebElement priceSlider = findElement(By.xpath(locator));
        assertTrue(priceSlider.isDisplayed());

        Dimension sliderSize = priceSlider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = priceSlider.getLocation().getX();

        Actions builder = new Actions(driver);
        builder.moveToElement(priceSlider)
                .click()
                .dragAndDropBy
                        (priceSlider, xCoord + sliderWidth, 0)
                .build()
                .perform();
    }

    private WebElement findElement(By locator) {
        return
                wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
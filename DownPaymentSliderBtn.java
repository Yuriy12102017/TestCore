package com.factory.mortgagePaymentPage;

import com.factory.ISliderBtn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownPaymentSliderBtn implements ISliderBtn {

    @Override
    public void moveSliderRightBtn(WebDriver driver, int downPaymentValue) {
        for (int i = 0; i < downPaymentValue; i++) {
            WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(MortgageLocators.downPaymentBtn)));
            element.click();
        }
    }
}

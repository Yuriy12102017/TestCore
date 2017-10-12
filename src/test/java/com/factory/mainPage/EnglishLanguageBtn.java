package com.factory.mainPage;

import com.factory.ISelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnglishLanguageBtn implements ISelector {

    @Override
    public void selectElement(WebDriver driver) {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.engLanguageBtn)));
        element.click();
    }
}

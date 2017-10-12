package com.test;

import com.factory.ClassList;
import com.factory.ISelector;
import com.factory.ISlider;
import com.factory.ISliderBtn;
import com.factory.mainPage.Locators;
import com.factory.mainPage.MainPageFactory;
import com.factory.mortgagePage.MortgagePageFactory;
import com.factory.mortgagePaymentPage.AbstractFactory;
import com.factory.mortgagePaymentPage.FactoryProducer;
import com.factory.mortgagePaymentPage.MortgageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class Test01 {
    private WebDriver driver;

    @BeforeClass
    public void Before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Locators.url);
    }

    @AfterClass
    public void After() {
//        driver.quit();
    }


    @Test
    public void Test() {
        MainPageFactory mainPage = new MainPageFactory();

//1. Open the www.ia.ca in the Chrome browser
        ISelector step01 = mainPage.getSelector(ClassList.englishLanguageBtn);
        step01.selectElement(driver);

//2. Click LOANS
        ISelector step02 = mainPage.getSelector(ClassList.loansMenu);
        step02.selectElement(driver);

//3. Click the Mortgages link
        ISelector step03 = mainPage.getSelector(ClassList.productsMortgage);
        step03.selectElement(driver);

//4. Click the Calculate Your Payments button
        MortgagePageFactory mortgagePageFactory = new MortgagePageFactory();
        ISelector step04 = mortgagePageFactory.getSelector(ClassList.mortgagePaymentCalculator);
        step04.selectElement(driver);

//5. Move the Purchase Price slider to the right
        AbstractFactory Slider = FactoryProducer.getFactory(ClassList.slider);
        ISlider step05 = Slider.getSlider(ClassList.purchasePriceSlider);
        step05.moveSliderRight(driver, MortgageLocators.priceSliderLocator);

//6. Validate that the Purchase Price slider movement works
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement hiddenPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(MortgageLocators.hiddenPriceLocator)));
        assertEquals(Integer.parseInt(hiddenPrice.getAttribute("value")), MortgageLocators.expectedPriceValue);

//7. Change the Purchase Price to 500 000 using the + button of the slider
        AbstractFactory SliderBtn = FactoryProducer.getFactory(ClassList.sliderBtn);
        ISliderBtn step07 = SliderBtn.getSliderBtn(ClassList.purchasePriceSliderBtn);
        step07.moveSliderRightBtn(driver, MortgageLocators.purchaseValue);

//8. Change the Down Payment to 50 000 using the + button of the slider
        ISliderBtn step08 = SliderBtn.getSliderBtn(ClassList.downPaymentSliderBtn);
        step08.moveSliderRightBtn(driver, MortgageLocators.downPaymentValue);
    }
}

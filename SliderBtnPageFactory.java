package com.factory.mortgagePaymentPage;

import com.factory.ClassList;
import com.factory.ISlider;
import com.factory.ISliderBtn;


public class SliderBtnPageFactory extends AbstractFactory{

    @Override
    public ISliderBtn getSliderBtn(String locatorType) {
        if (locatorType == null) {
            return null;
        }
        if (locatorType.equalsIgnoreCase(ClassList.purchasePriceSliderBtn)) {
            return new PurchasePriceSliderBtn();

        } else if (locatorType.equalsIgnoreCase(ClassList.downPaymentSliderBtn)) {
            return new DownPaymentSliderBtn();
        }
        return null;
    }

    @Override
    public ISlider getSlider(String locatorType){
        return null;
    }
}

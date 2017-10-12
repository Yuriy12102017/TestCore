package com.factory.mortgagePaymentPage;

import com.factory.ClassList;
import com.factory.ISlider;
import com.factory.ISliderBtn;


public class SliderPageFactory extends AbstractFactory {

    @Override
    public ISlider getSlider(String locatorType) {
        if (locatorType == null) {
            return null;
        }
        if (locatorType.equalsIgnoreCase(ClassList.purchasePriceSlider)) {
            return new PurchasePriceSlider();

        } else if (locatorType.equalsIgnoreCase(ClassList.downPaymentSlider)) {
            return new DownPaymentSlider();
        }
        return null;
    }

    @Override
    public ISliderBtn getSliderBtn(String locatorType) {
        return null;
    }
}

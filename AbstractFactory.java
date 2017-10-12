package com.factory.mortgagePaymentPage;

import com.factory.ISlider;
import com.factory.ISliderBtn;

public abstract class AbstractFactory {
    public abstract ISlider getSlider(String locatorType);
    public abstract ISliderBtn getSliderBtn(String locatorType) ;
}
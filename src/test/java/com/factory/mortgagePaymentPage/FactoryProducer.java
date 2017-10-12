package com.factory.mortgagePaymentPage;

import com.factory.ClassList;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase(ClassList.sliderBtn)) {
            return new SliderBtnPageFactory();

        } else if (choice.equalsIgnoreCase(ClassList.slider)) {
            return new SliderPageFactory();
        }

        return null;
    }
}
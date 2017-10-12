package com.factory.mortgagePage;

import com.factory.ISelector;

public class MortgagePageFactory {

    public ISelector getSelector(String locatorType) {
        if (locatorType == null) {
            return null;
        }
        if (locatorType.equalsIgnoreCase("mortgagePaymentCalculator")) {
            return new MortgagePaymentCalculator();
        }
        return null;
    }
}

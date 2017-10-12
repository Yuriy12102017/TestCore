package com.factory.mainPage;

import com.factory.ClassList;
import com.factory.ISelector;

public class MainPageFactory {

    public ISelector getSelector(String locatorType) {
        if (locatorType == null) {
            return null;
        }
        if (locatorType.equalsIgnoreCase(ClassList.englishLanguageBtn)) {
            return new EnglishLanguageBtn();

        } else if (locatorType.equalsIgnoreCase(ClassList.loansMenu)) {
            return new LoansMenu();

        } else if (locatorType.equalsIgnoreCase(ClassList.productsMortgage)) {
            return new ProductsMortgage();
        }
        return null;
    }
}

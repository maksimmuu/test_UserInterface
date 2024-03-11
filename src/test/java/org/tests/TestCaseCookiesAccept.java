package org.tests;

import org.example.forms.CookiesForm;
import org.example.forms.FirstCardForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseCookiesAccept extends BaseTest {

    @Test
    public void testCookiesAccept() {
        FirstCardForm firstCardForm = new FirstCardForm();
        Assert.assertTrue(firstCardForm.state().waitForDisplayed(), "Страница с первой карточкой не отобразилась");

        CookiesForm cookiesForm = new CookiesForm();
        cookiesForm.state().waitForDisplayed();

        cookiesForm.acceptCookies();

        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), "Форма с подтверждением cookies отображена");
    }
}

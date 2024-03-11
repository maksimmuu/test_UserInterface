package org.example.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton acceptCookies = getElementFactory().getButton(By.xpath("//button[contains(@class,'transparent')]"), "Accept cookies button");

    public CookiesForm() {
        super(By.xpath("//p[contains(@class,'cookies')]"), "Cookies form");
    }

    public void acceptCookies() {
        acceptCookies.click();
    }
}

package org.example.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final IButton close = getElementFactory().getButton(By.xpath("//button[contains(@class,'send')]"), "Close help form");

    public HelpForm() {
        super(By.xpath("//div[@class='help-form']"), "Help form");
    }

    public void closeHelpForm() {
        close.click();
    }
}

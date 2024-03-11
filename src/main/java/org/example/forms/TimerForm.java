package org.example.forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TimerForm extends Form {

    private final ILabel timer = getElementFactory().getLabel(this.getLocator(), "Timer");

    public TimerForm() {
        super(By.xpath("//div[contains(@class,'timer--center')]"), "Timer form");
    }

    public String getCurrentValueTimer() {
        return timer.getText();
    }
}

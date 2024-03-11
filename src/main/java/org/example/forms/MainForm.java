package org.example.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainForm extends Form {

    private final IButton here = getElementFactory().getButton(By.xpath("//a[contains(@class,'start')]"), "Here button");

    public MainForm() {
        super(By.xpath("//div[contains(@class,'start')]"), "Main page");
    }

    public void clickHereButton() {
        here.click();
    }
}

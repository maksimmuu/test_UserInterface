package org.example.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class SecondCardForm extends Form {

    private final IButton upload = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload-button')]"), "Upload button");
    private final IButton next = getElementFactory().getButton(By.xpath("//button[contains(@class,'stroked')]"), "Next button");
    private final By interests = By.xpath("//div[contains(@class,'interests')]//label");

    public SecondCardForm() {
        super(By.xpath("//div[@class='avatar-and-interests']"), "Second card form");
    }

    public void selectCheckBox(ICheckBox checkBox) {
        checkBox.check();
    }

    public List<ICheckBox> getInterestsCheckBoxList() {
        return getElementFactory().findElements(interests, ElementType.CHECKBOX);
    }

    public void clickUploadButton() {
        upload.click();
    }

    public void clickNextButton() {
        next.click();
    }
}

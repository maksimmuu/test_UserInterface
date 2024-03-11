package org.example.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class FirstCardForm extends Form {

    private final ITextBox inputPassword = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Input password");
    private final ITextBox inputEmail = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Input email");
    private final ITextBox inputDomain = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Input domain");
    private final IButton domainList = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "Domain list");
    private final ICheckBox termsAndConditions = getElementFactory().getCheckBox(By.xpath("//label[contains(@for,'accept-terms')]"), "Terms and Condition checkbox");
    private final IButton next = getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"), "Next button");
    private final By domains = By.xpath("//div[contains(@class,'list-item')]");

    public FirstCardForm() {
        super(By.xpath("//div[contains(@class,'fields')]"), "First card form");
    }

    public void enterPassword(String password) {
        inputPassword.clearAndTypeSecret(password);
    }

    public void enterEmail(String email) {
        inputEmail.clearAndType(email);
    }

    public void enterDomain(String domain) {
        inputDomain.clearAndType(domain);
    }

    public void openDomainList() {
        domainList.click();
    }

    public List<IButton> getDomainList() {
        return getElementFactory().findElements(domains, ElementType.BUTTON);
    }

    public void acceptTermsAndConditions() {
        termsAndConditions.check();
    }

    public void clickNextButton() {
        next.click();
    }
}

package org.example.steps;

import aquality.selenium.elements.interfaces.IButton;
import org.example.constants.TestConstants;
import org.example.forms.FirstCardForm;
import java.util.List;
import java.util.Random;

public class FirstCardFormSteps {

    private final FirstCardForm firstCardForm;

    public FirstCardFormSteps() {
        firstCardForm = new FirstCardForm();
    }

    public void login(String password, String email, String domain) {
        firstCardForm.enterPassword(password);
        firstCardForm.enterEmail(email);
        firstCardForm.enterDomain(domain);
        this.selectRandomDomain();
        firstCardForm.acceptTermsAndConditions();
        firstCardForm.clickNextButton();
    }

    public void selectRandomDomain() {
        firstCardForm.openDomainList();
        List<IButton> domainList = firstCardForm.getDomainList();
        Random random = new Random();

        while (true) {
            int randomIndex = random.nextInt(domainList.size());
            if (!domainList.get(randomIndex).getText().contains(TestConstants.TEXT_UNWANTED_DOMAIN)) {
                domainList.get(randomIndex).click();
                break;
            }
        }
    }
}

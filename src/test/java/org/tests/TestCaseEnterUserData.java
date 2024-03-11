package org.tests;

import org.example.constants.TestConstants;
import org.example.forms.SecondCardForm;
import org.example.forms.ThirdCardForm;
import org.example.steps.FirstCardFormSteps;
import org.example.steps.SecondCardFormSteps;
import org.example.utils.DataGenerator;
import org.testng.Assert;
import org.example.forms.FirstCardForm;
import org.testng.annotations.Test;
import java.awt.*;

public class TestCaseEnterUserData extends BaseTest{

    @Test
    public void testEnterUserData() throws AWTException {
        FirstCardForm firstCardForm = new FirstCardForm();
        Assert.assertTrue(firstCardForm.state().waitForDisplayed(), "Первая карточка не открылась");

        FirstCardFormSteps firstCardFormSteps = new FirstCardFormSteps();

        firstCardFormSteps.login(DataGenerator.generatePassword(TestConstants.LENGTH_PASSWORD_NOT_LESS),
                DataGenerator.generateEmail(TestConstants.LENGTH_EMAIL), DataGenerator.generateDomain());

        SecondCardForm secondCardForm = new SecondCardForm();
        Assert.assertTrue(secondCardForm.state().waitForDisplayed(), "Вторая карточка не открылась");

        SecondCardFormSteps secondCardFormSteps = new SecondCardFormSteps();
        secondCardFormSteps.unselectAllInterests();
        secondCardFormSteps.selectInterests(TestConstants.NUMBER_OF_INTERESTS);
        secondCardFormSteps.uploadImage(TestConstants.PATH_TO_IMAGE);

        secondCardForm.clickNextButton();

        ThirdCardForm thirdCardForm = new ThirdCardForm();
        Assert.assertTrue(thirdCardForm.state().waitForDisplayed(), "Третья карточка не открылась");
    }
}

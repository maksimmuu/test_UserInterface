package org.tests;

import org.example.forms.FirstCardForm;
import org.example.forms.HelpForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseCloseHelpForm extends BaseTest {

    @Test
    public void testCloseHelpForm() {
        FirstCardForm firstCardForm = new FirstCardForm();
        Assert.assertTrue(firstCardForm.state().waitForDisplayed(), "Страница с первой карточкой не отобразилась");

        HelpForm helpForm = new HelpForm();
        helpForm.closeHelpForm();

        Assert.assertTrue(helpForm.state().waitForNotDisplayed(), "Форма помощи не скрыта");
    }
}

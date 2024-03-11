package org.tests;

import org.example.constants.TestConstants;
import org.example.forms.FirstCardForm;
import org.example.forms.TimerForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTimerCheckStartTime extends BaseTest {

    @Test
    public void testTimerCheckStartTime() {
        FirstCardForm firstCardForm = new FirstCardForm();
        Assert.assertTrue(firstCardForm.state().waitForDisplayed(), "Страница с первой карточкой не отобразилась");

        TimerForm timerForm = new TimerForm();

        Assert.assertEquals(timerForm.getCurrentValueTimer(), TestConstants.TIMER_START_TIME, String.format("Таймер начинается не с '%s'", TestConstants.TIMER_START_TIME));
    }
}

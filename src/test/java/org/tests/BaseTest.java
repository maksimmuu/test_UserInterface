package org.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.example.constants.ConfigConstants;
import org.example.forms.MainForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        ISettingsFile settingsFile = new JsonSettingsFile(ConfigConstants.SETTINGS_FILE_NAME);
        String URL = settingsFile.getValue(ConfigConstants.URL_VALUE).toString();
        AqualityServices.getBrowser().goTo(URL);
        AqualityServices.getBrowser().maximize();

        MainForm mainForm = new MainForm();
        Assert.assertTrue(mainForm.state().waitForDisplayed(), "Главная страница не отобразилась");
        mainForm.clickHereButton();
    }

    @AfterMethod
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}

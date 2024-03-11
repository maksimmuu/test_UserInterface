package org.example.steps;

import aquality.selenium.elements.interfaces.ICheckBox;
import org.example.constants.HtmlAttributeConstants;
import org.example.constants.TestConstants;
import org.example.forms.SecondCardForm;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class SecondCardFormSteps {

    private final SecondCardForm secondCardForm;

    public SecondCardFormSteps() {
        secondCardForm = new SecondCardForm();
    }

    public void selectInterests(int numberOfInterests) {
        List<ICheckBox> checkBoxList = secondCardForm.getInterestsCheckBoxList();
        Random random = new Random();

        for (int i = 0; i < numberOfInterests; i++) {

            while (true) {
                int randomIndex = random.nextInt(checkBoxList.size());
                if (!checkBoxList.get(randomIndex).getAttribute(HtmlAttributeConstants.ATTRIBUTE_HTML_FOR).contains(TestConstants.TEXT_UNWANTED_CHECKBOX)) {
                    secondCardForm.selectCheckBox(checkBoxList.get(randomIndex));
                    checkBoxList.remove(randomIndex);
                    break;
                }
            }
        }
    }

    public void unselectAllInterests() {
        List<ICheckBox> checkBoxList = secondCardForm.getInterestsCheckBoxList();

        for (ICheckBox iCheckBox : checkBoxList) {
            if (iCheckBox.getAttribute(HtmlAttributeConstants.ATTRIBUTE_HTML_FOR).contains(TestConstants.TEXT_UNSELECT_ALL_CHECKBOX)) {
                secondCardForm.selectCheckBox(iCheckBox);
            }
        }
    }

    public void uploadImage(String pathToImage) throws AWTException {
        secondCardForm.clickUploadButton();
        StringSelection selection = new StringSelection(pathToImage);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        robot.delay(TestConstants.ROBOT_DELAY);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}

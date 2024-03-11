package org.example.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdCardForm extends Form {

    public ThirdCardForm() {
        super(By.xpath("//div[contains(@class,'form-table')]"), "Third card form");
    }
}

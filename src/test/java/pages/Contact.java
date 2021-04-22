package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class Contact extends BasePage{


    public Contact(){super();}

    @FindBy(css ="[title=\"Contact Us\"]")

    private WebElement btnContactUs;


    @Step

    public ContactUs openContactUs(){

        btnContactUs.click();
        captureScreenshot();


        return new ContactUs();
    }


}
